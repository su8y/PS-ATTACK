/*
 * 문제: 백준 16565번 - N포커 (https://www.acmicpc.net/problem/16565)
 * 문제 풀이
 *  파스칼 삼각형을 이용하여 카드 조합의 경우의 수를 미리 계산하고 DP를 사용해서 n장을 뽑았을 때 최소 하나 이상의 포카드를 만드는 경우를 구함.
 *  n장을 뽑았을 때 최소 하나 이상의 포카드를 만드는 경우의 수는
 *  포카드 1개를 만들고 남은 n-4장이 포카드가 안되게 하는 경우 + 포카드 2개를 만들고 남은 n-8장이 포카드가 안되게 하는 경우 + ... + 포카드 m개를 만들고 남은 n-4*m 장이 포카드가 안되게 하는 경우
 *
 * 시간 복잡도: O(c^2) - c: 트럼프 카드의 개수
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_16565_N포커_1 {
    // public class Main {
    private static final int MOD = 10_007;
    private static int[][] comb = new int[53][53];
    private static Map<String, Long> memo = new HashMap<>();

    private static long dp(int num, int n, int r) {
        String key = n + "," + r;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long cnt = 0;
        int i = 0;

        while (r >= 4) {
            n -= 4;
            r -= 4;
            cnt += comb[num][++i] * (comb[n][r] - dp(num - i, n, r) + MOD);
        }

        cnt %= MOD;
        memo.put(key, cnt);

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 53; i++) {
            comb[i][0] = comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        bw.write(Long.toString(dp(13, 52, n)));
        br.close();
        bw.close();
    }
}
