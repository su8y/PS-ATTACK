/*
 * 문제 : 백준 1463번 - 1로 만들기 (https://www.acmicpc.net/problem/1463)
 */

package Baekjoon;

import java.io.*;

public class BOJ_1463_1로만들기 {
    // public class Main {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];

        bw.write(dp(n) + "");
        br.close();
        bw.close();
    }

    public static int dp(int n) {
        if (n == 1)
            return 0;
        else if (memo[n] == 0) {
            int cnt = Integer.MAX_VALUE;

            if (n % 3 == 0)
                cnt = Math.min(cnt, dp(n / 3) + 1);

            if (n % 2 == 0)
                cnt = Math.min(cnt, dp(n / 2) + 1);

            cnt = Math.min(cnt, dp(n - 1) + 1);
            memo[n] = cnt;
        }

        return memo[n];
    }
}
