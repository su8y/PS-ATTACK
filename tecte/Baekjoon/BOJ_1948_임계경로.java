/*
 * 문제: 백준 1948번 - 임계경로 (https://www.acmicpc.net/problem/1948)
 * 문제 풀이
 *  위상 정렬로 최장 경로의 시간을 구하고 역방향 그래프로 최장 경로의 간선 수를 역추적.
 *
 * 시간 복잡도: O(n + m)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1948_임계경로 {
    // public class Main {
    private static class Edge {
        int id, to, w;

        public Edge(int id, int to, int w) {
            this.id = id;
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()) + 1;
        int m = Integer.parseInt(br.readLine());
        List<List<Edge>> graph = new ArrayList<>(n);
        List<List<Edge>> reverse = new ArrayList<>(n);
        int[] inDeg = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(i, e, t));
            reverse.get(e).add(new Edge(i, s, t));
            inDeg[e]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int[] times = new int[n];
        boolean[] visited = new boolean[m];
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        queue.offer(s);

        while (!queue.isEmpty()) {
            int city = queue.poll();

            for (Edge edge : graph.get(city)) {
                int time = times[city] + edge.w;

                if (time > times[edge.to]) {
                    times[edge.to] = time;
                }

                if (--inDeg[edge.to] == 0) {
                    queue.offer(edge.to);
                }
            }
        }

        queue.offer(e);

        while (!queue.isEmpty()) {
            int city = queue.poll();

            for (Edge edge : reverse.get(city)) {
                if (times[city] == times[edge.to] + edge.w && !visited[edge.id]) {
                    visited[edge.id] = true;
                    cnt++;
                    queue.offer(edge.to);
                }
            }
        }

        sb.append(times[e]).append("\n").append(cnt);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
