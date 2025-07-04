/*
 * 문제: 백준 16208번 - 귀찮음 (https://www.acmicpc.net/problem/16208)
 * 문제 풀이
 *  그리디와 누적합을 사용.
 *  쇠막대를 길이 순으로 정렬한 뒤, 가장 짧은 막대부터 남은 막대 길이의 총합과 곱하여 비용을 계산.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_16208_귀찮음 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] rods = new int[n];
        int sum = 0;
        long cost = 0;

        for (int i = 0; i < n; i++) {
            rods[i] = Integer.parseInt(st.nextToken());
            sum += rods[i];
        }

        Arrays.sort(rods);

        for (int i = 0; i < n - 1; i++) {
            sum -= rods[i];
            cost += (long) rods[i] * sum;
        }

        bw.write(Long.toString(cost));
        br.close();
        bw.close();
    }
}
