package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 크루스칼 {
    //    static List<Pair> adj; // x 는 간선 y 는 비용
    static int[] adjs;
    static int final_cost = 0;
    static int n;
    static int e_n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 컴퓨터의 수

        // 간선 초기화 index는 1부터 시작
        adjs = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adjs[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        e_n = Integer.parseInt(st.nextToken()); // 연결된 간선의 수

        // 간선 리스트
        List<Pair<Integer, Pair<Integer, Integer>>> edges = new ArrayList<>();

        // edges 초기화 index는 1부터 시작

        for (int i = 0; i <= n; i++) edges = new ArrayList<>();
        for (int i = 0; i < e_n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Pair(c, new Pair(a, b)));
        }

        final_cost = kruskal(edges);
        System.out.println(final_cost);


    }

    private static int kruskal(List<Pair<Integer, Pair<Integer, Integer>>> edges) {
        int res = 0;
        //작은 순서대로 정렬을 하고
        Collections.sort(edges, (o1, o2) -> o1.getX() - o2.getX());
        //작은것들의 간선 b 와 c가 cycle이 생기는지 검사를 한다.
        for (var edge : edges) {
            Pair here = edge.getY();
            int u = (int) here.getX();
            int v = (int) here.getY();
            if (find(u) == find(v)) continue;
            union(u, v);
            res += edge.getX();
        }

        return res;
    }

    public static int find(int u) {
        if (adjs[u] == u) return u;
        return adjs[u] = find(adjs[u]);
    }

    public static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        if (v < u) {
            int tmp = v;
            v = u;
            u = tmp;
        }
        adjs[u] = v;
    }

    private static class Pair<V, T> {
        V x;
        T y;

        public Pair(V x, T y) {
            this.x = x;
            this.y = y;
        }

        public V getX() {
            return x;
        }

        public void setX(V x) {
            this.x = x;
        }

        public T getY() {
            return y;
        }

        public void setY(T y) {
            this.y = y;
        }
    }
}
