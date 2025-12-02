package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1504 {
    final static int INF = 200000000;
    static long[][] minWeight;
    private static int V;
    private static int E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());


        // 정점 개수
        V = Integer.parseInt(st.nextToken());
        // 간선 개수
        E = Integer.parseInt(st.nextToken());
        minWeight = new long[V + 1][V + 1];
        for (int i = 0; i <= V; i++) {
            Arrays.fill(minWeight[i], INF);
            minWeight[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            minWeight[start][end] = cost;
            minWeight[end][start] = cost;
        }
        st = new StringTokenizer(br.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        for (int k = 0; k <= V; k++) {
            for (int i = 0; i <= V; i++) {
                for (int j = 0; j <= V; j++) {
                    if (minWeight[i][j] > minWeight[i][k] + minWeight[k][j]) {
                        minWeight[i][j] = minWeight[i][k] + minWeight[k][j];
                    }
                }
            }
        }

        long min = Math.min(
                minWeight[1][c1] + minWeight[c1][c2] + minWeight[c2][V],
                minWeight[1][c2] + minWeight[c2][c1] + minWeight[c1][V]
        );

        boolean answer = false;
        if (minWeight[1][c1] == INF || minWeight[c1][c2] == INF || minWeight[c2][V] == INF) {
            answer = false;
        }
        if (!answer) System.out.println(min);
        else System.out.println(-1);

    }


}
