package solved.ac;

import java.util.Arrays;

public class Floyd {
    public static int V = 4;
    public static int[][] adj = new int[V][V];

    static void floyd() {
        // 자기자신은 0이다.
        for (int i = 0; i < V; i++) adj[i][i] = 0;

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        adj = new int[][]{
                {0, 2, 3, 4},
                {1, 0, 3, 4},
                {1, 2, 0, 4},
                {1, 2, 3, 0}
        };
        floyd();
        Arrays.stream(adj).forEach(e -> {
            Arrays.stream(e).forEach(i -> System.out.println(i + " "));
        });

    }
}
