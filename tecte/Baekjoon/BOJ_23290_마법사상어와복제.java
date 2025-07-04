/*
 * 문제 : 백준 23290번 - 마법사 상어와 복제 (https://www.acmicpc.net/problem/23290)
 *
 * 시간 복잡도: O(s)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_23290_마법사상어와복제 {
    // public class Main {
    static Cell[][] sea = new Cell[5][5];

    public static Cell[] sharkMove(int x, int y, int m) {
        Cell[] move = new Cell[3];

        if (m >= 0 && m < 3) {
            int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
            int sum = -1;

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx > 0 && nx < 5 && ny > 0 && ny < 5) {
                    Cell[] newMove;
                    int temp = sea[nx][ny].cnt;
                    int newSum = temp;

                    sea[nx][ny].cnt = 0;
                    newMove = sharkMove(nx, ny, m + 1);
                    newMove[m] = sea[nx][ny];

                    for (int j = m + 1; j < newMove.length; j++)
                        newSum += sea[newMove[j].x][newMove[j].y].cnt;

                    if (sum < newSum) {
                        sum = newSum;
                        move = newMove;
                    }

                    sea[nx][ny].cnt = temp;
                }
            }
        }

        return move;
    }

    public static class Cell {
        int x, y;
        boolean shark = false;
        int smell = 0;
        int cnt = 0;
        int[] dir = new int[9];

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Cell(int x, int y, boolean shark, int smell, int cnt, int[] dir) {
            this.x = x;
            this.y = y;
            this.shark = shark;
            this.smell = smell;
            this.cnt = cnt;
            this.dir = dir;
        }

        public void remove(int s) {
            this.smell = s;
            this.cnt = 0;
            this.dir = new int[9];
        }

        public Cell copy() {
            return new Cell(x, y, shark, smell, cnt, dir.clone());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 5; i++)
            for (int j = 1; j < 5; j++)
                sea[i][j] = new Cell(i, j);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            sea[x][y].cnt++;
            sea[x][y].dir[d]++;
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        sea[x][y].shark = true;

        for (int i = 1; i <= s; i++) {
            ArrayList<Cell> copy = new ArrayList<>();
            int[][] dir = {{}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

            for (int j = 1; j < 5; j++)
                for (int k = 1; k < 5; k++)
                    if (sea[j][k].cnt > 0)
                        copy.add(sea[j][k].copy());

            for (Cell fish : copy) {
                for (int j = 1; j < 9; j++) {
                    if (fish.dir[j] == 0)
                        continue;

                    for (int k = 8; k > 0; k--) {
                        int nd = (j + k - 1) % 8 + 1;
                        int nx = fish.x + dir[nd][0];
                        int ny = fish.y + dir[nd][1];

                        if (nx > 0 && nx < 5 && ny > 0 && ny < 5 && !sea[nx][ny].shark && sea[nx][ny].smell <= i) {
                            sea[fish.x][fish.y].cnt -= fish.dir[j];
                            sea[fish.x][fish.y].dir[j] -= fish.dir[j];
                            sea[nx][ny].cnt += fish.dir[j];
                            sea[nx][ny].dir[nd] += fish.dir[j];
                            break;
                        }
                    }
                }
            }

            Cell[] move = sharkMove(x, y, 0);

            for (int j = 0; j < move.length; j++) {
                if (sea[move[j].x][move[j].y].cnt > 0) {
                    sea[move[j].x][move[j].y].remove(i + 3);
                }

                if (j == move.length - 1) {
                    sea[x][y].shark = false;
                    x = move[j].x;
                    y = move[j].y;
                    sea[x][y].shark = true;
                }
            }

            for (Cell c : copy) {
                sea[c.x][c.y].cnt += c.cnt;

                for (int j = 1; j < 9; j++)
                    sea[c.x][c.y].dir[j] += c.dir[j];
            }
        }

        int cnt = 0;

        for (int i = 1; i < 5; i++)
            for (int j = 1; j < 5; j++)
                cnt += sea[i][j].cnt;

        bw.write(cnt + "");
        br.close();
        bw.close();
    }
}
