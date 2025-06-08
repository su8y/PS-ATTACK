/*
 * 문제: 백준 1934번 - 최소공배수 (https://www.acmicpc.net/problem/1934)
 * 문제 풀이
 *  유클리드 호제법으로 GCD를 구한 뒤, 이를 이용해서 최소공배수를 구함.
 *
 * 시간 복잡도: O(t * log a)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1934_최소공배수 {
    // public class Main {
    private static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(a * b / gcd(a, b)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
