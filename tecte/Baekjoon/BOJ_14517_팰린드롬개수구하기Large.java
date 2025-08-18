/*
 * 문제: 백준 14517번 - 팰린드롬 개수 구하기 (Large) (https://www.acmicpc.net/problem/14517)
 * 문제 풀이
 *  DP를 사용하여 팰린드롬이 되는 부분 문자열의 개수를 구함.
 *  점화식을 세울 때 앞쪽, 한 글자를 제외한 경우와 뒤쪽 한 글자를 제외한 경우를 더하고 앞과 뒤를 제외한 부분이 중복으로 더해지므로 이를 한 번 뺌.
 *  앞쪽 글자와 뒤쪽 글자가 같으면 그 자체로도 팰린드롬이 되므로 +1
 *  모듈러 연산이 음수가 되지 않도록 계산.
 *
 * 시간 복잡도: O(n^2) - n: 문자열의 길이
 */

package Baekjoon;

import java.io.*;

public class BOJ_14517_팰린드롬개수구하기Large {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int[][] pal = new int[s.length() + 1][s.length() + 1];
        final int MOD = 10_007;

        pal[0][0] = 1;

        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                pal[j][i] = (pal[j + 1][i] + pal[j][i - 1] + (s.charAt(i) == s.charAt(j) ? 1 : MOD - pal[j + 1][i - 1])) % MOD;
            }
        }

        bw.write(Integer.toString(pal[0][s.length() - 1]));
        br.close();
        bw.close();
    }
}
