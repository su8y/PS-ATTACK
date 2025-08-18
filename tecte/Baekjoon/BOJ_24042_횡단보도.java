/*
 * 문제: 백준 24042번 - 횡단보도 (https://www.acmicpc.net/problem/24042)
 * 문제 풀이
 *  다익스트라를 활용하는데 가중치를 줄 때 문제 조건에 맞춰 가중치를 줌.
 *
 * 시간 복잡도: O(m log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_24042_횡단보도 {
    // public class Main {
    private static class Edge {
        int to;
        long w;

        public Edge(int to, long w) {
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
        long[] dist = new long[n + 1];
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingLong(e -> e.w));

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, i));
            graph.get(b).add(new Edge(a, i));
        }

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        queue.offer(new Edge(1, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (edge.w > dist[edge.to])
                continue;

            for (Edge e : graph.get(edge.to)) {
                long newDist = edge.w + (edge.w % m < e.w ? e.w - edge.w % m : m - edge.w % m + e.w);

                if (newDist < dist[e.to]) {
                    dist[e.to] = newDist;
                    queue.offer(new Edge(e.to, newDist));
                }
            }
        }

        bw.write(Long.toString(dist[n]));
        br.close();
        bw.close();
    }
}
