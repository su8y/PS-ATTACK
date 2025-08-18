package solved.ac;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {

    final static int[] dx = {1, 0, -1, 0};
    final static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    private static final int[][] request = {
            {1, 0, 1},
            {0, 0, 0},
            {0, 1, 1},

    };
    private static UnionFind uf;

    private static int largestIsland(int[][] request) {
        int n = request.length;
        int len = request[0].length;
        int ans = 1;
        uf = new UnionFind(request);
        visited = new boolean[n][len];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < len; x++) {
                if (request[y][x] == 1) {
                    ans = Math.max(dfs(y, x, request), ans);
                }
            }
        }

        // logic
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < len; x++) {
                if (request[y][x] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int res = 1; // 우선 크기는 1
                    for (int i = 0; i < 4; i++) {
                        int nxtY = y + dy[i];
                        int nxtX = x + dx[i];
                        if (nxtY >= 0 && nxtY < request.length && nxtX >= 0 && nxtX < request[0].length && request[nxtY][nxtX] == 1) {
                            int nxtK = uf.find(nxtY * n + nxtX);
                            if (!set.contains(nxtK)) {
                                set.add(nxtK);
                                res += uf.get(nxtY, nxtX);
                            }
                        }
                    }
                    ans = Math.max(res, ans);

                }//exit if
            }
        }
        System.out.println(ans);


        return ans;
    }

    private static int dfs(int y, int x, int[][] request) {
        int ans = 1;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nxtY = y + dy[i], nxtX = x + dx[i];
            if (nxtY < 0 || nxtY >= request.length || nxtX < 0 || nxtX >= request[0].length || visited[nxtY][nxtX])
                continue;
            if (request[nxtY][nxtX] == 1) {

                ans = Math.max(uf.union(y, x, nxtY, nxtX), ans);
                ans = Math.max(dfs(nxtY, nxtX, request), ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int result = largestIsland(request);
    }

    static class UnionFind {
        int[] root;
        int[] count;
        int n;
        int xn;

        public UnionFind(int[][] request) {
            n = request.length;
            xn = request[0].length;
            root = new int[n * xn];
            count = new int[n * xn];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < xn; j++) {
                    int k = i * n + j;
                    root[k] = k;
                    if (request[i][j] == 1) {
                        count[k] = 1;
                    }
                }
            }
        }

        public int find(int u) {
            if (u == root[u]) return u;
            return root[u] = find(root[u]);
        }

        public int union(int columnU, int rowU, int columnV, int rowV) {
            int u = columnU * n + rowU;
            int v = columnV * n + rowV;
            u = find(u);
            v = find(v);
            if (u == v) return 0;
            if (count[u] < count[v]) {
                int tmp = u;
                u = v;
                v = tmp;
            }
            root[v] = u;
            count[u] += count[v];

            return count[u];
        }

        public int get(int y, int x) {
            int k = find(y * n + x);
            return count[k];
        }

    }
}
