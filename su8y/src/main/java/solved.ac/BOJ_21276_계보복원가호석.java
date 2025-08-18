package solved.ac;

import java.io.*;
import java.util.*;

class XY {
    public int x, y;

    XY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Test {
    private final String[] names;
    private final int[] degrees;
    private final int[] parents;
    private final Map<String, Integer> nameIndex = new HashMap<>();

    Test(int n, List<String> names) {
        this.names = names.toArray(new String[n]);
        names.forEach(name -> nameIndex.put(name, nameIndex.size()));
        degrees = new int[n];
        parents = new int[n];
    }

    public void printParent(final Writer writer) throws IOException {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) result.add(names[i]);
        }
        result.sort(Comparator.comparing(name -> name));
        writer.write(result.size());
        writer.write("\n");
        writer.write(String.join(" ", result));
    }

    public int grouping(String child, String parent) {
        union(nameIndex.get(child), nameIndex.get(parent));
        return 1;
    }

    private void union(int x, int y) {
        degrees[y]++; // 조상에 대한 진입 차수 증가
        int ux = find(x);
        int uy = find(y);
        if (ux == uy) {
            parents[x] = y;
            return;
        }

        if (degrees[ux] < degrees[uy]) { // 진입 차수가 많은 노드의 이름으로 합치기 위해
            int tmp = ux;
            ux = uy;
            uy = tmp;
        }
        parents[ux] = uy;
    }

    private int find(int x) {
        if (parents[x] == x) return x;
        parents[x] = find(parents[x]);
        return parents[x];
    }

}

public class BOJ_21276_계보복원가호석 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<String> nameList = Arrays.stream(br.readLine().split(" ")).toList();

        Test test = new Test(n, nameList);

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String[] relation = br.readLine().split(" ");
            test.grouping(relation[0], relation[1]);
        }

        test.printParent(bw);
        bw.close();
        br.close();


    }
}