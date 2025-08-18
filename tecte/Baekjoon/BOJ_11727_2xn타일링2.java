/*
 * 문제 : 백준 11727번 - 2×n 타일링 2 (https://www.acmicpc.net/problem/11727)
 * 문제 풀이
 *  T(n)을 2*n 직사각형을 타일로 채우는 방법의 수라고 할 때
 *  T(n)을 구하기 위해서는 T(n-1)에서 2*1 크기의 타일을 채우는 방법 하나와
 *  T(n-2)에서 1*2 크기의 타일 2개와 2*2 크기의 타일 1개로 채우는 방법 두 개가 있으므로
 *  이를 식으로 만들면 T(n) = T(n-1) + 2*T(n-2)가 됨
 */

package Baekjoon;

import java.io.*;

public class BOJ_11727_2xn타일링2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] memo = new int[n + 1];

        memo[0] = memo[1] = 1;

        for (int i = 2; i <= n; i++)
            memo[i] = (memo[i - 1] + memo[i - 2] * 2) % 10007;

        bw.write(memo[n] + "");
        br.close();
        bw.close();
    }
}
