/*
 * 문제 : 백준 9465번 - 스티커 (https://www.acmicpc.net/problem/9465)
 * 문제 풀이
 *  dp의 bottom-up 방식으로 점수의 최댓값을 구함
 *  1열부터 n열까지 2행을 다 방문. 방문한 곳의 스티커를 떼면 인접한 곳의 스티커를 뗄 수 없으니
 *  현재 있는 곳의 왼쪽 스티커 점수와 현재 있는 곳의 스티커의 점수 + 대각선의 스티커 점수가 현재 있는 곳까지의 스티커 점수의 최댓값
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_9465_스티커 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] desk = new int[2][n];
            int[][] memo = new int[2][n];

            for (int i = 0; i < 2; i++)
                desk[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            memo[0][0] = desk[0][0];
            memo[1][0] = desk[1][0];

            for (int i = 1; i < n; i++)
                for (int j = 0; j < 2; j++)
                    memo[j][i] = Math.max(memo[j][i - 1], memo[(j + 1) % 2][i - 1] + desk[j][i]);

            bw.write(Math.max(memo[0][n - 1], memo[1][n - 1]) + "\n");
        }

        br.close();
        bw.close();
    }
}
