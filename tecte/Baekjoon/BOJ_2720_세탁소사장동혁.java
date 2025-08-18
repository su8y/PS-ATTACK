/*
 * 문제: 백준 2720번 - 세탁소 사장 동혁 (https://www.acmicpc.net/problem/2720)
 *
 * 시간 복잡도: O(t)
 */

package Baekjoon;

import java.io.*;

public class BOJ_2720_세탁소사장동혁 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] coins = {25, 10, 5, 1};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int c = Integer.parseInt(br.readLine());

            for (int coin : coins) {
                sb.append(c / coin).append(" ");
                c %= coin;
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
