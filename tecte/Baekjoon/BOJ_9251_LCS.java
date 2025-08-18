/*
 * 문제 : 백준 9251번 - LCS (https://www.acmicpc.net/problem/9251)
 * 문제 풀이
 *  두 문자열을 행과 열로 나열해서 비교함
 *  예를 들어, ACAYKP와 CAPCAK를 나열했을 때 처음 {A}와 비교할 수열들은
 *  {C}, {C, A}, {C, A, P}, {C, A, P, C}, {C, A, P, C, A}, {C, A, P, C, A, K} 이렇게 있음
 *  {A]는 {C, A}부터 있으니까 {C}는 0을 넣고 {C, A}부터 {C, A, P, C, A, K}까지 1을 넣음
 *  그 다음 {A, C}를 비교할 때, {C}는 C가 있으니 1, {C, A}와 {C, A, P}는 C나 A가 있으니 1, {C, A, P, C}부터는 A, C 다 있으니 2를 넣음
 *  이런 식으로 하다 보면 규칙이 발생. x번째 원소와 y번째 원소가 같다면 (x-1, y-1)의 LCS 길이의 +1이 되고
 *  같지 않다면 (x-1, y)의 LCS 와 (x, y-1)의 LCS 중에 큰 값으로 됨
 *  이 규칙을 사용해 dp의 bottom-up 방식으로 두 문자열의 LCS(최장 공통 부분 수열) 길이를 구함
 */

package Baekjoon;

import java.io.*;

public class BOJ_9251_LCS {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        int[][] memo = new int[a.length + 1][b.length + 1];

        for (int i = 1; i <= a.length; i++)
            for (int j = 1; j <= b.length; j++)
                memo[i][j] = a[i - 1] == b[j - 1] ? memo[i - 1][j - 1] + 1 : Math.max(memo[i - 1][j], memo[i][j - 1]);

        bw.write(memo[a.length][b.length] + "");
        br.close();
        bw.close();
    }
}
