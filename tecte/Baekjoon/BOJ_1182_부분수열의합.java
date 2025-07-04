/*
 * 문제: 백준 1182번 - 부분수열의 합 (https://www.acmicpc.net/problem/1182)
 * 문제 풀이
 *  모든 부분 집합을 탐색해서 그 합이 s인 경우를 셈.
 *
 * 시간 복잡도: O(2^n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
    // public class Main {
    private static int n, s;
    private static int[] arr;
    private static int cnt = 0;

    private static void dfs(int pos, int sum) {
        for (int i = pos; i < n; i++) {
            int newSum = sum + arr[i];

            if (newSum == s)
                cnt++;

            dfs(i + 1, newSum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dfs(0, 0);
        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
