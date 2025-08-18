/*
 * 문제: 백준 23288번 - 주사위 굴리기 2 (https://www.acmicpc.net/problem/23288)
 *
 * 시간 복잡도: O(k * n * m)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23288_주사위굴리기2 {
    // public class Main {
    private static int n, m;
    private static int[][] board;
    private static Dice dice = new Dice(1, 1, 1, 1, 6, 2, 5, 4, 3);
    private static Pos[] dir = {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};
    private static int score = 0;

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new LinkedList<>();
        int[] visited = new int[n + 1];

        queue.offer(pos);
        visited[pos.x] |= 1 << pos.y;

        while (!queue.isEmpty()) {
            pos = queue.poll();
            score += board[pos.x][pos.y];

            for (Pos d : dir) {
                int nx = pos.x + d.x;
                int ny = pos.y + d.y;

                if (nx < 1 || nx > n || ny < 1 || ny > m || board[nx][ny] != board[pos.x][pos.y] || (visited[nx] & (1 << ny)) != 0) {
                    continue;
                }

                queue.offer(new Pos(nx, ny));
                visited[nx] |= 1 << ny;
            }
        }
    }

    private static class Dice {
        int x, y, d;
        int front, back, top, bottom, left, right;

        public Dice(int x, int y, int d, int front, int back, int top, int bottom, int left, int right) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.front = front;
            this.back = back;
            this.top = top;
            this.bottom = bottom;
            this.left = left;
            this.right = right;
        }

        void move() {
            int temp = front;

            switch (d) {
                case 0:
                    front = bottom;
                    bottom = back;
                    back = top;
                    top = temp;
                    break;
                case 1:
                    front = left;
                    left = back;
                    back = right;
                    right = temp;
                    break;
                case 2:
                    front = top;
                    top = back;
                    back = bottom;
                    bottom = temp;
                    break;
                case 3:
                    front = right;
                    right = back;
                    back = left;
                    left = temp;
                    break;
            }
        }
    }

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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (k-- > 0) {
            int nx = dice.x + dir[dice.d].x;
            int ny = dice.y + dir[dice.d].y;

            if (nx < 1 || nx > n || ny < 1 || ny > m) {
                dice.d = (dice.d + 2) % 4;
                nx = dice.x + dir[dice.d].x;
                ny = dice.y + dir[dice.d].y;
            }

            dice.x = nx;
            dice.y = ny;
            dice.move();
            bfs(new Pos(nx, ny));

            if (dice.back > board[nx][ny]) {
                dice.d = (dice.d + 1) % 4;
            } else if (dice.back < board[nx][ny]) {
                dice.d = (dice.d + 3) % 4;
            }
        }

        bw.write(Integer.toString(score));
        br.close();
        bw.close();
    }
}
