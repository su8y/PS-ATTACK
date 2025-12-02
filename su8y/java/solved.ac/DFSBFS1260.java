package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSBFS1260 {
    private static int[] visited;
    private static int n, e, startVertax;
    private static List<List<Integer>> graph;

    private static StringBuilder sb;

    public static void putEdge(List<List<Integer>> graph, int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    public static void main(String[] args) throws IOException {
        graph = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        startVertax = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            putEdge(graph, x, y);
        }
        for (var i : graph) {
            Collections.sort(i);
        }

        dfsAll(startVertax);
        // initialization visited[] 0 to visited.length
        Arrays.fill(visited, 0, visited.length, 0);
        bfs(startVertax);
    }

    private static void bfs(int startVertax) {
        sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        // 1. queue 에 시작점 집어넣기 .
        queue.offer(startVertax);
        visited[queue.peek()] = 1;

        while (!queue.isEmpty()) {
            int here = queue.poll();
            sb.append(here + " ");
            // 2. 인근 정점 큐에 넣기
            for (int i = 0; i < graph.get(here).size(); i++) {
                int there = graph.get(here).get(i);
                // 3. 방문처리된 정점인지 확인후 방문
                if (visited[there] == 0) {
                    visited[there] = 1;
                    queue.offer(there);
                }
            }
        }
        System.out.println(sb.toString().trim());

    }

    private static void dfsAll(int startVertax) {
        sb = new StringBuilder();
        dfs(startVertax);
        System.out.println(sb.toString().trim());
    }

    private static void dfs(int startVertax) {
        visited[startVertax] = 1;
        sb.append(startVertax + " ");
//        System.out.println("Visited! : " + startVertax);
        for (int i = 0; i < graph.get(startVertax).size(); i++) {
            int there = graph.get(startVertax).get(i);
            if (visited[there] == 0) {
                dfs(there);
            }
        }
    }
}
