package solved.ac;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class 욕심쟁이_판다_1937 {
    static int K, N, M, T;

    /**
     * 판다의 이동경로 최대값
     * input :
     * 4
     * 14 9 12 10
     * 1 11 5 4
     * 7 15 2 13
     * 6 3 16 8
     * result : 4
     * 이미 한번 확인한 값은 dp배열에 저장해두고 한번더 방문할 시에 현재깊이(deps)와 해당 dp배열(dp[y][x])를 더한값을 리턴해준다.
     * 시간복잡도 O(N*M)
     *
     * @return
     */
    static int[][] dp = new int[501][501];
    static int[][] dx = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    static int[][] graph;

    public static int dfs(int y, int x, int deps) {
        int max = 0;
        if (dp[y][x] != -1) return dp[y][x];
        for (int i = 0; i < 4; i++) {
            int nextY = y + dx[i][0];
            int nextX = x + dx[i][1];
            if (isExist(nextY, nextX) && graph[y][x] < graph[nextY][nextX]) {
                max = max(max, dfs(nextY, nextX, 1));
            }
        }

        return dp[y][x] = max + deps;
    }

    public static boolean isExist(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0; i < 501; i++) {
            Arrays.fill(dp[i], -1);
        }

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = max(max, dfs(i, j, 1));
            }
        }
        bw.write(max + "\n");


        bw.close();
        br.close();
    }
}