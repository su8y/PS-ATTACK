/*
 * 문제: 백준 23289번 - 온풍기 안녕! (https://www.acmicpc.net/problem/23289)
 *
 * 시간 복잡도: O(h * r * c) - h: 온풍기의 개수
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_23289_온풍기안녕 {
    // public class Main {
    private static int r, c, k;
    private static Cell[][] room;
    private static List<Pos> heater = new ArrayList<>();
    private static List<Pos> checkCell = new ArrayList<>();
    private static int[][] dir = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private static boolean checkBoundary(int x, int y) {
        return x > 0 && x <= r && y > 0 && y <= c;
    }

    private static void blow() {
        for (Pos h : heater) {
            List<Pos> wind = new ArrayList<>();
            int[] visited = new int[r + 1];

            wind.add(new Pos(h.x, h.y, h.d));

            for (int i = 5; i > 0; i--) {
                List<Pos> newWind = new ArrayList<>();

                for (Pos w : wind) {
                    if (room[w.x][w.y].w[w.d]) {
                        continue;
                    }

                    w.x += dir[w.d][0];
                    w.y += dir[w.d][1];

                    if (checkBoundary(w.x, w.y)) {
                        room[w.x][w.y].temp += i;
                    } else {
                        continue;
                    }

                    int d = w.d < 3 ? 3 : 2;
                    int x = w.x + dir[d][0];
                    int y = w.y + dir[d][1];

                    if (checkBoundary(x, y) && (visited[x] & (1 << y)) == 0 && !room[w.x][w.y].w[d]) {
                        newWind.add(new Pos(x, y, w.d));
                        visited[x] |= 1 << y;
                    }

                    if ((visited[w.x] & (1 << w.y)) == 0) {
                        newWind.add(w);
                        visited[w.x] |= 1 << w.y;
                    }

                    d = w.d < 3 ? 4 : 1;
                    x = w.x + dir[d][0];
                    y = w.y + dir[d][1];

                    if (checkBoundary(x, y) && (visited[x] & (1 << y)) == 0 && !room[w.x][w.y].w[d]) {
                        newWind.add(new Pos(x, y, w.d));
                        visited[x] |= 1 << y;
                    }
                }

                wind = newWind;
            }
        }
    }

    private static void controlTemp() {
        Cell[][] newRoom = new Cell[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                newRoom[i][j] = new Cell(room[i][j].temp, room[i][j].w);
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                for (int d = 1; d < 5; d++) {
                    int x = i + dir[d][0];
                    int y = j + dir[d][1];

                    if (checkBoundary(x, y) && !room[i][j].w[d] && room[i][j].temp > room[x][y].temp) {
                        int temp = (room[i][j].temp - room[x][y].temp) >> 2;

                        newRoom[i][j].temp -= temp;
                        newRoom[x][y].temp += temp;
                    }
                }
            }
        }

        room = newRoom;
    }

    private static void decTemp() {
        for (int i = 1; i <= c; i++) {
            if (room[1][i].temp > 0) {
                room[1][i].temp--;
            }

            if (room[r][i].temp > 0) {
                room[r][i].temp--;
            }
        }

        for (int i = 2; i < r; i++) {
            if (room[i][1].temp > 0) {
                room[i][1].temp--;
            }

            if (room[i][c].temp > 0) {
                room[i][c].temp--;
            }
        }
    }

    private static boolean checkTemp() {
        for (Pos pos : checkCell) {
            if (room[pos.x][pos.y].temp < k) {
                return false;
            }
        }

        return true;
    }

    private static String test() {
        for (int i = 1; i < 101; i++) {
            blow();
            controlTemp();
            decTemp();

            if (checkTemp()) {
                return Integer.toString(i);
            }
        }

        return "101";
    }

    private static class Cell {
        int temp;
        boolean[] w;

        public Cell(int temp, boolean[] w) {
            this.temp = temp;
            this.w = w;
        }
    }

    private static class Pos {
        int x, y, d;

        public Pos(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        room = new Cell[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= c; j++) {
                int n = Integer.parseInt(st.nextToken());

                room[i][j] = new Cell(0, new boolean[5]);

                if (n > 0) {
                    Pos pos = new Pos(i, j, n);

                    if (n == 5) {
                        checkCell.add(pos);
                    } else {
                        heater.add(pos);
                    }
                }
            }
        }

        int w = Integer.parseInt(br.readLine());

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (t == 0) {
                room[x][y].w[3] = true;

                if (checkBoundary(x - 1, y)) {
                    room[x - 1][y].w[4] = true;
                }
            } else {
                room[x][y].w[1] = true;

                if (checkBoundary(x, y + 1)) {
                    room[x][y + 1].w[2] = true;
                }
            }
        }

        bw.write(test());
        br.close();
        bw.close();
    }
}
