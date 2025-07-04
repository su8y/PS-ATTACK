/*
 * 문제: 백준 16565번 - N포커 (https://www.acmicpc.net/problem/16565)
 * 문제 풀이
 *  파스칼 삼각형을 이용하여 카드 조합의 경우의 수를 미리 계산.
 *  포함-배제 원리를 사용해서 n장을 뽑았을 때 최소 하나 이상의 포카드를 만드는 경우를 구함.
 *
 * 시간 복잡도: O(c^2) - c: 트럼프 카드의 개수
 */

package Baekjoon;

import java.io.*;

public class BOJ_16565_N포커_2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] comb = new int[53][53];
        final int MOD = 10_007;
        int sign = 1;
        int cnt = 0;

        for (int i = 0; i < 53; i++) {
            comb[i][0] = comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        for (int i = 4; i <= n; i += 4) {
            cnt += sign * comb[13][i >> 2] * comb[52 - i][n - i];
            cnt %= MOD;
            sign = -sign;
        }

        bw.write(Integer.toString((cnt + MOD) % MOD));
        br.close();
        bw.close();
    }
}
