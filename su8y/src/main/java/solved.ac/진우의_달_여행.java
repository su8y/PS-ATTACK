package solved.ac;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class 진우의_달_여행 {
    static final int INF = 9999999;
    static int N, M;
    static int[][] map;
    static int[][][] dp;
    static int[] dc = {-1, 0, 1};
    static int min = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int z = 0; z < 3; z++) {
                    dp[i][j][z] = INF;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int sol = 999999;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                sol = min(sol, solve(N - 1, i, j));
            }
        }
        System.out.println(sol);

        for (int z = 0; z < 3; z++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(dp[i][j][z] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    private static int solve(int n, int m, int dir) {
        if (m < 0 || m >= M) return INF;
        if (n == 0) return dp[n][m][dir] = map[n][m];
        int ret = dp[n][m][dir];
        if (ret != INF) return ret;

        for (int i = 0; i < 3; i++) {
            if (i == dir) continue;
            ret = min(ret, map[n][m] + solve(n - 1, m + dc[i], i));
        }
        return dp[n][m][dir] = ret;
    }

    private static int solve2(int n, int m, int dir) {
        if (m < 0 || m >= M) return INF;
        if (n == 0) return dp[n][m][dir] = map[n][m];

        for (int i = 0; i < 3; i++) {
            if (i == dir) continue;
            min(min, map[n][m] + solve(n - 1, m + dc[i], i));
        }
        return min;
    }
}
