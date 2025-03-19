/*
 * 문제: 백준 2887번 - 행성 터널 (https://www.acmicpc.net/problem/2887)
 * 문제 풀이
 *  행성 간 최소 비용으로 모든 행성을 연결하는 최소 스패닝 트리 문제.
 *  모든 행성을 직접 연결하면 O(n²)로 비효율적이므로 x, y, z 별로 정렬 후 인접한 행성만 연결하여 간선 개수를 줄임.
 *  그 후 크루스칼을 사용하여 최소 비용 MST를 구함.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2887_행성터널 {
    // public class Main {
    private static int[] parents;

    private static int find(int e) {
        return parents[e] == e ? e : (parents[e] = find(parents[e]));
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        } else if (rootA < rootB) {
            parents[rootB] = rootA;
        } else {
            parents[rootA] = rootB;
        }

        return true;
    }

    private static class Planet {
        int id, x, y, z;

        public Planet(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
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
        int n = Integer.parseInt(br.readLine());
        Planet[] planets = new Planet[n];
        List<Edge> edges = new ArrayList<>();
        long cost = 0;

        parents = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets[i] = new Planet(i, x, y, z);
            parents[i] = i;
        }

        Arrays.sort(planets, Comparator.comparingInt(a -> a.x));

        for (int i = 1; i < n; i++) {
            Planet a = planets[i - 1];
            Planet b = planets[i];

            edges.add(new Edge(a.id, b.id, b.x - a.x));
        }

        Arrays.sort(planets, Comparator.comparingInt(a -> a.y));

        for (int i = 1; i < n; i++) {
            Planet a = planets[i - 1];
            Planet b = planets[i];

            edges.add(new Edge(a.id, b.id, b.y - a.y));
        }

        Arrays.sort(planets, Comparator.comparingInt(a -> a.z));

        for (int i = 1; i < n; i++) {
            Planet a = planets[i - 1];
            Planet b = planets[i];

            edges.add(new Edge(a.id, b.id, b.z - a.z));
        }

        edges.sort(Comparator.comparingInt(a -> a.w));

        for (Edge edge : edges) {
            if (union(edge.u, edge.v)) {
                cost += edge.w;

                if (--n == 1) {
                    break;
                }
            }
        }

        bw.write(Long.toString(cost));
        br.close();
        bw.close();
    }
}
