/*
 * 문제: 백준 5300번 - Fill the Rowboats! (https://www.acmicpc.net/problem/5300)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_5300_FilltheRowboats {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(i).append(" ");

            if (i % 6 == 0) {
                sb.append("Go! ");
            }
        }

        if (n %6 != 0) {
            sb.append("Go!");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
