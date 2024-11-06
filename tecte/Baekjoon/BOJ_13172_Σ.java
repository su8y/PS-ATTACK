/*
 * 문제: 백준 13172번 - Σ (https://www.acmicpc.net/problem/13172)
 * 문제 풀이
 *  분수로 되어있는 각 주사위들의 기댓값을 통분함.
 *  페르마의 소정리를 이용하여 a * b^-1 (mod m)을 a * b^(m-2) (mod m)으로 구할 수 있음. b^(m-2)는 분할 정복으로 구함.
 *
 * 시간 복잡도: O(M)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13172_Σ {
    // public class Main {
    static final long MODULAR = 1_000_000_007;

    static long pow(long base) {
        int exp = (int) (MODULAR - 2);
        long power = 1;

        while (exp > 0) {
            if ((exp & 1) == 1)
                power = power * base % MODULAR;

            base = base * base % MODULAR;
            exp >>= 1;
        }

        return power;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        long a = 0;
        long b = 1;

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            a = (a * n + b * s) % MODULAR;
            b = b * n % MODULAR;
        }

        bw.write(Long.toString(a * pow(b) % MODULAR));
        br.close();
        bw.close();
    }
}
