/*
 * 문제: 백준 15322번 - Košnja (https://www.acmicpc.net/problem/15322)
 *
 * 시간 복잡도: O(k)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_15322_Kosnja {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append((Math.min(n, m) - 1) << 1).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
