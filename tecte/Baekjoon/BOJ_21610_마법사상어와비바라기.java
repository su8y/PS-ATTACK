/*
 * 문제: 백준 21610번 - 마법사 상어와 비바라기 (https://www.acmicpc.net/problem/21610)
 *
 * 시간 복잡도: O(m * n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21610_마법사상어와비바라기 {
    // public class Main {
    private static class Pos {
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] buckets = new int[n + 1][n + 1];
        List<Pos> clouds = new ArrayList<>();
        Pos[] dir = {
                new Pos(0, 0), new Pos(0, -1), new Pos(-1, -1),
                new Pos(-1, 0), new Pos(-1, 1), new Pos(0, 1),
                new Pos(1, 1), new Pos(1, 0), new Pos(1, -1)
        };
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                buckets[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds.add(new Pos(n, 1));
        clouds.add(new Pos(n, 2));
        clouds.add(new Pos(n - 1, 1));
        clouds.add(new Pos(n - 1, 2));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            boolean[][] visited = new boolean[n + 1][n + 1];
            List<Pos> newClouds = new ArrayList<>();

            for (Pos cloud : clouds) {
                cloud.x = (cloud.x - 1 + (n << 6) + dir[d].x * s) % n + 1;
                cloud.y = (cloud.y - 1 + (n << 6) + dir[d].y * s) % n + 1;
                buckets[cloud.x][cloud.y]++;
                visited[cloud.x][cloud.y] = true;
            }

            for (Pos cloud : clouds) {
                int cnt = 0;

                for (int j = 2; j < 9; j += 2) {
                    int nx = cloud.x + dir[j].x;
                    int ny = cloud.y + dir[j].y;

                    if (nx < 1 || nx > n || ny < 1 || ny > n) {
                        continue;
                    }

                    if (buckets[nx][ny] > 0) {
                        cnt++;
                    }
                }

                buckets[cloud.x][cloud.y] += cnt;
            }

            for (int x = 1; x <= n; x++) {
                for (int y = 1; y <= n; y++) {
                    if (visited[x][y] || buckets[x][y] < 2) {
                        continue;
                    }

                    buckets[x][y] -= 2;
                    newClouds.add(new Pos(x, y));
                }
            }

            clouds = newClouds;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum += buckets[i][j];
            }
        }

        bw.write(Integer.toString(sum));
        br.close();
        bw.close();
    }
}
