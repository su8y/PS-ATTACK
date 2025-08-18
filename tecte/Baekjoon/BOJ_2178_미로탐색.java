/*
 * 문제 : 백준 2178번 - 미로 탐색 (https://www.acmicpc.net/problem/2178)
 * 문제 풀이
 *  BFS로 도착지점까지의 최소 칸 수를 구함
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178_미로탐색 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        boolean[][] maze = new boolean[n][];
        Queue<Cell> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char[] m = br.readLine().toCharArray();
            maze[i] = new boolean[m.length];

            for (int j = 0; j < m.length; j++)
                if (m[j] == '1')
                    maze[i][j] = true;
        }

        queue.offer(new Cell(0, 0, 1));
        maze[0][0] = false;

        while (!queue.isEmpty()) {
            Cell[] dir = {new Cell(-1, 0), new Cell(0, 1), new Cell(1, 0), new Cell(0, -1)};
            Cell cell = queue.poll();

            if (cell.x == n - 1 && cell.y == maze[0].length - 1) {
                bw.write(cell.cnt + "");
                break;
            }

            for (Cell d : dir) {
                int nx = cell.x + d.x;
                int ny = cell.y + d.y;

                if (nx >= 0 && nx < n && ny >= 0 && ny < maze[0].length && maze[nx][ny]) {
                    queue.offer(new Cell(nx, ny, cell.cnt + 1));
                    maze[nx][ny] = false;
                }
            }
        }

        br.close();
        bw.close();
    }

    public static class Cell {
        int x, y, cnt;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Cell(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
