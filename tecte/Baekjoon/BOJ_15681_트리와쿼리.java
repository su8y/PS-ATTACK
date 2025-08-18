/*
 * 문제: 백준 15681번 - 트리와 쿼리 (https://www.acmicpc.net/problem/15681)
 * 문제 풀이
 *  DFS로 각 노드의 서브트리 크기를 메모이제이션 함.
 *
 * 시간 복잡도: O(n + q)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15681_트리와쿼리 {
    // public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] memo;

    private static int dfs(int p) {
        int cnt = 1;

        visited[p] = true;

        for (int child : graph.get(p)) {
            if (!visited[child]) {
                cnt += dfs(child);
            }
        }

        return memo[p] = cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n + 1];
        memo = new int[n + 1];
        dfs(r);

        for (int i = 0; i < q; i++) {
            int u = Integer.parseInt(br.readLine());

            bw.write(memo[u] + "\n");
        }

        br.close();
        bw.close();
    }
}
