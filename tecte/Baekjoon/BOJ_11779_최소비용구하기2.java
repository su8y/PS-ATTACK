/*
 * 문제 : 백준 11779번 - 최소비용 구하기 2 (https://www.acmicpc.net/problem/11779)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11779_최소비용구하기2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Edge>> graph = new ArrayList<>(n + 1);
        int[] dist = new int[n + 1];
        int[] cnt = new int[n + 1];
        String[] path = new String[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(a -> a.w));

        dist[s] = 0;
        cnt[s] = 1;
        path[s] = Integer.toString(s);
        queue.offer(new Edge(s, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (edge.w > dist[edge.to])
                continue;

            for (Edge bus : graph.get(edge.to)) {
                int newDist = dist[edge.to] + bus.w;

                if (dist[bus.to] > newDist) {
                    dist[bus.to] = newDist;
                    cnt[bus.to] = cnt[edge.to] + 1;
                    path[bus.to] = path[edge.to] + " " + bus.to;
                    queue.offer(new Edge(bus.to, newDist));
                }
            }
        }

        bw.write(dist[e] + "\n");
        bw.write(cnt[e] + "\n");
        bw.write(path[e]);
        br.close();
        bw.close();
    }

    static class Edge {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
}
