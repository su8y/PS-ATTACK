/*
 * 문제: 백준 1086번 - 박성원 (https://www.acmicpc.net/problem/1086)
 * 문제 풀이
 *  각 숫자마다 모듈러 연산을 통해 나머지를 미리 계산.
 *  DP와 비트마스크를 사용해서 숫자들을 이어붙이는 모든 경우를 탐색.
 *  숫자들을 이어붙일 때는 미리 구한 나머지와 자리수를 이용해 모듈러 연산으로 빠르게 계산.
 *  모든 숫자를 이어붙이는 경우의 수는 총 n!
 *  유클리드 호제법을 사용해서 최대공약수를 구하고 약분.
 *
 * 시간 복잡도: O(2^n * n * k)
 */

package Baekjoon;

import java.io.*;

public class BOJ_1086_박성원 {
    // public class Main {
    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] nums = new String[n];

        for (int i = 0; i < n; i++) {
            nums[i] = br.readLine();
        }

        int k = Integer.parseInt(br.readLine());
        int v = 1 << n;
        int[] mods = new int[n];
        int[] pow10 = new int[51];
        long[][] memo = new long[v][k];
        long fact = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int mod = 0;

            for (int j = 0; j < nums[i].length(); j++) {
                mod = (mod * 10 + (nums[i].charAt(j) - '0')) % k;
            }

            mods[i] = mod;
        }

        pow10[0] = 1;
        memo[0][0] = 1;

        for (int i = 1; i < 51; i++) {
            pow10[i] = pow10[i - 1] * 10 % k;
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < n; j++) {
                int mask = 1 << j;

                if ((i & mask) == 0) {
                    int visited = i | mask;

                    for (int l = 0; l < k; l++) {
                        int mod = (l * pow10[nums[j].length()] + mods[j]) % k;

                        memo[visited][mod] += memo[i][l];
                    }
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        if (memo[v - 1][0] == 0) {
            sb.append("0/1");
        } else {
            long gcd = gcd(fact, memo[v - 1][0]);

            sb.append(memo[v - 1][0] / gcd).append("/").append(fact / gcd);
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
