/*
 * 문제 : 백준 1238번 - 파티 (https://www.acmicpc.net/problem/1238)
 * 문제 풀이
 *  다익스트라로 모든 마을의 수만큼 반복하는 것이 아니라 다른 마을에서 X로 가는 간선들을 역방향으로 바꿔서 다익스트라를 한 번만 함.
 *  역방향으로 바꾼 간선들로 X에서 모든 마을로 이동하는 최단경로를 구한 것과 정방향으로 모든 마을에서 X로 가는 최단경로와 같음.
 *  이 방식으로 하면 다익스트라 두 번으로 모든 마을에서 X로 가는 최단경로와 X에서 모든 마을로 가는 최단경로를 구할 수 있음.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_파티_2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n + 1][n + 1];
        int[][] dist = new int[2][n + 1];
        int time = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sv = Integer.parseInt(st.nextToken());
            int ev = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[sv][ev] = t;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> dist[0][a]));
        queue.offer(x);

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (i == x || graph[i][v] == 0)
                    continue;

                if (dist[0][i] == 0 || dist[0][i] > dist[0][v] + graph[i][v]) {
                    dist[0][i] = dist[0][v] + graph[i][v];
                    queue.offer(i);
                }
            }
        }

        queue = new PriorityQueue<>(Comparator.comparingInt(a -> dist[1][a]));
        queue.offer(x);

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (i == x || graph[v][i] == 0)
                    continue;

                if (dist[1][i] == 0 || dist[1][i] > dist[1][v] + graph[v][i]) {
                    dist[1][i] = dist[1][v] + graph[v][i];
                    queue.offer(i);
                }
            }
        }

        for (int i = 1; i <= n; i++)
            time = Math.max(time, dist[0][i] + dist[1][i]);

        bw.write(time + "");
        br.close();
        bw.close();
    }
}
