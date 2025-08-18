/*
 * 문제 : 백준 1753번 - 최단경로 (https://www.acmicpc.net/problem/1753)
 * 문제 풀이
 *  우선순위 큐를 사용한 디익스트라로 최단경로를 구함
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        ArrayList<Node>[] graph = new ArrayList[V + 1];
        int[] dist = new int[V + 1];
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));

        for (int i = 1; i <= V; i++) {
            dist[i] = 200001;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        queue.offer(new Node(k, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (dist[node.v] > node.w) {
                dist[node.v] = node.w;

                for (Node next : graph[node.v]) {
                    Node newNode = new Node(next.v, dist[node.v] + next.w);

                    if (dist[next.v] > newNode.w)
                        queue.offer(newNode);
                }
            }
        }

        for (int i = 1; i <= V; i++)
            bw.write((dist[i] > 200000 ? "INF" : dist[i]) + "\n");

        br.close();
        bw.close();
    }

    public static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
