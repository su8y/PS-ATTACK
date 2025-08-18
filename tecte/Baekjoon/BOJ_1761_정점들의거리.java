/*
 * 문제: 백준 1761번 - 정점들의 거리 (https://www.acmicpc.net/problem/1761)
 * 문제 풀이
 *  DFS로 각 노드의 깊이와 누적 거리를 저장한 뒤, 모든 노드에 대해 2^k 번째 조상을 미리 계산함.
 *  최소 공통 조상(Lowest Common Ancestor, LCA)의 Binary Lifting을 사용해 공통 조상을 찾고 이를 통해 두 노드 간의 거리를 계산.
 *
 * 시간 복잡도: O((n + m) log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1761_정점들의거리 {
    // public class Main {
    private static int k = 0;
    private static List<List<Edge>> graph = new ArrayList<>();
    private static Node[] nodes;

    private static void dfs(int depth, int node, int parent, int dist) {
        nodes[node] = new Node(depth, dist, parent);

        for (Edge child : graph.get(node)) {
            if (child.to != parent) {
                dfs(depth + 1, child.to, node, dist + child.w);
            }
        }
    }

    private static int lca(int a, int b) {
        if (nodes[a].depth < nodes[b].depth) {
            int tmp = a;

            a = b;
            b = tmp;
        }

        for (int i = k; i >= 0; i--) {
            if (nodes[a].depth - nodes[b].depth >= 1 << i) {
                a = nodes[a].ancestor[i];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = k; i >= 0; i--) {
            if (nodes[a].ancestor[i] != nodes[b].ancestor[i]) {
                a = nodes[a].ancestor[i];
                b = nodes[b].ancestor[i];
            }
        }

        return nodes[a].ancestor[0];
    }

    private static class Edge {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    private static class Node {
        int depth, dist;
        int[] ancestor;

        public Node(int depth, int dist, int ancestor) {
            this.depth = depth;
            this.dist = dist;
            this.ancestor = new int[k + 1];
            this.ancestor[0] = ancestor;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        while (1 << (k + 1) <= n) {
            k++;
        }

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, w));
            graph.get(b).add(new Edge(a, w));
        }

        nodes = new Node[n + 1];
        nodes[0] = new Node(0, 0, 0);
        dfs(0, 1, 0, 0);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                nodes[j].ancestor[i] = nodes[nodes[j].ancestor[i - 1]].ancestor[i - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ca = lca(a, b);

            sb.append(nodes[a].dist + nodes[b].dist - (nodes[ca].dist << 1)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
