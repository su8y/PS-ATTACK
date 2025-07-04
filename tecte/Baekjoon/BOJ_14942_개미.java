/*
 * 문제: 백준 14942번 - 개미 (https://www.acmicpc.net/problem/14942)
 * 문제 풀이
 *  DFS로 각 노드의 깊이, 루트까지의 누적 거리, 부모 정보를 구함.
 *  각 노드의 2^k 번째 조상을 미리 구함.
 *  Binary Lifting을 사용하여 개미의 에너지로 도달할 수 있는 가장 먼 조상을 찾음.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14942_개미 {
    // public class Main {
    private static List<List<Edge>> graph = new ArrayList<>();
    private static int k;
    private static Node[] nodes;

    private static void dfs(int l, int n, int d, int p) {
        nodes[n] = new Node(l, d, p);

        for (Edge edge : graph.get(n)) {
            if (edge.to != p) {
                dfs(l + 1, edge.to, d + edge.w, n);
            }
        }
    }

    private static class Edge {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    private static class Node {
        int lv, dist;
        int[] anc = new int[k + 1];

        public Node(int lv, int dist, int anc) {
            this.lv = lv;
            this.dist = dist;
            this.anc[0] = anc;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] energies = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            energies[i] = Integer.parseInt(br.readLine());
            graph.add(new ArrayList<>());
        }

        graph.add(new ArrayList<>());

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        k = (int) (Math.log(n) / Math.log(2)) + 1;
        nodes = new Node[n + 1];
        nodes[0] = new Node(0, Integer.MIN_VALUE >> 1, 0);
        dfs(1, 1, 0, 0);

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                nodes[j].anc[i] = nodes[nodes[j].anc[i - 1]].anc[i - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            int room = i;

            for (int j = k; j >= 0; j--) {
                if (nodes[i].dist - nodes[nodes[room].anc[j]].dist <= energies[i]) {
                    room = nodes[room].anc[j];
                }
            }

            sb.append(room).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
