/*
 * 문제 : 백준 2096 - 내려가기 (https://www.acmicpc.net/problem/2096)
 * 문제 풀이
 *  DP로 현재 줄까지의 최대 점수와 최소 점수를 메모이제이션.
 *  메모이제이션한 점수 중에서 다음 줄의 각 칸에 갈 수 있는 점수와 입력받은 다음 줄의 점수를 더해서 최대 점수와 최소 점수를 갱신함.
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_2096_내려가기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] score = new int[2][3];

        for (int i = 0; i < n; i++) {
            int[] board = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] newScore = new int[2][3];
            int leftMax = Math.max(score[0][0], score[0][1]);
            int rightMax = Math.max(score[0][1], score[0][2]);
            int leftMin = Math.min(score[1][0], score[1][1]);
            int rightMin = Math.min(score[1][1], score[1][2]);

            newScore[0][0] = board[0] + leftMax;
            newScore[1][0] = board[0] + leftMin;
            newScore[0][1] = board[1] + Math.max(leftMax, rightMax);
            newScore[1][1] = board[1] + Math.min(leftMin, rightMin);
            newScore[0][2] = board[2] + rightMax;
            newScore[1][2] = board[2] + rightMin;
            score = newScore;
        }

        int max = Math.max(score[0][0], Math.max(score[0][1], score[0][2]));
        int min = Math.min(score[1][0], Math.min(score[1][1], score[1][2]));

        bw.write(max + " " + min);
        br.close();
        bw.close();
    }
}
