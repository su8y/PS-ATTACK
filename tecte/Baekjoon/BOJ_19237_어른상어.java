/*
 * 문제: 백준 19237번 - 어른 상어 (https://www.acmicpc.net/problem/19237)
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_19237_어른상어 {
    // public class Main {
    private static int n, k;
    private static Cell[][] sea;
    private static List<Shark> sharks = new ArrayList<>();

    private static boolean move(Shark shark, int t, boolean canMyArea) {
        int[][] dir = {{}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < 4; i++) {
            int d = shark.dir[shark.d][i];
            int nx = shark.x + dir[d][0];
            int ny = shark.y + dir[d][1];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (sea[nx][ny].smell < t - k || (canMyArea && sea[nx][ny].shark == shark.idx)) {
                    sea[shark.x][shark.y].isShark = false;
                    shark.x = nx;
                    shark.y = ny;
                    shark.d = d;

                    return true;
                }
            }
        }

        return false;
    }

    private static int turn() {
        for (int t = 1; t <= 1000; t++) {
            List<Shark> newSharks = new ArrayList<>();

            for (Shark shark : sharks) {
                if (move(shark, t, false)) {
                    if (sea[shark.x][shark.y].isShark) {
                        continue;
                    }
                } else {
                    move(shark, t, true);
                }

                sea[shark.x][shark.y].shark = shark.idx;
                sea[shark.x][shark.y].isShark = true;
                newSharks.add(shark);
            }

            sharks = newSharks;

            if (sharks.size() == 1)
                return t;

            for (Shark shark : sharks) {
                sea[shark.x][shark.y].smell = t;
            }
        }

        return -1;
    }

    private static class Cell {
        int shark, smell;
        boolean isShark = false;

        public Cell(int shark, int smell) {
            this.shark = shark;
            this.smell = smell;
        }
    }

    private static class Shark {
        int idx, x, y, d;
        int[][] dir = new int[5][4];

        public Shark(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        sea = new Cell[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int s = Integer.parseInt(st.nextToken());

                sea[i][j] = new Cell(s, -k);

                if (s != 0) {
                    sharks.add(new Shark(s, i, j));
                    sea[i][j].smell = 0;
                    sea[i][j].isShark = true;
                }
            }
        }

        sharks.sort(Comparator.comparingInt(a -> a.idx));
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            sharks.get(i).d = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= 4; j++) {
                sharks.get(i).dir[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        bw.write(Integer.toString(turn()));
        br.close();
        bw.close();
    }
}
