/*
 * 문제: 백준 1562번 - 계단 수 (https://www.acmicpc.net/problem/1562)
 * 문제 풀이
 *  DP와 비트와 비트마스킹을 이용하여 모든 숫자가 포함된 계단 수를 구함.
 *  0~9까지의 숫자 사용 여부를 추적하기 위해 1024(2^10)개의 비트 상태를 사용.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_1562_계단수 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][][] memo = new int[n][10][1024];
        int result = 0;

        for (int i = 0; i < 10; i++) {
            memo[0][i][1 << i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1024; k++) {
                    int bit = k | (1 << j);

                    if (j > 0) {
                        memo[i][j][bit] += memo[i - 1][j - 1][k];
                        memo[i][j][bit] %= 1_000_000_000;
                    }

                    if (j < 9) {
                        memo[i][j][bit] += memo[i - 1][j + 1][k];
                        memo[i][j][bit] %= 1_000_000_000;
                    }
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            result = (result + memo[n - 1][i][1023]) % 1_000_000_000;
        }

        bw.write(Integer.toString(result));
        br.close();
        bw.close();
    }
}
