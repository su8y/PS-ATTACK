/*
 * 문제: 백준 14938번 - 서강그라운드 (https://www.acmicpc.net/problem/14938)
 * 문제 풀이
 *  모든 지역을 각각 다익스트라를 통해 다른 지역까지의 최단 거리를 구함.
 *  구한 최단 거리에서 수색 범위 내에 있는 지역의 아이템 개수의 합을 구함.
 *  구한 아이템 개수의 합 중 가장 큰 값이 예은이가 얻을 수 있는 최대 아이템 개수.
 *
 * 시간 복잡도: O(n^2 log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14938_서강그라운드 {
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
        int r = Integer.parseInt(st.nextToken());
        List<List<Edge>> graph = new ArrayList<>(n + 1);
        int[] item = new int[n + 1];
        int cnt = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++)
            item[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, l));
            graph.get(b).add(new Edge(a, l));
        }

        for (int i = 0; i < n; i++) {
            PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
            int[] dist = new int[n + 1];
            int newCnt = 0;

            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            queue.offer(new Edge(i, 0));

            while (!queue.isEmpty()) {
                Edge edge = queue.poll();

                if (edge.w > m)
                    break;
                else if (edge.w > dist[edge.to])
                    continue;

                newCnt += item[edge.to];

                for (Edge e : graph.get(edge.to)) {
                    int newDist = dist[edge.to] + e.w;

                    if (dist[e.to] > newDist) {
                        dist[e.to] = newDist;
                        queue.offer(new Edge(e.to, newDist));
                    }
                }
            }

            cnt = Math.max(cnt, newCnt);
        }

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
