package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 연결요소의_개수_11724 {

    private static List<Boolean> visited;
    private static List<List<Integer>> graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v, e;
        String[] input = br.readLine().split(" ");
        v = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);

        visited = new ArrayList<>(v + 1);
        graph = new ArrayList<>(v + 1);

        for (int i = 0; i <= v; i++) {
            visited.add(false);
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int[] inputVE = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            initialGraph(inputVE);
        }
        System.out.println(dfsAll());


    }

    private static int dfsAll() {
        int count = 0;
        for (int i = 1; i < visited.size(); ++i) {
            if (!visited.get(i)) {
                ++count;
                dfs(i);
            }
        }
        return count;
    }

    private static void dfs(int here) {
        visited.set(here, true);

        for (int i = 0; i < graph.get(here).size(); ++i) {
            int there = graph.get(here).get(i);
            if (!visited.get(there)) {
                dfs(there);
            }
        }

    }

    private static void initialGraph(int[] inputVE) {
        try {
//            graph.set(inputVE[0], new ArrayList<Integer>(inputVE[1]));
            graph.get(inputVE[0]).add(inputVE[1]);
            graph.get(inputVE[1]).add(inputVE[0]);
//            graph.set(inputVE[1], new ArrayList<>(inputVE[0]));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
