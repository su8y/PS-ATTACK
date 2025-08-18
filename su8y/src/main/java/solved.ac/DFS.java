package solved.ac;

public class DFS {
    boolean[] visited;
    int[][] graph;

    public void dfs(int x) {
        visited[x] = true;
        if (visited[x]) return;

        System.out.println(x + " 번 정점 방문 완료");
        for (int i : graph[x]) {
            dfs(i);
        }

        System.out.println(x + "번 정점아 잘 가..");

    }
}
