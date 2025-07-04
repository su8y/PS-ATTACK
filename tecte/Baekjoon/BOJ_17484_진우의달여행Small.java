/*
 * 문제: 백준 17484번 - 진우의 달 여행 (Small) (https://www.acmicpc.net/problem/17484)
 * 문제 풀이
 *  이전 경로에서 어떤 각도로 현재 경로로 왔는지에 따라 비용을 메모이제이션 함.
 *
 * 시간 복잡도: O(n * m)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17484_진우의달여행Small {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] memo = new int[3][m];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[][] newMemo = new int[3][m];

            for (int j = 0; j < m; j++) {
                int cost = Integer.parseInt(st.nextToken());

                newMemo[0][j] = j - 1 >= 0 ? Math.min(memo[1][j - 1], memo[2][j - 1]) + cost : Integer.MAX_VALUE;
                newMemo[1][j] = Math.min(memo[0][j], memo[2][j]) + cost;
                newMemo[2][j] = j + 1 < m ? Math.min(memo[0][j + 1], memo[1][j + 1]) + cost : Integer.MAX_VALUE;
            }

            memo = newMemo;
        }

        for (int i = 0; i < 3; i++)
            min = Math.min(min, Arrays.stream(memo[i]).min().getAsInt());

        bw.write(Integer.toString(Arrays.stream(memo).flatMapToInt(Arrays::stream).min().orElse(-1)));
        br.close();
        bw.close();
    }
}
