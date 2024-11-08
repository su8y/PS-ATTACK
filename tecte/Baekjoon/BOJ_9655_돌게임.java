/*
 * 문제: 백준 9655번 - 돌 게임 (https://www.acmicpc.net/problem/9655)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;

public class BOJ_9655_돌게임 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        bw.write(n % 2 == 0 ? "CY" : "SK");
        br.close();
        bw.close();
    }
}
