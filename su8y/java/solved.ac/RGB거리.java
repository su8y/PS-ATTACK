package solved.ac;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RGB거리 {
    static int[][] arr = new int[1000][3];
    static int[][] dp = new int[1000][3];
    private static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int j = 0; j < n; j++) {
            arr[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        }
        int result = Math.min(solve(0, 0), solve(0, 1));
        result = Math.min(result, solve(0, 2));
        System.out.println(result);

    }

    public static int solve(int j, int x) {
        if (j >= n) return 0;
        if (dp[j][x] != 0) return dp[j][x];
        if (x == 0) return dp[j][x] = (Math.min(solve(j + 1, 1), solve(j + 1, 2))) + arr[j][x];
        if (x == 1) return dp[j][x] = (Math.min(solve(j + 1, 0), solve(j + 1, 2))) + arr[j][x];
        if (x == 2) return dp[j][x] = (Math.min(solve(j + 1, 0), solve(j + 1, 1))) + arr[j][x];
        return 0;
    }

}
