/*
 * 문제: 백준 11689번 - GCD(n, k) = 1 (https://www.acmicpc.net/problem/11689)
 * 문제 풀이
 *  소인수분해를 통해 서로 다른 소인수들을 구한 뒤, Euler’s phi(오일러 피) 함수를 사용해 문제를 풂.
 *  오일러 피 함수는 곱셈적 함수로, 두 정수 m, n이 서로소라면 φ(mn) = φ(m) × φ(n)이 성립.
 *  또한, 오일러 곱 공식에 따라 φ(n)은 n에 대해 n의 모든 서로 다른 소인수 p에 대해 (1 - 1/p)를 곱한 값.
 *  예를 들어, n이 20이면 20의 소인수는 2, 5이므로 φ(20) = 20 * (1 - 1/2) * (1 - 1/5)
 *
 * 시간 복잡도: O(√n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_11689_GCDnk1 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        long cnt = n;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                cnt -= cnt / i;

                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        if (n > 1) {
            cnt -= cnt / n;
        }

        bw.write(Long.toString(cnt));
        br.close();
        bw.close();
    }
}
