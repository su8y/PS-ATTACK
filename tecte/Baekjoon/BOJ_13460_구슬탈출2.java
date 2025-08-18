/*
 * 문제: 백준 13460번 - 구슬 탈출 2 (https://www.acmicpc.net/problem/13460)
 * 문제 풀이
 *  BFS로 최소 이동 횟수를 구함.
 *  두 구슬의 위치를 독립적으로 관리하여, 구슬을 이동했을 때 두 구슬의 위치가 같다면 이동하기 전의 위치를 고려하여 위치 조정.
 *
 * 시간 복잡도: O(n^2 * m^2)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460_구슬탈출2 {
    // public class Main {
    private static char[][] board;
    private static Queue<Marble> queue = new LinkedList<>();
    private static Pos[] dir = {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};

    private static void move(Pos p, int d) {
        while (board[p.x][p.y] != 'O') {
            int nx = p.x + dir[d].x;
            int ny = p.y + dir[d].y;

            if (board[nx][ny] == '#')
                return;

            p.x = nx;
            p.y = ny;
        }
    }

    private static String play() {
        while (!queue.isEmpty()) {
            Marble marble = queue.poll();

            if (marble.cnt >= 10)
                return "-1";

            for (int j = 0; j < 4; j++) {
                Pos red = new Pos(marble.red.x, marble.red.y);
                Pos blue = new Pos(marble.blue.x, marble.blue.y);

                move(blue, j);
                move(red, j);

                if (board[blue.x][blue.y] == 'O')
                    continue;
                else if (board[red.x][red.y] == 'O')
                    return Integer.toString(marble.cnt + 1);

                if (red.x == blue.x && red.y == blue.y) {
                    if (j == 0) {
                        if (marble.red.x < marble.blue.x)
                            blue.x -= dir[0].x;
                        else
                            red.x -= dir[0].x;
                    } else if (j == 1) {
                        if (marble.red.y < marble.blue.y)
                            red.y -= dir[1].y;
                        else
                            blue.y -= dir[1].y;
                    } else if (j == 2) {
                        if (marble.red.x < marble.blue.x)
                            red.x -= dir[2].x;
                        else
                            blue.x -= dir[2].x;
                    } else {
                        if (marble.red.y < marble.blue.y)
                            blue.y -= dir[3].y;
                        else
                            red.y -= dir[3].y;
                    }
                }

                queue.offer(new Marble(red, blue, marble.cnt + 1));
            }
        }

        return "-1";
    }

    private static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Marble {
        Pos red, blue;
        int cnt = 0;

        public Marble() {
            super();
        }

        public Marble(Pos red, Pos blue, int cnt) {
            this.red = red;
            this.blue = blue;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        Marble marble = new Marble();

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'R')
                    marble.red = new Pos(i, j);
                else if (board[i][j] == 'B')
                    marble.blue = new Pos(i, j);
            }
        }

        queue.offer(marble);
        bw.write(play());
        br.close();
        bw.close();
    }
}
