/*
 * 문제 : 백준 9095번 - 1, 2, 3 더하기 (https://www.acmicpc.net/problem/9095)
 * 문제풀이
 *  dp의 bottom-up 방식으로 품
 */

package Baekjoon;

import java.io.*;

public class BOJ_9095_123더하기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 10; i++)
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            bw.write(dp[n] + "");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
