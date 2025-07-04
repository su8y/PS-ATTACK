/*
 * 문제: 백준 2150번 - Strongly Connected Component (https://www.acmicpc.net/problem/2150)
 * 문제 풀이
 *  타잔 알고리즘을 사용해서 SCC를 구함.
 *
 * 시간 복잡도: O(v + e + v log v)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2150_StronglyConnectedComponent {
    // public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[] parents;
    private static boolean[] visited;
    private static int id = 0;
    private static Stack<Integer> stack = new Stack<>();
    private static Set<TreeSet<Integer>> scc = new TreeSet<>(Comparator.comparingInt(TreeSet::first));

    private static int dfs(int n) {
        int parent = parents[n] = ++id;

        stack.push(n);

        for (int next : graph.get(n)) {
            if (!visited[next]) {
                parent = Math.min(parent, parents[next] == 0 ? dfs(next) : parents[next]);
            }
        }

        if (parent == parents[n]) {
            int node;
            TreeSet<Integer> set = new TreeSet<>();

            do {
                node = stack.pop();
                visited[node] = true;
                set.add(node);
            } while (node != n);

            scc.add(set);
        }

        return parent;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        parents = new int[v + 1];
        visited = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        sb.append(scc.size()).append("\n");

        for (Set<Integer> set : scc) {
            for (int n : set) {
                sb.append(n).append(" ");
            }

            sb.append(-1).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
