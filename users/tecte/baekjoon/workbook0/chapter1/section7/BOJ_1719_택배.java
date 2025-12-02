/*
 * 문제: 백준 1719번 - 택배 (https://www.acmicpc.net/problem/1719)
 * 문제 풀이
 *  플로이드 워셜을 사용하여 모든 집하장 간의 최단 거리를 구함.
 *  최단 경로를 갱신할 때마다 해당 최단 경로에서 가장 먼저 거쳐야 하는 집하장도 함께 갱신함.
 *
 * 시간 복잡도: O(n³)
 */

package baekjoon.workbook0.chapter1.section7;

import java.io.*;
import java.util.*;

public class BOJ_1719_택배 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n + 1][n + 1];
        int[][] near = new int[n + 1][n + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE / 2);
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (c < graph[a][b]) {
                graph[a][b] = graph[b][a] = c;
                near[a][b] = b;
                near[b][a] = a;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int dist = graph[i][k] + graph[k][j];

                    if (dist < graph[i][j]) {
                        graph[i][j] = dist;
                        near[i][j] = near[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(i == j ? "-" : near[i][j]).append(" ");
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
