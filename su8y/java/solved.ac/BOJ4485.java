package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485 {
    private static class Pair<First, Second> {
        public First first;
        public Second second;

        public Pair(First first, Second second) {
            this.first = first;
            this.second = second;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] adj;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int i = 1;

        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            adj = new int[n][n];
            dist = new int[n][n];
            for (int k = 0; k < n; k++) {
                Arrays.fill(dist[k], Integer.MAX_VALUE);
            }

            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < n; x++) {
                    adj[y][x] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.printf("Problem %d: %d\n", i++, dij(adj));
            n = Integer.parseInt(br.readLine());
        }

    }

    public static int dij(int[][] adj) {
        int result = Integer.MAX_VALUE;
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> q = new PriorityQueue<>();
        q.offer(new Pair(adj[0][0], new Pair(0, 0))); // adj[0][0]이 시작점 , xy 좌표 q 에 넣기
        dist[0][0] = adj[0][0];

        while (!q.isEmpty()) {
            int hereX = q.peek().second.first;
            int hereY = q.peek().second.second;
            int cost = q.peek().first;
            q.poll();

            if (dist[hereY][hereX] != cost) continue;

            for (int i = 0; i < 4; i++) {
                int thereX = hereX + dx[i];
                int thereY = hereY + dy[i];
                if ((0 <= thereX && thereX < adj.length) && (0 <= thereY && thereY < adj.length)) {
                    int thereCost = adj[thereY][thereX];
                    if (dist[thereY][thereX] > cost + thereCost) {
                        dist[thereY][thereX] = cost + thereCost;
                        q.offer(new Pair(cost + thereCost, new Pair(thereX, thereY)));
                    }

                }
            }
        }

        return dist[adj.length - 1][adj.length - 1];
    }
}
