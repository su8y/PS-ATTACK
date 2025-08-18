package solved.ac;

import java.io.*;
import java.util.StringTokenizer;

public class 유기농배추_1012 {
    final private static int[] dy = {1, 0, -1, 0};
    final private static int[] dx = {0, 1, 0, -1};
    static int K, N, M, T;
    /**
     * 유기농 배추 (1012)
     * 전형적인 네트워크 문제이고 배추들이 어떤 집합에 속해있는지 구해내면되는 문제이다.
     * 그렇다면 어떻게 어떤 집합에 속해있는지 알게할수있을까?
     * 집합을 다루는 것을 사용해 인접해있는 노드가 있다면 같은 노드를 바라보게 한다.
     * <p>
     * dfs 로 간단하게 풀수있을거 같다.
     *
     * @return 집합의 개수
     */
    private static int[][] graph;
    private static boolean[][] visited;

    private static int solve(int y, int x) {
        visited = new boolean[y][x];

        int res = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    dfs(i, j);
                    res = res + 1;
                }

            }
        }
        return res;
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (nextY >= 0 && nextY < visited.length
                    && nextX >= 0 && nextX < visited[0].length
            ) {
                if (!visited[nextY][nextX]
                        && graph[nextY][nextX] == 1) {

                    dfs(nextY, nextX);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y_len = Integer.parseInt(st.nextToken());
            int x_len = Integer.parseInt(st.nextToken());
            graph = new int[y_len][x_len];
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }
            int res = solve(y_len, x_len);
            bw.write(res + "\n");
        }

        bw.close();
        br.close();
    }
}