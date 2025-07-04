/*
 * 문제: 백준 17471번 - 게리맨더링 (https://www.acmicpc.net/problem/17471)
 * 문제 풀이
 *  백트래킹으로 만들 수 있는 선거구 조합을 찾고 BFS로 조합된 선거구의 구역들이 모두 연결되어 있는지 확인.
 *  두 선거구의 구역들이 모두 연결되어 있으면 두 선거구의 인구수 차를 구해서 최솟값인지 확인.
 *  백트래킹으로 선거구 조합을 찾을 때 깊이를 N까지 해서 모든 조합을 찾는 것이 아니라 N/2까지만 해도 모든 조합을 찾을 수 있음.
 *  예를 들어, {1, 2, 3, 4} 4개의 구역이 있을 때
 *  선거구 A = {1}, 선거구 B = {2, 3, 4}랑 선거구 A = {2, 3, 4}, 선거구 B = {1}이랑 인구수의 차는 같음.
 *
 * 시간 복잡도: O(2^n * n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_17471_게리맨더링 {
    // public class Main {
    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] population;
    static int diff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        population = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++)
            population[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int neighbor = Integer.parseInt(st.nextToken());

            while (neighbor-- > 0) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        dfs(1, 0, 0);
        bw.write(Integer.toString(diff == Integer.MAX_VALUE ? -1 : diff));
        br.close();
        bw.close();
    }

    static void dfs(int depth, int visited, int prev) {
        if (depth > n / 2)
            return;

        for (int i = prev + 1; i <= n; i++) {
            int visitedA = visited | (1 << i);
            int precinctA = bfs(i, visitedA);
            int visitedB = ((1 << (n + 1)) - 1) ^ (visitedA + 1);
            int precinctB = bfs(Integer.numberOfTrailingZeros(visitedB), visitedB);

            if (precinctA != 0 && precinctB != 0)
                diff = Math.min(diff, Math.abs(precinctA - precinctB));

            dfs(depth + 1, visitedA, i);
        }
    }

    static int bfs(int node, int group) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;

        queue.offer(node);
        group ^= 1 << node;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            sum += population[v];

            for (int neighbor : graph.get(v)) {
                int mask = 1 << neighbor;

                if ((group & mask) != 0) {
                    queue.offer(neighbor);
                    group ^= mask;
                }
            }
        }

        return group == 0 ? sum : 0;
    }
}
