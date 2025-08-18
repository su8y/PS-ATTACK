/*
 * 문제: 백준 2239번 - 스도쿠 (https://www.acmicpc.net/problem/2239)
 * 문제 풀이
 *  백트래킹을 사용하여 빈칸의 숫자를 채움.
 *
 * 시간 복잡도: O(9^n) - n: 빈칸의 개수
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2239_스도쿠 {
    // public class Main {
    private static int[][] board = new int[9][9];
    private static List<Pos> list = new ArrayList<>();

    private static boolean dfs(int idx) {
        if (idx == list.size()) {
            return true;
        }

        int x, y;
        int used = 0;
        Pos[] dir = {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};

        for (Pos d : dir) {
            x = list.get(idx).x;
            y = list.get(idx).y;

            while (true) {
                x += d.x;
                y += d.y;

                if (x < 0 || x > 8 || y < 0 || y > 8) {
                    break;
                }

                used |= 1 << board[x][y];
            }
        }

        x = list.get(idx).x / 3 * 3;
        y = list.get(idx).y / 3 * 3;

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                used |= 1 << board[i][j];
            }
        }

        x = list.get(idx).x;
        y = list.get(idx).y;

        for (int i = 1; i < 10; i++) {
            if ((used & (1 << i)) != 0) {
                continue;
            }

            board[x][y] = i;

            if (dfs(idx + 1)) {
                return true;
            }

            board[x][y] = 0;
        }

        return false;
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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            char[] row = br.readLine().toCharArray();

            for (int j = 0; j < 9; j++) {
                board[i][j] = row[j] - '0';

                if (board[i][j] == 0) {
                    list.add(new Pos(i, j));
                }
            }
        }

        dfs(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
