package solved.ac;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class 뮤탈리스크 {
    static int A, B, C, D, E, F, G, H, I, J, K, L, N, M, O, P, Q, R, S, T, U, V, W, X, Y, Z;
    static int[][] cache;
    static int[][] attack = {
            {9, 3, 1},
            {9, 1, 3},
            {1, 9, 3},
            {1, 3, 9},
            {3, 9, 1},
            {3, 1, 9},

    };
    static int[][][] dp = new int[61][61][61];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] s = new int[3];
        int[] s1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.arraycopy(s1, 0, s, 0, s1.length);
        System.out.println(rec(s[0], s[1], s[2]));

        bw.close();
        br.close();
    }

    private static int rec(int a, int b, int c) {
        if (a <= 0 && b <= 0 && c <= 0) return 0;
        if (dp[a][b][c] != 0) return dp[a][b][c];

        int ret = 9999;
        for (int i = 0; i < 6; i++) {
            dp[a][b][c] = min(ret, rec(
                    a - attack[i][0] <= 0 ? 0 : a - attack[i][0],
                    b - attack[i][1] <= 0 ? 0 : b - attack[i][1],
                    c - attack[i][2] <= 0 ? 0 : c - attack[i][2]) + 1
            );
            ret = min(ret, dp[a][b][c]);
        }


        return ret;
    }
}