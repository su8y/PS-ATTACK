/*
 * 문제 : 백준 1865번 - 웜홀 (https://www.acmicpc.net/problem/1865)
 * 문제 풀이
 *  시작 노드를 1~N으로 잡으면, 어떤 시작 노드에서 음의 사이클이 나타날 지 몰라 벨만-포드를 N번 돌려야함
 *  하지만 이 문제는 음의 사이클 여부만 찾고 있기 때문에 실제 최단 거리가 어떻게 갱신되는지는 중요치 않음
 *  가상 노드 0을 만들고 이 노드를 시작 노드로 함. 가상 노드 0에서 다른 모든 노드로 0의 가중치를 가진 단방향 간선들을 연결하면
 *  맨 처음 최단 경로를 저장하는 배열이 INF가 아니라 0으로 갱신됨
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1865_웜홀_2 {
    // public class Main {
    static int n;
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
            edge = new ArrayList<>();
            dist = new int[n + 1];

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
            }

            bw.write(bellmanFord() ? "YES" : "NO");
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static boolean bellmanFord() {
        for (int i = 1; i <= n; i++) {
            for (Edge e : edge) {
                if (dist[e.e] > dist[e.s] + e.w) {
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
