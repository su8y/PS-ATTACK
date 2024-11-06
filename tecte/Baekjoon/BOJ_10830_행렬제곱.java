/*
 * 문제: 백준 10830번 - 행렬 제곱 (https://www.acmicpc.net/problem/10830)
 * 문제 풀이
 *  A^b = A^(b/2) * A^(b/2)인 성질을 이용해 분할 정복을 사용.
 *  이때 지수가 홀수인 경우에는 추가로 행렬 A를 곱함.
 *
 * 시간 복잡도: O(N^3 log B)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ_10830_행렬제곱 {
    // public class Main {
    static int n;
    static int[][] matrix;

    static int[][] divide(long b) {
        if (b == 1)
            return matrix;

        int[][] newMatrix = divide(b / 2);

        newMatrix = multiply(newMatrix, newMatrix);

        if (b % 2 == 1)
            newMatrix = multiply(newMatrix, matrix);

        return newMatrix;
    }

    static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int[][] newMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++)
                    newMatrix[i][j] += matrixA[i][k] * matrixB[k][j];

                newMatrix[i][j] %= 1000;
            }
        }

        return newMatrix;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        matrix = new int[n][];
        long b = Long.parseLong(input[1]);

        for (int i = 0; i < n; i++)
            matrix[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .map(v -> v % 1000)
                    .toArray();

        matrix = divide(b);

        for (int i = 0; i < n; i++) {
            bw.write(Arrays.stream(matrix[i]).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
