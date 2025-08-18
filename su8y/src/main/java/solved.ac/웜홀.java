package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 웜홀 {
    static int TC;
    static int N, M, W;
    static List<Road>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            adj = new List[N + 1];
            M = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= N; j++) {
                adj[j] = new ArrayList<>();
            }
            W = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                adj[s].add(new Road(e, t));
                adj[e].add(new Road(s, t));
            }
            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                adj[s].add(new Road(e, -t));
            }
            boolean b = false;
            b = belmanford(1);
            System.out.println(!b ? "YES" : "NO");
        }


    }

    private static boolean belmanford(int src) {
        int[] upper = new int[N + 1];
        Arrays.fill(upper, 9999999);
        upper[src] = 0;
        boolean update = false;

        for (int iter = 1; iter <= N; ++iter) {
            update = false;
            for (int here = 0; here <= N; ++here) {
                for (Road edge : adj[here]) {
                    int there = edge.e;
                    int cost = edge.t;

                    if (upper[there] > upper[here] + cost) {
                        upper[there] = upper[here] + cost;
                        update = true;
                    }
                }
            }
            if (!update) break; // 모든 간선을 확인했는데 완화가 안됐음
        }
        return !update;

    }

    static class Road {
        int e;
        int t;

        public Road(int e, int t) {
            this.e = e;
            this.t = t;
        }

    }
}