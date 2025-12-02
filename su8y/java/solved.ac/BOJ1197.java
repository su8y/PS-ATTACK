package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1197 {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e_n = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

//        int[][] adjs = new int[n+1][3];
        List<Tuple> adjs = new ArrayList<>();
        for (int i = 0; i < e_n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjs.add(new Tuple(u, v, c));
//            adjs[i][0] = u;
//            adjs[i][1] = v;
//            adjs[i][2] = c;
        }
        int res = kruskal(adjs);
        System.out.println(res);

    }

    private static int kruskal(List<Tuple> adjs) {
        int res = 0;
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        Collections.sort(adjs, (o1, o2) -> o1.z - o2.z);
        for (Tuple adj : adjs) {
            if (find(adj.x) == find(adj.y)) continue;
            union(adj.x, adj.y);
            res += adj.z;
        }

        return res;
    }

    private static int kruskal(int[][] adjs) {
        //parent 초기화
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        int res = 0;
        Arrays.sort(adjs, (o1, o2) -> o1[2] - o2[2]);

        for (int[] adj : adjs) {
            int u = adj[0];
            int v = adj[1];
            int c = adj[2];
            if (find(u) == find(v)) continue;
            union(u, v);
            res += c;
        }


        return res;
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;

//        if(u > v){
//            int tmp = u;
//            u = v;
//            v = tmp;
//        }
        parent[u] = v;
    }

    private static int find(int u) {
        if (u == parent[u]) return u;

        return parent[u] = find(parent[u]);
    }

    static class Tuple {
        int x;
        int y;
        int z;

        public Tuple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }
    }

}
