/*
 * 문제: 백준 1197번 - 최소 스패닝 트리 (https://www.acmicpc.net/problem/1197)
 * 문제 풀이
 *  MST(Minimum Spanning Tree)를 구할 때 사용하는 알고리즘인 Kruskal(크루스칼)과 Prim(프림) 중에서 Kruskal 알고리즘을 사용한 방법.
 *  Kruskal은 간선 중심의 알고리즘으로, 간선의 가중치를 기준으로 가중치가 최소인 간선을 선택하여 트리를 확장.
 *  그래프의 모든 간선을 가중치를 기준으로 오름차순으로 정렬.
 *  가중치가 가장 작은 간선부터 하나씩 트리에 추가.
 *  Union-Find로 사이클이 생기지 않게 함.
 *  모든 정점이 연결될 때까지 반복.
 *
 * 시간 복잡도: O(e log e)
 */

package Baekjoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리_1 {
    // public class Main {
    private static int[] parents;

    private static int find(int e) {
        return parents[e] == e ? e : (parents[e] = find(parents[e]));
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA < rootB) {
            parents[rootB] = rootA;
        } else if (rootA > rootB) {
            parents[rootA] = rootB;
        }
    }

    private static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        parents = new int[v + 1];
        int weight = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(a, b, c));
        }


        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                weight += edge.w;
            }
        }

        bw.write(Integer.toString(weight));
        br.close();
        bw.close();
    }
}
