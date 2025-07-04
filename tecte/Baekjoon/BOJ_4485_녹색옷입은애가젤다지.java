/*
 * 문제: 백준 4485번 - 녹색 옷 입은 애가 젤다지? (https://www.acmicpc.net/problem/4485)
 *
 * 시간 복잡도: O(n^2 log n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_4485_녹색옷입은애가젤다지 {
    // public class Main {
    static class Edge {
        int x, y, w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int t = 1, n; (n = Integer.parseInt(br.readLine())) != 0; t++) {
            int[][] cave = new int[n][];
            int[][] dist = new int[n][n];
            PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));

            for (int i = 0; i < n; i++) {
                cave[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            dist[0][0] = cave[0][0];
            queue.offer(new Edge(0, 0, cave[0][0]));

            while (!queue.isEmpty()) {
                Edge edge = queue.poll();

                if (edge.w > dist[edge.x][edge.y])
                    continue;

                for (int[] d : dir) {
                    int nx = edge.x + d[0];
                    int ny = edge.y + d[1];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        int newDist = edge.w + cave[nx][ny];

                        if (dist[nx][ny] > newDist) {
                            dist[nx][ny] = newDist;
                            queue.offer(new Edge(nx, ny, newDist));
                        }
                    }
                }
            }

            sb.append("Problem ").append(t).append(": ").append(dist[n - 1][n - 1]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
