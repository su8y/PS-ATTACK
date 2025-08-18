/*
 * 문제: 백준 5972번 - 택배 배송 (https://www.acmicpc.net/problem/5972)
 * 문제 풀이
 *  다익스트라로 1 -> n의 최단 거리를 구함.
 *
 * 시간 복잡도: O(m log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_5972_택배배송 {
    // public class Main {
    static class Edge {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Edge>> graph = new ArrayList<>(n + 1);
        int[] dist = new int[n + 1];
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        queue.offer(new Edge(1, 0));
        dist[1] = 0;

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (edge.to == n)
                break;
            else if (dist[edge.to] < edge.w)
                continue;

            for (Edge e : graph.get(edge.to)) {
                int newDist = dist[edge.to] + e.w;

                if (newDist < dist[e.to]) {
                    queue.offer(new Edge(e.to, newDist));
                    dist[e.to] = newDist;
                }
            }
        }

        bw.write(Integer.toString(dist[n]));
        br.close();
        bw.close();
    }
}
