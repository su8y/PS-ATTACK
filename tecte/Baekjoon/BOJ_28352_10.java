/*
 * 문제: 백준 28352번 - 10! (https://www.acmicpc.net/problem/28352)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_28352_10 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long fact = 1;

        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        bw.write(Long.toString(fact / 60 / 60 / 24 / 7));
        br.close();
        bw.close();
    }
}
