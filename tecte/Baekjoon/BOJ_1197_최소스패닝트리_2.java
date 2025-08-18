/*
 * 문제: 백준 1197번 - 최소 스패닝 트리 (https://www.acmicpc.net/problem/1197)
 * 문제 풀이
 *  MST(Minimum Spanning Tree)를 구할 때 사용하는 알고리즘인 Kruskal(크루스칼)과 Prim(프림) 중에서 Prim 알고리즘을 사용한 방법.
 *  Prim은 정점 중심의 알고리즘으로, 트리에서 하나의 정점을 선택하고 그 정점과 연결된 간선 중에서 가중치가 가장 작은 간선을 선택해서 트리를 확장.
 *  우선순위 큐를 사용해서 트리에 포함된 정점에서 연결된 간선들 중 가중치가 가장 작은 간선을 선택.
 *  해당 간선이 연결된 정점을 트리에 추가.
 *  모든 정점이 연결될 때까지 반복.
 *
 * 시간 복잡도: O(e log v)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1197_최소스패닝트리_2 {
    // public class Main {
    private static class Edge {
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
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<List<Edge>> graph = new ArrayList<>(v + 1);
        boolean[] visited = new boolean[v + 1];
        int[] dist = new int[v + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        int weight = 0;

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        pq.offer(new Edge(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (visited[edge.to]) {
                continue;
            }

            visited[edge.to] = true;
            weight += edge.w;

            for (Edge next : graph.get(edge.to)) {
                if (!visited[next.to] && dist[next.to] > next.w) {
                    pq.offer(next);
                    dist[next.to] = next.w;
                }
            }
        }

        bw.write(Integer.toString(weight));
        br.close();
        bw.close();
    }
}
