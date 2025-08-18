/*
 * 문제 : 백준 10026번 - 적록색약 (https://www.acmicpc.net/problem/10026)
 * 문제 풀이
 *  큐 두 개를 만들어서 하나는 정삭적으로 BFS는 하고 나머지 하나는 현재 그룹과 다른 색(빨간색일 경우 녹색, 녹색일 경우 빨간색)을 넣어서 BFS를 함
 *  BFS를 돌면서 적록색약이 아닌 사람이 본 색 구역과 적록색약인 사람이 본 색 구역을 따로 체크 함
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] picture = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        Queue<Pos> q1 = new LinkedList<>();
        Queue<Pos> q2 = new LinkedList<>();
        int normal = 0;
        int colorBlind = 0;

        for (int i = 0; i < n; i++)
            picture[i] = br.readLine().toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j])
                    continue;

                q1.offer(new Pos(i, j));
                colorBlind++;

                while (!q1.isEmpty()) {
                    Pos p = q1.poll();

                    if (!visited[p.x][p.y]) {
                        q2.offer(p);
                        visited[p.x][p.y] = true;
                        normal++;
                    }

                    while (!q2.isEmpty()) {
                        Pos[] dir = {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};
                        Pos pos = q2.poll();

                        for (Pos d : dir) {
                            int nx = pos.x + d.x;
                            int ny = pos.y + d.y;

                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                                if (picture[pos.x][pos.y] == picture[nx][ny]) {
                                    q2.offer(new Pos(nx, ny));
                                    visited[nx][ny] = true;
                                } else if (picture[pos.x][pos.y] != 'B' && picture[nx][ny] != 'B') {
                                    q1.offer(new Pos(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
        }

        bw.write(normal + " " + colorBlind);
        br.close();
        bw.close();
    }

    public static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
