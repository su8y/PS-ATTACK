/*
 * 문제 : 백준 14284번 - 간선 이어가기 2 (https://www.acmicpc.net/problem/14284)
 * 문제 풀이
 *  다익스트라를 사용해서 최단 경로를 찾음
 *  출발 노드부터 인접한 노드까지의 거리를 비교해서 최솟값으로 업데이트 함
 *  거리를 모두 업데이트한 후에는 방문하지 않은 노드 중 가장 거리값이 작은 노드를 택하여 반복
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14284_간선이어가기2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
            graph[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] memo = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int node = s;

        while (node != t) {
            int next = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    if (graph[node][i] != 0) {
                        if (memo[i] == 0)
                            memo[i] = memo[node] + graph[node][i];
                        else
                            memo[i] = Math.min(memo[i], memo[node] + graph[node][i]);
                    }

                    if (memo[i] != 0)
                        next = (next == 0 || memo[next] > memo[i]) ? i : next;
                }
            }

            visited[node] = true;
            node = next;
        }

        bw.write(memo[t] + "");
        br.close();
        bw.close();
    }
}
