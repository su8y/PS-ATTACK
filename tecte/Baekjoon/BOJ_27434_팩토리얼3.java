/*
 * 문제: 백준 27434번 - 팩토리얼 3 (https://www.acmicpc.net/problem/27434)
 * 문제 풀이
 *  n 번의 BigInteger를 생성하고 곱하면 시간초과가 발생.
 *  분할 정복을 사용하여 BigInteger 생성 횟수를 줄임.
 *
 * 시간 복잡도: O(n^2 log n)
 */

package Baekjoon;

import java.io.*;
import java.math.*;

public class BOJ_27434_팩토리얼3 {
    // public class Main {
    private static BigInteger factorial(int a, int n) {
        BigInteger num = BigInteger.valueOf(a);

        if (a < n) {
            int b = (a + n) >> 1;

            num = factorial(a, b).multiply(factorial(b + 1, n));
        }

        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        bw.write(factorial(1, n).toString());
        br.close();
        bw.close();
    }
}
