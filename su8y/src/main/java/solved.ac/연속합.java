package solved.ac;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속합 {
    static int N, M;
    static int[] arr;
    static int sum;
    static int[] dp = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = arr[0];
        dpf(N - 1);
        System.out.println(Arrays.stream(dp).max().getAsInt());


    }

    private static int dpf(int n) {
        if (n == 0 || dp[n] > Integer.MIN_VALUE) return dp[n];

        return dp[n] = Math.max(dpf(n - 1) + arr[n], arr[n]);
    }

    private static int bf() {
        if (arr.length == 0) return 0;
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                ret = Math.max(ret, sum);
            }
        }
        return ret;
    }

}