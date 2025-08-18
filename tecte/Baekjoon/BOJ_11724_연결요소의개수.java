/*
 * 문제 : 백준 11724번 - 연결 요소의 개수 (https://www.acmicpc.net/problem/11724)
 * 문제 풀이
 *  boolean 타입의 2차원 배열에 정점들의 간선들을 저장하고 DFS로 탐색하며 연결 요소의 개수를 구함
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s][e] = true;
            graph[e][s] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(graph, visited, i);
            }
        }

        bw.write(cnt + "");
        br.close();
        bw.close();
    }

    public static void dfs(boolean[][] graph, boolean[] visited, int node) {
        visited[node] = true;

        for (int i = 1; i < graph.length; i++)
            if (graph[node][i] && !visited[i])
                dfs(graph, visited, i);
    }
}
