package solved.ac;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스_2606 {
    static int K, N, M, T;

    /**
     * 7
     * 6
     * 1 2
     * 2 3
     * 1 5
     * 5 2
     * 5 6
     * 4 7
     *
     * @return
     */
    private static int[] visited;
    private static List<List<Integer>> graph;

    private static int solve(int n) {
        int res = 0;
        visited[n] = 1;
        for (int i = 0; i < graph.get(n).size(); i++) {
            int there = graph.get(n).get(i);
            if (visited[there] == 1) continue;
            solve(there);
        }
        return res;
    }

    private static int countVisited() {
        int result = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1) result++;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        solve(1);
        System.out.println(countVisited() - 1); // 자기자신은 빼줌

        bw.close();
        br.close();
    }
}