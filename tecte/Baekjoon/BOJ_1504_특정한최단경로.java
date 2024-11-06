/*
 * 문제: 백준 1504번 - 특정한 최단 경로 (https://www.acmicpc.net/problem/1504)
 * 문제 풀이
 *  입력받은 두 정점 v1, v2에서 다익스트라로 최단 경로를 구함.
 *  1 -> v1 -> v2 -> n, 1 -> v2 -> v1 -> n 이 두 경우의 최단 경로를 비교하여 작은 값이 최단 경로.
 *
 * 시간 복잡도: O(E log V) - E: 간선의 수, V: 정점의 수
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1504_특정한최단경로 {
    // public class Main {
    static int n;
    static List<List<Edge>> graph = new ArrayList<>();

    static class Edge {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static int[] dijkstra(int v) {
        int[] dist = new int[n + 1];
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));

        Arrays.fill(dist, Integer.MAX_VALUE >> 2);
        queue.offer(new Edge(v, 0));
        dist[v] = 0;

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (edge.w > dist[edge.to])
                continue;

            for (Edge neighbor : graph.get(edge.to)) {
                int newDist = edge.w + neighbor.w;

                if (dist[neighbor.to] > newDist) {
                    dist[neighbor.to] = newDist;
                    queue.offer(new Edge(neighbor.to, newDist));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] distA = dijkstra(a);
        int[] distB = dijkstra(b);
        int dist = Math.min(distA[1] + distB[n], distB[1] + distA[n]) + distA[b];

        if (dist >= Integer.MAX_VALUE >> 2)
            bw.write("-1");
        else
            bw.write(Integer.toString(dist));

        br.close();
        bw.close();
    }
}
