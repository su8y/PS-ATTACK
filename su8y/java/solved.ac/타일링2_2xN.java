package solved.ac;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 타일링2_2xN {
    static int N, M;
    static double[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        dp = new double[N + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 3;
////        for (int i = 3; i <= N; i++) {
////            dp[i] = dp[i-1] + (dp[i-2] * 2);
////        }
////        System.out.println(dp[N]%10007);
        Arrays.fill(dp, 0);
        dp[1] = 1;
        dp[2] = 3;
        System.out.println(so(N));
    }

    private static double so(int N) {
        if (dp[N] != 0) return dp[N];
        if (N < 3) return dp[N];
        return dp[N] = (so(N - 1) + (so(N - 2) * 2)) % 10007;
    }
}