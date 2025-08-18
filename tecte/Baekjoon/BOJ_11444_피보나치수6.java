/*
 * 문제 : 백준 11444번 - 피보나치 수 6 (https://www.acmicpc.net/problem/11444)
 * 문제 풀이
 *  피보나치 수열을 2x2 행렬로 표현하면
 *  ⎡F(n+1)  F(n) ⎤ = ⎡1 1⎤n
 *  ⎣ F(n)  F(n-1)⎦   ⎣1 0⎦
 *  즉, F(n)을 구하는 문제를 행렬의 n제곱을 구하는 문제로 변환할 수 있음
 *  행렬의 곱은 두 행렬이 있을 때
 *  ⎡a b⎤ x ⎡e f⎤ = ⎡a×e+b×g(첫 번째 행, 첫 번째 열) a×f+b×h(첫 번째 행, 두 번째 열)⎤
 *  ⎣c d⎦   ⎣g h⎦   ⎣c×e+d×g(두 번째 행, 첫 번째 열) c×f+d×h(두 번째 행, 두 번째 열)⎦
 *  행렬 거듭제곱은 행렬을 여러 번 곱하므로 분할 정복으로 시간 복잡도를 O(log n)으로 줄일 수 있음
 *  n이 짝수 일 때는 ⎡F(n+1)  F(n) ⎤ = ⎡1 1⎤n/2 x ⎡1 1⎤n/2
 *                 ⎣ F(n)  F(n-1)⎦   ⎣1 0⎦      ⎣1 0⎦
 *  n이 홀수 일 때는 ⎡F(n+1)  F(n) ⎤ = ⎡1 1⎤(n-1)/2 x ⎡1 1⎤(n-1)/2 x ⎡1 1⎤
 *                 ⎣ F(n)  F(n-1)⎦   ⎣1 0⎦          ⎣1 0⎦          ⎣1 0⎦
 */

package Baekjoon;

import java.io.*;

public class BOJ_11444_피보나치수6 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());

        bw.write(Long.toString(fibonacci(n)[0][1]));
        br.close();
        bw.close();
    }

    public static long[][] fibonacci(long n) {
        if (n == 1)
            return new long[][]{{1, 1}, {1, 0}};

        long[][] matrix = fibonacci(n / 2);

        matrix = multiply(matrix, matrix);

        if (n % 2 == 1)
            matrix = multiply(matrix, new long[][]{{1, 1}, {1, 0}});

        return matrix;
    }

    public static long[][] multiply(long[][] a, long[][] b) {
        long mod = 1000000007;
        long x1 = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % mod;
        long y1 = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % mod;
        long x2 = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % mod;
        long y2 = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % mod;

        return new long[][]{{x1, y1}, {x2, y2}};
    }
}
