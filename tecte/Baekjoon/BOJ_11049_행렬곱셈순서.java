/*
 * 문제: 백준 11049번 - 행렬 곱셈 순서 (https://www.acmicpc.net/problem/11049)
 * 문제 풀이
 *  DP를 사용하여 부분 문제로 나누어 해결.
 *  (a, k) * (k+1, b)로 두 개의 부분 문제로 나눔.
 *
 * 시간 복잡도: O(n^3)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11049_행렬곱셈순서 {
    // public class Main {
    private static Matrix[] matrices;
    private static int[][] memo = new int[501][501];

    private static int dp(int s, int e) {
        if (s == e || memo[s][e] != 0) {
            return memo[s][e];
        }

        int cnt = Integer.MAX_VALUE;

        for (int i = s; i < e; i++) {
            cnt = Math.min(cnt, dp(s, i) + dp(i + 1, e) + matrices[s].a * matrices[i].b * matrices[e].b);
        }

        return memo[s][e] = cnt;
    }

    private static class Matrix {
        int a, b;

        public Matrix(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        matrices = new Matrix[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrices[i] = new Matrix(a, b);
        }

        bw.write(Integer.toString(dp(1, n)));
        br.close();
        bw.close();
    }
}
