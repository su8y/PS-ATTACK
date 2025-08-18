/*
 * 문제: 백준 1106번 - 호텔 (https://www.acmicpc.net/problem/1106)
 * 문제 풀이
 *  배낭 문제로 DP를 사용하여 최소 비용을 구함.
 *
 * 시간 복잡도: O(n * c)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1106_호텔 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] costs = new int[c + 1];

        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= c; j++) {
                costs[j] = Math.min(costs[j], costs[Math.max(0, j - customer)] + cost);
            }
        }

        bw.write(Integer.toString(costs[c]));
        br.close();
        bw.close();
    }
}
