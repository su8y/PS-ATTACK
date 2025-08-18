/*
 * 문제: 백준 10942번 - 팰린드롬? (https://www.acmicpc.net/problem/10942)
 * 문제 풀이
 *  DP를 사용해서 s에서 e까지의 구간이 팰린드롬인지 구함.
 *  s에서 e까지의 구간이 팬린드롬인지 구할 때,
 *  s+1에서 e-1까지의 구간이 팰린드롬이고 s 번째와 e 번째 수가 같으면 s에서 e까지 팰린드롬이고
 *  s+1에서 e-1까지의 구간이 팰린드롬이 아니거나 s 번째와 e 번째 수가 같지 않으면 팬린드롬이 아님.
 *  팰린드롬 여부가 구해지면 메모이제이션 함.
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10942_팰린드롬 {
    // public class Main {
    private static int[] arr;
    private static int[][] memo;

    private static boolean dfs(int s, int e) {
        if (memo[s][e] > 0) {
            return memo[s][e] == 1;
        }

        if (dfs(s + 1, e - 1) && arr[s] == arr[e]) {
            memo[s][e] = 1;

            return true;
        } else {
            memo[s][e] = 2;

            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        int m = Integer.parseInt(br.readLine());
        memo = new int[n + 1][n + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            memo[i][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            memo[i][i + 1] = arr[i] == arr[i + 1] ? 1 : 2;

        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(dfs(s, e) ? 1 : 0).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
