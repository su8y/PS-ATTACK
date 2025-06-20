/*
 * 문제: 백준 17401번 - 일하는 세포 (https://www.acmicpc.net/problem/17401)
 * 문제 풀이
 *  혈관 지도를 행렬로 표현.
 *  t초마다 주기적으로 변화하므로, t개의 행렬을 곱해 한 싸이클을 구성
 *  d가 최대 10^9이기 때문에 분할 정복으로 싸이클을 d / t번 곱하고 나머지 d % t초에 해당하는 행렬을 곱함.
 *
 * 시간 복잡도: O(log d * n^3)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_17401_일하는세포 {
    // public class Main {
    private static final int MOD = 1_000_000_007;
    private static int n;

    private static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int[][] matrix = new int[n][n];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                long cnt = 0;

                for (int k = 1; k < n; k++) {
                    cnt += (long) matrixA[i][k] * matrixB[k][j] % MOD;
                }

                matrix[i][j] = (int) (cnt % MOD);
            }
        }

        return matrix;
    }

    private static int[][] pow(int[][] matrix, int n) {
        if (n == 1) {
            return matrix;
        }

        int[][] newMatrix = pow(matrix, n >> 1);

        newMatrix = multiply(newMatrix, newMatrix);

        return (n & 1) == 0 ? newMatrix : multiply(newMatrix, matrix);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken()) + 1;
        int d = Integer.parseInt(st.nextToken());
        int[][] cycle = new int[n][n];
        int[][] result = new int[n][n];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n; i++) {
            cycle[i][i] = 1;
        }

        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                matrix[a][b] = c;
            }

            if (i == d % t) {
                result = cycle;
            }

            cycle = multiply(cycle, matrix);
        }

        if (d / t > 0) {
            result = multiply(pow(cycle, d / t), result);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
