/*
 * 문제: 백준 1647번 - 도시 분할 계획 (https://www.acmicpc.net/problem/1647)
 * 문제 풀이
 *  크루스칼 알고리즘을 사용해서 MST를 만듦.
 *  두 개의 그룹이 될 때까지 가중치가 가장 작은 간선부터 트리에 추가.
 *
 * 시간 복잡도: O(m log m)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {
    // public class Main {
    private static int[] parents;
    private static int cnt;

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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Edge> streets = new ArrayList<>(n + 1);
        int cost = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            streets.add(new Edge(a, b, c));
        }

        streets.sort(Comparator.comparingInt(a -> a.w));
        parents = new int[n + 1];
        cnt = n;

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (Edge edge : streets) {
            if (cnt == 2) {
                break;
            }

            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                cost += edge.w;
                cnt--;
            }
        }

        bw.write(Integer.toString(cost));
        br.close();
        bw.close();
    }
}
