/*
 * 문제 : 백준 1865번 - 웜홀 (https://www.acmicpc.net/problem/1865)
 * 문제 풀이
 *  벨만-포드로 음의 사이클이 있는지 확인. 이때 모든 노드들이 연결되어 있지 않을 수 있음
 *  그래서 union Find로 연결된 노드들끼리 그룹으로 묶고 각 그룹의 부모 노드를 시작 노드로 설정
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1865_웜홀_1 {
    // public class Main {
    static int n;
    static int[] parent;
    static HashSet<Integer> group;
    static ArrayList<Edge> edge;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            parent = new int[n + 1];
            group = new HashSet<>();
            edge = new ArrayList<>();
            dist = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                dist[i] = Integer.MAX_VALUE;
                parent[i] = i;
                group.add(i);
            }

            for (int i = 0; i < m + w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                if (i < m) {
                    edge.add(new Edge(s, e, t));
                    edge.add(new Edge(e, s, t));
                } else {
                    edge.add(new Edge(s, e, -t));
                }

                union(s, e);
            }

            for (int i : group)
                dist[i] = 0;

            bw.write(bellmanFord() ? "YES" : "NO");
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            group.remove(rootB);
            parent[rootA] = rootB;
        }
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    public static boolean bellmanFord() {
        for (int i = 1; i <= n; i++) {
            for (Edge e : edge) {
                if (dist[e.s] != Integer.MAX_VALUE && dist[e.e] > dist[e.s] + e.w) {
                    dist[e.e] = dist[e.s] + e.w;

                    if (i == n)
                        return true;
                }
            }
        }

        return false;
    }

    public static class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {

            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}
