package solved.ac;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정수삼각형 {
    static int[][] arr = new int[501][501];
    static int[][] dp = new int[501][501];
    private static int n;

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int y = 0; y < n; y++) {
            int x = 0;
            String[] nums = br.readLine().split(" ");
            for (String num : nums) {
                arr[y][x] = Integer.parseInt(num);
                x++;
            }
        }
        System.out.println(solve(0, 0));
//        for(int i = 0 ; i< n; i++){
//            for(int j = 0 ; j < n ; j++){
//                System.out.printf("%d ",dp[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(System.currentTimeMillis() - start + "ms");


    }

    public static int solve(int y, int x) {
        if (y >= n || x >= n) return 0;
        if (dp[y][x] != 0) return dp[y][x];

        return dp[y][x] = (Math.max(solve(y + 1, x), solve(y + 1, x + 1)) + arr[y][x]);
    }

}
