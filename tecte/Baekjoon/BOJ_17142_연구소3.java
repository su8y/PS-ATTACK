/*
 * 문제: 백준 17142번 - 연구소 3 (https://www.acmicpc.net/problem/17142)
 *
 * 시간 복잡도: O(2^v * n^2) - v: 연구소의 바이러스 개수
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_17142_연구소3 {
    // public class Main {
    private static int n, m, empty;
    private static int[][] lab;
    private static final List<Virus> viruses = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;

    private static void bfs(int active) {
        Queue<Virus> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        Virus virus = null;
        int emp = empty;

        for (int i = 0; i < viruses.size(); i++) {
            if ((active & (1 << i)) != 0) {
                virus = viruses.get(i);
                queue.offer(virus);
                visited[virus.x][virus.y] = true;
            }
        }

        while (!queue.isEmpty()) {
            virus = queue.poll();

            if (lab[virus.x][virus.y] == 0) {
                emp--;
            }

            if (emp == 0)
                break;

            for (int[] d : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                int nx = virus.x + d[0];
                int ny = virus.y + d[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                } else if (lab[nx][ny] != 1) {
                    queue.offer(new Virus(nx, ny, virus.sec + 1));
                }

                visited[nx][ny] = true;
            }
        }

        if (emp == 0 && virus != null) {
            min = Math.min(min, virus.sec);
        }
    }

    private static void dfs(int depth, int prev, int active) {
        if (depth == m) {
            bfs(active);

            return;
        }

        for (int i = prev + 1; i < viruses.size(); i++) {
            int v = 1 << i;

            if ((active & v) != 0) {
                break;
            }

            dfs(depth + 1, i, active | v);
        }
    }

    private static class Virus {
        int x, y, sec;

        public Virus(int x, int y, int sec) {
            this.x = x;
            this.y = y;
            this.sec = sec;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab = new int[n][n];
        empty = n * n;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if (lab[i][j] == 0) {
                    continue;
                } else if (lab[i][j] == 2) {
                    viruses.add(new Virus(i, j, 0));
                }

                empty--;
            }
        }

        dfs(0, -1, 0);
        bw.write(min == Integer.MAX_VALUE ? "-1" : Integer.toString(min));
        br.close();
        bw.close();
    }
}
