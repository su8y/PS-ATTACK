/*
 * 문제: 백준 7579번 - 앱 (https://www.acmicpc.net/problem/7579)
 * 문제 풀이
 *  배낭 문제이므로 DP를 사용하여 앱 비활성화의 최소 비용을 구함.
 *  메모리에 따라 최소 비용을 구하면 메모리의 범위가 비활성화 비용의 범위보다 훨씬 커서 메모리 초과가 발생함.
 *  비활성화 비용에 따라 메모리의 크기를 구해야 메모리 초과 없이 최소 비용을 구할 수 있음.
 *
 * 시간 복잡도: O(n * c) - c: 앱 비활성화 비용의 총 합
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7579_앱_1 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] memory = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] memo = new int[n + 1][10001];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 10000; j++) {
                memo[i + 1][j] = j < cost[i] ? memo[i][j] : Math.max(memo[i][j], memory[i] + memo[i][j - cost[i]]);
            }
        }

        for (int i = 0; i <= 10000; i++) {
            if (memo[n][i] >= m) {
                bw.write(Integer.toString(i));
                break;
            }
        }

        br.close();
        bw.close();
    }
}
