package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }


        int[] dp = new int[n + 1];
        dp[0] = arr[0];
        dp[1] = arr[1];
        if (n >= 2) {
            dp[2] = arr[2] + arr[1];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max((dp[i - 2] + arr[i]), (dp[i - 3] + arr[i] + arr[i - 1]));
        }
        System.out.println(dp[n]);
    }
}
