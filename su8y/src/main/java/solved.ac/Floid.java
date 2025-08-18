package solved.ac;

public class Floid {
    public static int V = 4;
    public static int[][] adj = new int[V][V];
    int[][][] C = new int[V][V][V];

    public static void main(String[] args) {

    }

    void allPairShortestPath1() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j)
                    C[0][i][j] = Math.min(adj[i][j], adj[i][0] + adj[0][j]);
                else
                    C[0][i][j] = 0;
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    C[k][i][j] = Math.min(C[k - 1][i][j],
                            C[k - 1][i][k] + C[k - 1][k][j]);
                }
            }
        }
    }

}
