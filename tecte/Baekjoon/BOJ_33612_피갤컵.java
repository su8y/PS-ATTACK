/*
 * 문제: 백준 33612번 - 피갤컵 (https://www.acmicpc.net/problem/33612)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;

public class BOJ_33612_피갤컵 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int year = 2024;
        int month = 1;
        StringBuilder sb = new StringBuilder();

        n *= 7;
        year += n / 12;
        month += n % 12;
        sb.append(year).append(" ").append(month);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
