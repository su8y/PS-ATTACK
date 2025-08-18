/*
 * 문제 : 백준 2579번 - 계단 오르기 (https://www.acmicpc.net/problem/2579)
 *  dp의 bottom-up 방식으로 마지막 계단에서 얻을 수 있는 점수의 최댓값을 구함
 *  메모이제이션을 할 때 다음 계단을 연속으로 올라갈 수 있는지에 따라 구분해서 메모이제이션 함
 */

package Baekjoon;

import java.io.*;

public class BOJ_2579_계단오르기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] memo = new int[n][2];

        for (int i = 0; i < n; i++) {
            memo[i][0] = memo[i][1] = Integer.parseInt(br.readLine());

            if (i - 2 >= 0)
                memo[i][0] += Math.max(memo[i - 2][0], memo[i - 2][1]);

            if (i - 1 >= 0)
                memo[i][1] += memo[i - 1][0];
        }

        bw.write(Math.max(memo[n - 1][0], memo[n - 1][1]) + "");
        br.close();
        bw.close();
    }
}
