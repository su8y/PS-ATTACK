/*
 * 문제: 백준 17837번 - 새로운 게임 2 (https://www.acmicpc.net/problem/17837)
 *
 * 시간 복잡도: O(k^2)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17837_새로운게임2 {
    // public class Main {
    private static int n, k;
    private static Cell[][] board;
    private static Piece[] pieces;

    private static int play() {
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        for (int t = 1; t <= 1000; t++) {
            for (int i = 0; i < k; i++) {
                int nx = pieces[i].x + dir[pieces[i].d][0];
                int ny = pieces[i].y + dir[pieces[i].d][1];
                List<Integer> list = board[pieces[i].x][pieces[i].y].list;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny].color == 2) {
                    pieces[i].d ^= 1;
                    nx = pieces[i].x + dir[pieces[i].d][0];
                    ny = pieces[i].y + dir[pieces[i].d][1];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny].color == 2) {
                        continue;
                    }
                }

                if (board[nx][ny].color == 1) {
                    while (!list.isEmpty()) {
                        int idx = list.size() - 1;
                        int pc = list.get(idx);

                        board[nx][ny].list.add(pc);
                        pieces[pc].x = nx;
                        pieces[pc].y = ny;
                        list.remove(idx);

                        if (pc == i) {
                            break;
                        }
                    }
                } else {
                    List<Integer> newList = new ArrayList<>();
                    int j = 0;

                    for (; j < list.size(); j++) {
                        if (list.get(j) == i) {
                            break;
                        }

                        newList.add(list.get(j));
                    }

                    board[pieces[i].x][pieces[i].y].list = newList;

                    for (; j < list.size(); j++) {
                        board[nx][ny].list.add(list.get(j));
                        pieces[list.get(j)].x = nx;
                        pieces[list.get(j)].y = ny;
                    }
                }

                if (board[nx][ny].list.size() >= 4) {
                    return t;
                }
            }
        }

        return -1;
    }

    private static class Cell {
        int color;
        List<Integer> list = new ArrayList<>();

        public Cell(int color) {
            this.color = color;
        }
    }

    private static class Piece {
        int x, y, d;

        public Piece(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new Cell[n][n];
        pieces = new Piece[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = new Cell(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            pieces[i] = new Piece(x, y, d);
            board[x][y].list.add(i);
        }

        bw.write(Integer.toString(play()));
        br.close();
        bw.close();
    }
}
