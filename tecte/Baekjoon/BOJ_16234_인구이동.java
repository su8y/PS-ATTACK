/*
 * 문제: 백준 16234번 - 인구 이동 (https://www.acmicpc.net/problem/16234)
 *
 * 시간 복잡도: O(n^4)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {
    // public class Main {
    static int n;
    static int l;
    static int r;
    static int[][][] countries;
    static Pos[] dir = {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};

    static int bfs(int x, int y, int[][][] newCountries, boolean[][] visited) {
        Queue<Pos> queue = new LinkedList<>();
        int population = 0;
        int cnt = 0;

        queue.offer(new Pos(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();

            cnt++;
            population += countries[pos.x][pos.y][0];
            newCountries[pos.x][pos.y] = newCountries[x][y];

            for (Pos d : dir) {
                int nx = pos.x + d.x;
                int ny = pos.y + d.y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])
                    continue;

                int diff = Math.abs(countries[pos.x][pos.y][0] - countries[nx][ny][0]);

                if (diff >= l && diff <= r) {
                    queue.offer(new Pos(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return population / cnt;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        countries = new int[n][n][1];
        int day = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++)
                countries[i][j] = new int[]{Integer.parseInt(st.nextToken())};
        }

        while (true) {
            int[][][] newCountries = new int[n][n][1];
            boolean[][] visited = new boolean[n][n];
            boolean hasMoved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        hasMoved = true;
                        continue;
                    }

                    newCountries[i][j][0] = bfs(i, j, newCountries, visited);
                }
            }

            if (!hasMoved)
                break;

            countries = newCountries;
            day++;
        }

        bw.write(Integer.toString(day));
        br.close();
        bw.close();
    }
}
