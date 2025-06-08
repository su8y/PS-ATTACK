/*
 * 문제: 백준 2999번 - 비밀 이메일 (https://www.acmicpc.net/problem/2999)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_2999_비밀이메일 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String msg = br.readLine();
        int n = msg.length();
        int r = (int) Math.sqrt(n);
        StringBuilder sb = new StringBuilder();

        while (n % r != 0) {
            r--;
        }

        for (int i = 0; i < r; i++) {
            for (int j = i; j < n; j += r) {
                sb.append(msg.charAt(j));
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
