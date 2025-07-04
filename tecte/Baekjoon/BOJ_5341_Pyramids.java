/*
 * 문제: 백준 5341번 - Pyramids (https://www.acmicpc.net/problem/5341)
 *
 * 시간 복잡도: O(t) - t: 테스트 케이스 수
 */

package Baekjoon;

import java.io.*;

public class BOJ_5341_Pyramids {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            sb.append((n + 1) * n >> 1).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
