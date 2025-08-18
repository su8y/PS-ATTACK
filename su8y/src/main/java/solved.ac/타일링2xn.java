package solved.ac;

import java.util.Arrays;
import java.util.Scanner;

public class 타일링2xn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }

    public static long solve(int n) {
        // d[n] = d[n-1] + d[n-2]
        long[] tpt = {1, 2, 3};
        long[] dp = Arrays.copyOf(tpt, n);
        if (n <= 3) return tpt[n - 1];

        for (int i = 3; i < n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }

        return dp[n - 1];
    }
}
