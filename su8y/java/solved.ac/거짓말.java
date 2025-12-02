package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Uf {
    static int[] parent;
    static boolean[] persons;

    public Uf(int n) {
        parent = new int[n + 1];
        persons = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    boolean checkLiar(int u) {
        return persons[find(u)];
    }

    int find(int u) {
        if (parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }

    void merge(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        if (persons[u]) {
            int tmp = v;
            v = u;
            u = tmp;
        }
        parent[u] = v;
    }
}

public class 거짓말 {

    private static List<List<Integer>> map;
    private static int N;
    private static int M;
    private static Uf uf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        uf = new Uf(N);

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < c; i++) {
            Uf.persons[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int person_count = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < person_count; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            map.add(list);
        }
        init(map);
        int res = calc(map);
        System.out.println(res);

    }

    private static int calc(List<List<Integer>> map) {
        int answer = 0;
        for (List<Integer> list : map) {
            boolean b = false;
            for (int i = 0; i < list.size(); i++) {
                if (uf.checkLiar(list.get(i))) {
                    b = true;
                    break;
                }
            }
            if (!b) answer += 1;
        }
        return answer;

    }

    private static void init(List<List<Integer>> map) {
        for (List<Integer> list : map) {
            if (list.size() > 1)
                for (int i = 0; i < list.size() - 1; i++) uf.merge(list.get(i), list.get(i + 1));
        }

    }
}
