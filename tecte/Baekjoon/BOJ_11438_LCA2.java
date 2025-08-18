/*
 * 문제: 백준 11438번 - LCA 2  (https://www.acmicpc.net/problem/11438)
 * 문제 풀이
 *  모든 노드에 대해 2^k 번째 조상을 미리 계산하고 LCA를 사용하여 공통 조상을 구함.
 *
 * 시간 복잡도: O(m log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11438_LCA2 {
    // public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int k;
    private static Node[] nodes;

    private static void dfs(int lv, int n, int p) {
        nodes[n] = new Node(lv, p);

        for (int c : graph.get(n)) {
            if (c != p) {
                dfs(lv + 1, c, n);
            }
        }
    }

    private static int lca(int a, int b) {
        if (nodes[a].level > nodes[b].level) {
            int tmp = a;

            a = b;
            b = tmp;
        }

        for (int i = k; i >= 0; i--) {
            if (nodes[a].level <= nodes[nodes[b].ancestor[i]].level) {
                b = nodes[b].ancestor[i];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = k; i >= 0; i--) {
            if (nodes[a].ancestor[i] != nodes[b].ancestor[i]) {
                a = nodes[a].ancestor[i];
                b = nodes[b].ancestor[i];
            }
        }

        return nodes[a].ancestor[0];
    }

    private static class Node {
        int level;
        int[] ancestor = new int[k + 1];

        public Node(int level, int ancestor) {
            this.level = level;
            this.ancestor[0] = ancestor;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        k = (int) (Math.log(n) / Math.log(2)) + 1;
        nodes = new Node[n + 1];
        nodes[0] = new Node(0, 0);
        dfs(1, 1, 0);

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                nodes[j].ancestor[i] = nodes[nodes[j].ancestor[i - 1]].ancestor[i - 1];
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lca(a, b)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
