/*
 * 문제 : 백준 1238번 - 파티 (https://www.acmicpc.net/problem/1238)
 * 문제 풀이
 *  다익스트라로 모든 마을의 수만큼 반복해서 모든 마을에서 X로 가는 최단거리와 X에서 모든 마을로 가는 최단거리를 구함.
 *
 * 시간 복잡도: O(n^2 log n)
 */

package Baekjoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_파티_1 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n + 1][n + 1];
        int[][] dist = new int[n + 1][n + 1];
        int time = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sv = Integer.parseInt(st.nextToken());
            int ev = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[sv][ev] = t;
        }

        for (int i = 1; i <= n; i++) {
            int finalI = i;
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> dist[finalI][a]));

            queue.offer(i);

            while (!queue.isEmpty()) {
                int v = queue.poll();

                for (int j = 1; j <= n; j++) {
                    if (i == j || graph[v][j] == 0)
                        continue;

                    if (dist[i][j] == 0 || dist[i][j] > dist[i][v] + graph[v][j]) {
                        dist[i][j] = dist[i][v] + graph[v][j];
                        queue.offer(j);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++)
            time = Math.max(time, dist[i][x] + dist[x][i]);

        bw.write(time + "");
        br.close();
        bw.close();
    }
}
