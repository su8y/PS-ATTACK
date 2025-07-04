/*
 * 문제: 백준 22954번 - 그래프 트리 분할 (https://www.acmicpc.net/problem/22954)
 * 문제 풀이
 *  Union-Find로 연견되어 있는 정점들을 찾아서 트리로 만듬.
 *  Union-Find로 찾은 루트 정점의 개수가 트리의 개수.
 *  트리의 개수가 3개 이상이면 -1을 출력하고 2개면 트리의 크기가 같은지 확인해서 같으면 -1, 다르면 BFS로 트리의 정점과 간선의 번호 출력.
 *  트리의 개수가 1개면 마지막 말단 정점과 연결된 간선을 제거하여 2개의 트리로 만듬.
 *
 * 시간 복잡도: O(n + m)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_22954_그래프트리분할 {
    // public class Main {
    private static Node[] nodes;

    private static int find(int n) {
        while (true) {
            if (n == nodes[n].root)
                return n;

            nodes[n].root = nodes[nodes[n].root].root;
            n = nodes[n].root;
        }
    }

    private static void union(int a, int b, int i) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return;

        if (rootA > rootB)
            nodes[rootA].root = rootB;
        else
            nodes[rootB].root = rootA;

        nodes[a].edges.add(new Edge(i, b));
        nodes[b].edges.add(new Edge(i, a));
    }

    private static StringBuilder bfs(int n, int size, boolean[] visited) {
        Queue<Edge> queue = new LinkedList<>();
        StringBuilder ns = new StringBuilder();
        StringBuilder es = new StringBuilder();

        visited[n] = true;
        ns.append("\n").append(n).append(" ");
        size--;

        for (Edge edge : nodes[n].edges) {
            queue.offer(edge);
            visited[edge.to] = true;
        }

        while (size-- > 0 && !queue.isEmpty()) {
            Edge edge = queue.poll();

            ns.append(edge.to).append(" ");
            es.append(edge.idx).append(" ");

            for (Edge e : nodes[edge.to].edges) {
                if (!visited[e.to]) {
                    queue.offer(e);
                    visited[e.to] = true;
                }
            }
        }

        ns.append("\n").append(es);

        if (!queue.isEmpty())
            ns.append("\n").append(queue.poll().to);

        return ns;
    }

    private static class Edge {
        int idx, to;

        public Edge(int idx, int to) {
            this.idx = idx;
            this.to = to;
        }
    }

    private static class Node {
        int root;
        List<Edge> edges = new ArrayList<>();

        public Node(int n) {
            this.root = n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nodes = new Node[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++)
            nodes[i] = new Node(i);

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            union(u, v, i);
        }

        for (int i = 1; i <= n; i++) {
            int root = find(i);

            map.put(root, map.getOrDefault(root, 0) + 1);
        }

        if (n < 3 || map.size() > 2) {
            sb.append(-1);
        } else {
            List<Integer> keys = new ArrayList<>(map.keySet());
            boolean[] visited = new boolean[n + 1];

            if (map.size() == 1) {
                int size = map.get(keys.get(0)) - 1;

                sb.append(size).append(" 1").append(bfs(keys.get(0), size, visited));
            } else if (map.get(keys.get(0)).equals(map.get(keys.get(1)))) {
                sb.append(-1);
            } else {
                sb.append(map.get(keys.get(0))).append(" ").append(map.get(keys.get(1)));

                for (int key : map.keySet())
                    sb.append(bfs(key, map.get(key), visited));
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
