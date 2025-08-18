/*
 * 문제: 백준 17779번 - 게리맨더링 2 (https://www.acmicpc.net/problem/17779)
 *
 * 시간 복잡도: O(N^6)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17779_게리맨더링2 {
    // public class Main {
    static int n;
    static int[][] city;
    static int diff = Integer.MAX_VALUE;
    static int total = 0;

    static int bfs(Pos s, Pos a, Pos b, boolean[][] visited) {
        int population = city[s.x][s.y];
        Queue<Pos> queue = new LinkedList<>();

        queue.offer(s);
        visited[s.x][s.y] = true;

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();

            for (Pos dir : new Pos[]{new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)}) {
                int nx = pos.x + dir.x;
                int ny = pos.y + dir.y;

                if (nx < a.x || nx > b.x || ny < a.y || ny > b.y || visited[nx][ny])
                    continue;

                population += city[nx][ny];
                queue.offer(new Pos(nx, ny));
                visited[nx][ny] = true;
            }
        }

        return population;
    }

    static void divide(int x, int y) {
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (x + i + j < n && y - i >= 0 && y + j < n) {
                    boolean[][] visited = new boolean[n][n];

                    for (int k = 0; k <= i; k++) {
                        visited[x + k][y - k] = true;
                        visited[x + j + k][y + j - k] = true;
                    }

                    for (int k = 1; k < j; k++) {
                        visited[x + k][y + k] = true;
                        visited[x + i + k][y - i + k] = true;
                    }

                    int a = bfs(new Pos(0, 0), new Pos(0, 0), new Pos(x + i - 1, y), visited);
                    int b = bfs(new Pos(0, n - 1), new Pos(0, y + 1), new Pos(x + j, n - 1), visited);
                    int c = bfs(new Pos(n - 1, 0), new Pos(x + i, 0), new Pos(n - 1, y - i + j - 1), visited);
                    int d = bfs(new Pos(n - 1, n - 1), new Pos(x + j + 1, y - i + j), new Pos(n - 1, n - 1), visited);
                    int e = total - a - b - c - d;
                    int max = Math.max(a, Math.max(Math.max(b, c), Math.max(d, e)));
                    int min = Math.min(a, Math.min(Math.min(b, c), Math.min(d, e)));

                    diff = Math.min(diff, max - min);
                }
            }
        }
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        city = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                total += city[i][j];
            }
        }

        for (int i = 0; i < n - 2; i++)
            for (int j = 1; j < n - 1; j++)
                divide(i, j);

        bw.write(Integer.toString(diff));
        br.close();
        bw.close();
    }
}
