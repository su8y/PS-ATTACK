/*
 * 문제: 백준 2533번 - 사회망 서비스(SNS) (https://www.acmicpc.net/problem/2533)
 * 문제 풀이
 *  DP를 사용하여 최소 얼리 어탑터를 구함.
 *  점화식은 자신이 얼리 어답터일 경우와 아닐 경우로 나누어서 구함.
 *  자신이 얼리 어답터일 경우, 자식은 얼리 어답터여도 되고 아니어도 되므로 둘 중 최소값을 더함.
 *  자신이 얼리 어탭터가 아닐 경우, 자식은 반드시 얼리 어탭터여야 하므로 자식이 얼리 어탭터일 경우의 값을 더함.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2533_사회망서비스SNS {
    // public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[][] memo;

    private static void dfs(int n, int p) {
        for (int child : graph.get(n)) {
            if (child != p) {
                dfs(child, n);
                memo[0][n] += Math.min(memo[0][child], memo[1][child]);
                memo[1][n] += memo[0][child];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        memo = new int[2][n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            memo[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1, 0);
        bw.write(Integer.toString(Math.min(memo[0][1], memo[1][1])));
        br.close();
        bw.close();
    }
}
