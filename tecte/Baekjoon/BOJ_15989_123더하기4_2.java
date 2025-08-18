/*
 * 문제: 백준 15989번 - 1, 2, 3 더하기 4 (https://www.acmicpc.net/problem/15989)
 * 문제 풀이
 *  첫 번째 방법과 풀이 과정은 같으나 계산 과정을 최적화한 방법.
 *  첫 번째 방법: Top-down 방식
 *  두 번째 방법: Bottom-up 방식
 *
 * 시간 복잡도: O(t)
 */

package Baekjoon;

import java.io.*;

public class BOJ_15989_123더하기4_2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] memo = new int[10001];

        memo[0] = 1;

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < memo.length; j++) {
                if (j - i < 0)
                    continue;

                memo[j] += memo[j - i];
            }
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            bw.write(memo[n] + "\n");
        }

        br.close();
        bw.close();
    }
}
