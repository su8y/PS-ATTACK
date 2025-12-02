package solved.ac;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }

        }
        return answer;
    }

    public void dfs(int n, int[][] computers, boolean[] visited) {
        visited[n] = true;
        for (int i = 0; i < computers[n].length; i++) {
            if (!visited[i] && computers[n][i] == 1) {
                dfs(i, computers, visited);
            }

        }
    }

}
