/*
 * 문제: 백준 12850번 - 본대 산책2 (https://www.acmicpc.net/problem/12850)
 * 문제 풀이
 *  정점들을 행렬로 표현하고 행렬을 D번 거듭제곱하면 D분 이동했을 때 갈 수 있는 모든 경우의 수를 알 수 있음.
 *
 * 시간 복잡도: O(log d)
 */

package Baekjoon;

import java.io.*;

public class BOJ_12850_본대산책2 {
    // public class Main {
    private static final int MOD = 1_000_000_007;
    private static final int[][] MATRIX = {
            {0, 1, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 1, 0, 0},
            {0, 0, 1, 1, 0, 1, 0, 1},
            {0, 0, 0, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0}
    };

    private static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int[][] matrix = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                long cnt = 0;

                for (int k = 0; k < 8; k++) {
                    cnt += (long) matrixA[i][k] * matrixB[k][j];
                }

                matrix[i][j] = (int) (cnt % MOD);
            }
        }

        return matrix;
    }

    private static int[][] pow(int n) {
        if (n == 1) {
            return MATRIX;
        }

        int[][] matrix = pow(n >> 1);

        matrix = multiply(matrix, matrix);

        return (n & 1) == 0 ? matrix : multiply(matrix, MATRIX);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int d = Integer.parseInt(br.readLine());
        int[][] matrix = pow(d);

        bw.write(Integer.toString(matrix[0][0]));
        br.close();
        bw.close();
    }
}
