/*
 * 문제 : 백준 11726번 - 2×n 타일링 (https://www.acmicpc.net/problem/11726)
 * 문제 풀이
 * 	n=1일 때 1, n=2일 때 2, n=3일 때 3, n=4일 때 5 n=5일 때 8 ...
 * 	n번째 = (n-1)번째 + (n-2)번째의 규칙을 가진다
 * 	n번째 수를 구할 때 n-1와 n-2를 재귀호출해 배열 dp에 저장된 값이 있으면 가져오고,
 * 	없으면(n-1이 없다고 가정) (n-1)-1과 (n-1)-2를 재귀호출해 값을 가져온다
 */

package Baekjoon;

import java.io.*;

public class BOJ_11726_2xn타일링 {
    // public class Main {
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        // 재귀호출 탈출을 위해 dp[0]과 dp[1] 값을 설정
        dp[0] = 1;
        dp[1] = 1;

        bw.write(Integer.toString(getN(n)));

        br.close();
        bw.close();
    }

    public static int getN(int n) {
        if (dp[n] == 0) // dp에 저장된 값이 없는 경우, n-1과 n-2를 재귀호출
            dp[n] = (getN(n - 1) + getN(n - 2)) % 10007;

        return dp[n];
    }
}
