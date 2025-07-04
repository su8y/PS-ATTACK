/*
 * 문제 : 백준 21609번 - 상어 중학교 (https://www.acmicpc.net/problem/21609)
 *
 * 시간 복잡도: O(n^6)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21609_상어중학교 {
    // public class Main {
    public static void gravity(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = field.length - 2; j >= 0; j--) {
                if (field[j][i] >= 0) {
                    for (int k = j; k < field.length - 1; k++) {
                        if (field[k + 1][i] == -2) {
                            field[k + 1][i] = field[k][i];
                            field[k][i] = -2;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public static class Cell {
        int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Group {
        ArrayList<Cell> cells;
        int color;
        int size;
        int rainbowBlock;
        int row;
        int col;

        public Group(ArrayList<Cell> cells, int color, int size, int rainbowBlock, int row, int col) {
            this.cells = cells;
            this.color = color;
            this.size = size;
            this.rainbowBlock = rainbowBlock;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] field = new int[n][n];
        int score = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++)
                field[i][j] = Integer.parseInt(st.nextToken());
        }


        while (true) {
            Group group = new Group(new ArrayList<>(), 0, 0, 0, 0, 0);
            int[][] visited = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 0 && field[i][j] > 0) {
                        ArrayList<Cell> cells = new ArrayList<>();
                        Cell cell = new Cell(i, j);
                        Group newGroup;
                        Queue<Cell> queue = new LinkedList<>();
                        Cell[] dir = {new Cell(-1, 0), new Cell(0, -1), new Cell(1, 0), new Cell(0, 1)};

                        visited[i][j] = field[i][j];
                        cells.add(cell);
                        newGroup = new Group(cells, field[i][j], 1, 0, i, j);
                        queue.offer(cell);

                        while (!queue.isEmpty()) {
                            cell = queue.poll();

                            for (Cell d : dir) {
                                int nx = cell.x + d.x;
                                int ny = cell.y + d.y;

                                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                    if (visited[nx][ny] != newGroup.color && (field[nx][ny] == newGroup.color || field[nx][ny] == 0)) {
                                        Cell newCell = new Cell(nx, ny);

                                        queue.offer(newCell);
                                        visited[nx][ny] = newGroup.color;
                                        newGroup.cells.add(newCell);
                                        newGroup.size++;

                                        if (field[nx][ny] == 0) {
                                            newGroup.rainbowBlock++;
                                        } else if (nx < newGroup.row || (nx == newGroup.row && ny < newGroup.col)) {
                                            newGroup.row = nx;
                                            newGroup.col = ny;
                                        }
                                    }
                                }
                            }
                        }

                        if (newGroup.size > group.size) {
                            group = newGroup;
                        } else if (newGroup.size == group.size) {
                            if (newGroup.rainbowBlock > group.rainbowBlock) {
                                group = newGroup;
                            } else if (newGroup.rainbowBlock == group.rainbowBlock) {
                                if (newGroup.row > group.row) {
                                    group = newGroup;
                                } else if (newGroup.row == group.row) {
                                    if (newGroup.col > group.col) {
                                        group = newGroup;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (group.size < 2)
                break;

            for (Cell cell : group.cells)
                field[cell.x][cell.y] = -2;

            score += group.size * group.size;
            gravity(field);

            int[][] newField = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    newField[i][j] = field[j][n - 1 - i];

            field = newField;
            gravity(field);
        }

        bw.write(score + "");
        br.close();
        bw.close();
    }
}
