/*
 * 문제: 백준 17548번 - Greetings! (https://www.acmicpc.net/problem/17548)
 *
 * 시간 복잡도: O(n) - n: 문자열의 길이
 */

package Baekjoon;

import java.io.*;

public class BOJ_17548_Greetings {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = br.readLine().length();
        StringBuilder sb = new StringBuilder("h");

        for (int i = 2; i < n; i++) {
            sb.append("ee");
        }

        sb.append("y");
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
