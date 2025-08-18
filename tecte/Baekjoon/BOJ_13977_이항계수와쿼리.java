/*
 * 문제: 백준 13977번 - 이항 계수와 쿼리 (https://www.acmicpc.net/problem/13977)
 * 문제 풀이
 *  최대 N까지의 팩토리얼 값을 미리 계산.
 *  이항 계수 C(n, k) = n! / k! * (n - k)! = n! * (k! * (n - k)!)^-1
 *  분모의 역원을 구해야 하므로, 페르마의 소정리를 이용하여 모듈러 역원을 계산.
 *  즉, (k! * (n - k)!)^-1 ≡ (k! * (n - k)!)^(MOD-2) mod 1,000,000,007
 *  분할 정복을 사용하여 거듭 제곱을 구함.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_13977_이항계수와쿼리 {
    // public class Main {
    private static final long MOD = 1_000_000_007;
    private static final int N_LEN = 4_000_001;

    private static long pow(long b, long e) {
        if (e == 0) {
            return 1;
        }

        long h = pow(b, e >> 1);
        long ret = h * h % MOD;

        return (e & 1) == 0 ? ret : ret * b % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        long[] fac = new long[N_LEN];
        StringBuilder sb = new StringBuilder();

        fac[0] = 1;

        for (int i = 1; i < N_LEN; i++) {
            fac[i] = fac[i - 1] * i % MOD;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sb.append(fac[n] * pow(fac[k] * fac[n - k] % MOD, MOD - 2) % MOD).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
