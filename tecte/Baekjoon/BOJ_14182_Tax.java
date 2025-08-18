/*
 * 문제: 백준 14182번 - Tax (https://www.acmicpc.net/problem/14182)
 *
 * 시간 복잡도: O(n) - n: 입력받은 수입의 개수
 */

package Baekjoon;

import java.io.*;

public class BOJ_14182_Tax {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int income;
        StringBuilder sb = new StringBuilder();

        while ((income = Integer.parseInt(br.readLine())) > 0) {
            if (income > 5_000_000) {
                income -= income / 5;
            } else if (income > 1_000_000) {
                income -= income / 10;
            }

            sb.append(income).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
