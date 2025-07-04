/*
 * 문제: 백준 14940번 - 쉬운 최단거리 (https://www.acmicpc.net/problem/14940)
 * 문제 풀이
 *  목표지점부터 BFS를 하며 이동하지 않은 곳만 큐에 삽입
 *  출력을 할때 0인 지점은 원래 갈 수 없는 땅이거나 도달할 수 없는 따이기 때문에 0이나 -1 출력
 *
 * 시간 복잡도: O(n * m)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940_쉬운최단거리 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] field = new int[n + 2][m + 2];
        boolean[][] map = new boolean[n + 2][m + 2];
        Queue<int[]> queue = new LinkedList<>();
        int x, y;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= m; j++) {
                String p = st.nextToken();

                if (p.equals("1")) {
                    map[i][j] = true;
                } else if (p.equals("2")) {
                    x = i;
                    y = j;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int[] pos = queue.poll();

            for (int[] d : dir) {
                int nx = pos[0] + d[0];
                int ny = pos[1] + d[1];

                if (field[nx][ny] == 0 && map[nx][ny]) {
                    field[nx][ny] = field[pos[0]][pos[1]] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (field[i][j] == 0 && map[i][j])
                    bw.write("-1 ");
                else
                    bw.write(field[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
