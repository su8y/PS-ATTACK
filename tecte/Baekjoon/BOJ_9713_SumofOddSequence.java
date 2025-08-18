/*
 * 문제: 백준 9713번 - Sum of Odd Sequence (https://www.acmicpc.net/problem/9713)
 *
 * 시간 복잡도: O(t)
 */

package Baekjoon;

import java.io.*;

public class BOJ_9713_SumofOddSequence {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            n = ++n >> 1;
            sb.append(n * n).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
