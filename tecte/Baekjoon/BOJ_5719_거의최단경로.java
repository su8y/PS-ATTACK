/*
 * 문제: 백준 5719번 - 거의 최단 경로 (https://www.acmicpc.net/problem/5719)
 * 문제 풀이
 *  다익스트라를 사용하여 최단 경로를 구함.
 *  역방향 그래프를 이용하여 최단 경로에 포함된 간선들을 제거.
 *  다시 다익스트라를 사용하여 거의 최단 경로를 구함.
 *
 * 시간 복잡도: O(t * (n + m) log n) - t: 테스트 케이스 수
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_5719_거의최단경로 {
    // public class Main {
    private static int[] dijkstra(List<List<Edge>> graph, boolean[] visited, int s) {
        int[] dist = new int[graph.size()];
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        queue.offer(new Edge(s, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (edge.w > dist[edge.to]) {
                continue;
            }

            for (Edge next : graph.get(edge.to)) {
                if (!visited[next.id]) {
                    int nd = edge.w + next.w;

                    if (nd < dist[next.to]) {
                        dist[next.to] = nd;
                        queue.offer(new Edge(next.to, nd));
                    }
                }
            }
        }

        return dist;
    }

    private static class Edge {
        int id, to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }

        public Edge(int id, int to, int w) {
            this.id = id;
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            List<List<Edge>> graph = new ArrayList<>(n);
            List<List<Edge>> reverse = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
                reverse.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                graph.get(u).add(new Edge(i, v, p));
                reverse.get(v).add(new Edge(i, u, p));
            }

            boolean[] visited = new boolean[m];
            int[] dist = dijkstra(graph, visited, s);
            Queue<Integer> queue = new LinkedList<>();

            queue.offer(d);

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (Edge edge : reverse.get(node)) {
                    if (!visited[edge.id] && dist[edge.to] + edge.w == dist[node]) {
                        visited[edge.id] = true;
                        queue.offer(edge.to);
                    }
                }
            }

            dist = dijkstra(graph, visited, s);
            sb.append(dist[d] == Integer.MAX_VALUE ? -1 : dist[d]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
