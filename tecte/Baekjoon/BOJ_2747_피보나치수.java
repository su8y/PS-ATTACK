/*
 * 문제: 백준 2747번 - 피보나치 수 (https://www.acmicpc.net/problem/2747)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_2747_피보나치수 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 1;
        int c = 1;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        bw.write(Integer.toString(c));
        br.close();
        bw.close();
    }
}
