package solved.ac;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 이항계수2_11051 {
    static int K, N, M, T;

    /**
     * @return
     */
    static BigInteger[] dp = new BigInteger[1001];

    private static BigInteger factorial(int n) {
        if (dp[n] != null) return dp[n];

        return dp[n] = factorial(n - 1).multiply(BigInteger.valueOf(n));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        dp[0] = BigInteger.valueOf(1);
        dp[1] = BigInteger.valueOf(1);
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(factorial(N).divide(factorial(N - K)).divide(factorial(K)).mod(BigInteger.valueOf(10007)));


        bw.close();
        br.close();
    }
}