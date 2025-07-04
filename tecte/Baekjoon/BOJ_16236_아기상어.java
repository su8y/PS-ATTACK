/*
 * 문제 : 백준 16236번 - 아기 상어 (https://www.acmicpc.net/problem/16236)
 *
 * 시간 복잡도: O(n^4)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] field = new int[n][n];
        int size = 2;
        Pos shark = new Pos(0, 0, 0);
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int fish = Integer.parseInt(st.nextToken());

                if (fish == 9) {
                    fish = -size;
                    shark = new Pos(i, j, 0);
                }

                field[i][j] = fish;
            }
        }

        while (true) {
            Pos edibleFish = new Pos(n, n, Integer.MAX_VALUE);
            Queue<Pos> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];

            queue.offer(shark);
            visited[shark.x][shark.y] = true;

            while (!queue.isEmpty()) {
                Pos pos = queue.poll();

                if (pos.dist > edibleFish.dist)
                    break;

                if (size > field[pos.x][pos.y] && field[pos.x][pos.y] > 0)
                    if (pos.x < edibleFish.x || (pos.x == edibleFish.x && pos.y < edibleFish.y))
                        edibleFish = pos;

                for (int[] d : dir) {
                    int nx = pos.x + d[0];
                    int ny = pos.y + d[1];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && field[nx][ny] <= size) {
                        queue.offer(new Pos(nx, ny, pos.dist + 1));
                        visited[nx][ny] = true;
                    }
                }
            }

            if (edibleFish.x == n)
                break;

            if (++field[shark.x][shark.y] == 0) {
                field[edibleFish.x][edibleFish.y] = -(++size);
            } else {
                field[edibleFish.x][edibleFish.y] = field[shark.x][shark.y];
                field[shark.x][shark.y] = 0;
            }

            shark = edibleFish;
        }

        bw.write(Integer.toString(shark.dist));
        br.close();
        bw.close();
    }

    static class Pos {
        int x, y, dist;

        public Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
