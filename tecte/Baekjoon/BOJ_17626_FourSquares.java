/*
 * 문제 : 백준 17626번 - Four Squares (https://www.acmicpc.net/problem/17626)
 */

package Baekjoon;

import java.io.*;

public class BOJ_17626_FourSquares {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] memo = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            memo[i] = Integer.MAX_VALUE;

            for (int j = 1; j <= i; j++) {
                if (j * j > i)
                    break;
                else
                    memo[i] = Math.min(memo[i], memo[i - j * j] + 1);
            }
        }

        bw.write(memo[n] + "");
        br.close();
        bw.close();
    }
}
