/*
 * 문제: 백준 13116번 - 30번 (https://www.acmicpc.net/problem/13116)
 * 문제 풀이
 *  Binary Lifting를 사용하여 LCA를 구하고 10을 곱함.
 *
 * 시간 복잡도: O(t log a)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_13116_30번 {
    // public class Main {
    private static int[][] ancestors = new int[1024][10];
    private static int[] lv = new int[1024];

    private static void dfs(int depth, int n, int p) {
        if (depth > 10) {
            return;
        }

        lv[n] = depth;
        ancestors[n][0] = p;

        for (int i = 1; i < depth; i++) {
            ancestors[n][i] = ancestors[ancestors[n][i - 1]][i - 1];
        }

        int c = n << 1;

        dfs(depth + 1, c, n);
        dfs(depth + 1, c + 1, n);
    }

    private static int lca(int a, int b) {
        if (lv[a] > lv[b]) {
            int tmp = a;

            a = b;
            b = tmp;
        }

        for (int i = 9; i >= 0; i--) {
            if (lv[ancestors[b][i]] >= lv[a]) {
                b = ancestors[b][i];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = 9; i >= 0; i--) {
            if (ancestors[a][i] != ancestors[b][i]) {
                a = ancestors[a][i];
                b = ancestors[b][i];
            }
        }

        return ancestors[a][0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        dfs(1, 1, 0);

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lca(a, b) * 10).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
