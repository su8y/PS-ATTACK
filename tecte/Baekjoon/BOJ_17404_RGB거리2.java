/*
 * 문제: 백준 17404번 - RGB거리 2 (https://www.acmicpc.net/problem/17404)
 * 문제 풀이
 *  첫 번째 집이 빨강, 초록, 파랑일 때의 경우를 각각 따로 메모이제이션
 *  순차적으로 집의 색을 선택할 때, 각각의 색을 선택했을 때의 경우를 모두 메모이제이션 함.
 *  색을 선택했을 때, 이전 집에서 현재 색과 다른 색을 선택한 집의 경우 중 최소 비용과 현재 색의 비용을 더함.
 *  마지막 집까지 색을 선택한 후, 첫 번째 집과 마지막 집의 색이 같지 않은 경우 중 최소값을 선택.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_17404_RGB거리2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] memo = new int[3][3];
        int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                memo[i][j] = i == j ? cost[i] : Integer.MAX_VALUE >> 1;
            }
        }

        while (n-- > 1) {
            int[][] newMemo = new int[3][3];

            cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    newMemo[i][j] = cost[j] + Math.min(memo[i][(j + 2) % 3], memo[i][(j + 1) % 3]);
                }
            }

            memo = newMemo;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    min = Math.min(min, memo[i][j]);
                }
            }
        }

        bw.write(Integer.toString(min));
        br.close();
        bw.close();
    }
}
