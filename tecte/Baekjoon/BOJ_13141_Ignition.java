/*
 * 문제: 백준 13141번 - Ignition (https://www.acmicpc.net/problem/13141)
 * 문제 풀이
 *  플로이드-워셜로 정점 간의 최단거리를 구함.
 *  간선의 길이를 L, 간선의 양 끝 정점에 불이 도달하는 시간을 A, B라 할 때 (단, A < B)
 *  A와 B 모두 불에 타는 시점에 간선의 남은 길이는 L - (B - A), 남은 간선마저 타오르는 시간은 (L - (B - A)) / 2 + B
 *  모든 정점에 대해 해당 정점에서 다른 모든 정점 또는 간선 중 가장 늦게 불이 도달하는 시간을 계산하고 그중 가장 짧은 시간을 구함.
 *
 * 시간 복잡도: O(n^3)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_13141_Ignition {
    // public class Main {
    private static class Edge {
        int f, t, w;

        public Edge(int f, int t, int w) {
            this.f = f;
            this.t = t;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n + 1][n + 1];
        List<Edge> edges = new ArrayList<>();
        double time = Double.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE >> 1);
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph[s][e] = graph[e][s] = Math.min(graph[s][e], l);
            edges.add(new Edge(s, e, l));
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            double t = 0;

            for (int j = 1; j <= n; j++) {
                t = Math.max(t, graph[i][j]);
            }

            for (Edge edge : edges) {
                int a, b;

                if (graph[i][edge.f] < graph[i][edge.t]) {
                    a = graph[i][edge.f];
                    b = graph[i][edge.t];
                } else {
                    a = graph[i][edge.t];
                    b = graph[i][edge.f];
                }

                double diff = edge.w - (b - a);

                if (diff > 0) {
                    t = Math.max(t, diff / 2 + b);
                }
            }

            time = Math.min(time, t);
        }

        bw.write(Double.toString(time));
        br.close();
        bw.close();
    }
}
