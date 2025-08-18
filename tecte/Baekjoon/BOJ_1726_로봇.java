/*
 * 문제 : 백준 1726번 - 로봇 (https://www.acmicpc.net/problem/1726)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1726_로봇 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int[][] factory = new int[m][];
        boolean[][][] visited = new boolean[m][n][5];

        for (int i = 0; i < m; i++)
            factory[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        input = br.readLine().split(" ");
        int sx = Integer.parseInt(input[0]) - 1;
        int sy = Integer.parseInt(input[1]) - 1;
        int sd = Integer.parseInt(input[2]);
        input = br.readLine().split(" ");
        int ex = Integer.parseInt(input[0]) - 1;
        int ey = Integer.parseInt(input[1]) - 1;
        int ed = Integer.parseInt(input[2]);
        Queue<Pos> queue = new LinkedList<>();

        queue.offer(new Pos(sx, sy, sd, 0));
        visited[sx][sy][sd] = true;

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            int[][] cmd = new int[5][3];

            if (pos.x == ex && pos.y == ey && pos.d == ed) {
                bw.write(Integer.toString(pos.cmd));
                break;
            }

            switch (pos.d) {
                case 1:
                    cmd = new int[][]{{0, 0, 3}, {0, 0, 4}, {0, 1, pos.d}, {0, 2, pos.d}, {0, 3, pos.d}};
                    break;
                case 2:
                    cmd = new int[][]{{0, 0, 3}, {0, 0, 4}, {0, -1, pos.d}, {0, -2, pos.d}, {0, -3, pos.d}};
                    break;
                case 3:
                    cmd = new int[][]{{0, 0, 1}, {0, 0, 2}, {1, 0, pos.d}, {2, 0, pos.d}, {3, 0, pos.d}};
                    break;
                case 4:
                    cmd = new int[][]{{0, 0, 1}, {0, 0, 2}, {-1, 0, pos.d}, {-2, 0, pos.d}, {-3, 0, pos.d}};
                    break;
            }

            for (int[] c : cmd) {
                int nx = pos.x + c[0];
                int ny = pos.y + c[1];
                int nd = c[2];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || factory[nx][ny] == 1)
                    break;
                else if (visited[nx][ny][nd])
                    continue;

                queue.offer(new Pos(nx, ny, nd, pos.cmd + 1));
                visited[nx][ny][nd] = true;
            }
        }

        br.close();
        bw.close();
    }

    static class Pos {
        int x, y, d, cmd;

        public Pos(int x, int y, int d, int cmd) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cmd = cmd;
        }
    }
}
