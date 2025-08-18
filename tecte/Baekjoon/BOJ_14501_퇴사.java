/*
 * 문제: 백준 14501번 - 퇴사 (https://www.acmicpc.net/problem/14501)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
    // public class Main {
    static int n;
    static int[] t, p, memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        t = new int[n + 1];
        p = new int[n + 1];
        memo = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(dp(1) + "");
        br.close();
        bw.close();
    }

    public static int dp(int d) {
        if (d > n)
            return 0;

        if (memo[d] == 0) {
            memo[d] = dp(d + 1);

            if (d + t[d] - 1 <= n)
                memo[d] = Math.max(memo[d], p[d] + dp(d + t[d]));
        }

        return memo[d];
    }
}
