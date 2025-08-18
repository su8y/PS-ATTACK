/*
 * 문 제 : 백준 11050번 - 이항 계수 1 (https://www.acmicpc.net/problem/11050)
 * 문제 풀이
 *  이항계수는 주어진 집합에서 원하는 개수만큼 순서없이 뽑는 조합의 개수
 *  nCk = n! / (n - k)! * k!
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11050_이항계수1 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] memo = new int[n + 1];

        memo[0] = 1;
        for (int i = 1; i < n + 1; i++)
            memo[i] = i * memo[i - 1];

        bw.write(memo[n] / (memo[n - k] * memo[k]) + "");

        br.close();
        bw.close();
    }
}
