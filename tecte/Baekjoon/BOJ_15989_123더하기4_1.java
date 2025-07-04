/*
 * 문제: 백준 15989번 - 1, 2, 3 더하기 4 (https://www.acmicpc.net/problem/15989)
 * 문제 풀이
 *  1, 2, 3의 합으로 나타낼 때 사용한 가장 큰 숫자를 기준으로 메모이제이션 함.
 *  예를 들어, 1+1+1+1의 경우 1만 사용했기 때문에 dp[4][1]에 +1를 하고 2+1+1는 사용한 숫자 중 2가 가장 크니까 dp[4][2]에 +1함.
 *  모든 방법의 수를 구할 때는 1, 2, 3을 사용했을 때의 방법을 구하고 더해야 함.
 *  3을 사용했을 때의 방법은 dp(n-3)의 모든 방법에서 +3을 하면 되므로 dp[i][3] = dp(n-3) = dp(n-3)[1] + dp(n-3)[2] + dp(n-3)[3]
 *  2를 사용했을 때의 방법은 dp(n-2)의 방법에서 3를 사용한 방법은 제외한 방법들을 구함. dp[i][2] = dp(n-2)[1] + dp(n-2)[2]
 *  3을 사용하면 위에서 구한 3을 사용했을 때의 방법과 겹치는 방법이 생김.
 *  1를 사용했을 때의 방법은 dp(n-1)의 방법에서 2와 3을 사용한 방법을 제외한 방법. dp[i][1] = dp(n-2)[1]
 *  이를 점화식으로 나타내면 dp[i] = dp(n-1)[1] + dp(n-2)[1] + dp(n-2)[2] + dp(n-3)
 *
 * 시간 복잡도: O(max(n)) - max(n): 테스트 케이스에서 주어진 n의 값 중 가장 큰 값.
 */

package Baekjoon;

import java.io.*;

public class BOJ_15989_123더하기4_1 {
    // public class Main {
    static int[][] memo = new int[10001][4];

    static int[] dp(int n) {
        if (n < 0)
            return new int[4];

        if (memo[n][0] == 0) {
            int[] dp3 = dp(n - 3);
            int[] dp2 = dp(n - 2);
            int[] dp1 = dp(n - 1);

            memo[n][3] = dp3[0];
            memo[n][2] = dp2[1] + dp2[2];
            memo[n][1] = dp1[1];
            memo[n][0] = memo[n][1] + memo[n][2] + memo[n][3];
        }

        return memo[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        memo[0][0] = 1;
        memo[0][1] = 1;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            bw.write(dp(n)[0] + "\n");
        }

        br.close();
        bw.close();
    }
}
