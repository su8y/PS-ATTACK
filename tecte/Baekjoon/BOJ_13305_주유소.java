/*
 * 문제: 백준 13305번 - 주유소 (https://www.acmicpc.net/problem/13305)
 * 문제 풀이
 *  그리디 방식으로 각 도시에 도착할 때마다 가격을 비교하여 가장 싼 가격으로 주유.
 *
 * 시간 복잡도: O(N)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_13305_주유소 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dist = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int minCost = cost[0];
        long totalCost = 0;

        for (int i = 0; i < n - 1; i++) {
            totalCost += (long) dist[i] * minCost;
            minCost = Math.min(minCost, cost[i + 1]);
        }

        bw.write(Long.toString(totalCost));
        br.close();
        bw.close();
    }
}
