/*
 * 문제: 백준 20057번 - 마법사 상어와 토네이도 (https://www.acmicpc.net/problem/20057)
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_20057_마법사상어와토네이도 {
    // public class Main {
    private static int n;
    private static int[][] field;
    private static int lostSand = 0;

    private static void blow(int x, int y, int d) {
        int[] ratio = new int[12];
        int[] sand = new int[12];
        int alpha = 0;

        int[][] dir = {
                {-2, 0},
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -2}, {0, -1}, {0, 1}, {0, 2},
                {1, -1}, {1, 0}, {1, 1},
                {2, 0}
        };

        switch (d) {
            case 0:
                ratio[0] = ratio[11] = 2;
                ratio[1] = ratio[8] = 10;
                ratio[2] = ratio[9] = 7;
                ratio[3] = ratio[10] = 1;
                ratio[4] = 5;
                alpha = 5;
                break;
            case 1:
                ratio[1] = ratio[3] = 1;
                ratio[4] = ratio[7] = 2;
                ratio[5] = ratio[6] = 7;
                ratio[8] = ratio[10] = 10;
                ratio[11] = 5;
                alpha = 9;
                break;
            case 2:
                ratio[0] = ratio[11] = 2;
                ratio[1] = ratio[8] = 1;
                ratio[2] = ratio[9] = 7;
                ratio[3] = ratio[10] = 10;
                ratio[7] = 5;
                alpha = 6;
                break;
            case 3:
                ratio[0] = 5;
                ratio[1] = ratio[3] = 10;
                ratio[4] = ratio[7] = 2;
                ratio[5] = ratio[6] = 7;
                ratio[8] = ratio[10] = 1;
                alpha = 2;
                break;
        }

        sand[alpha] = field[x][y];

        for (int i = 0; i < 12; i++) {
            if (ratio[i] > 0) {
                sand[i] = field[x][y] * ratio[i] / 100;
                sand[alpha] -= sand[i];
            }
        }

        for (int i = 0; i < 12; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                lostSand += sand[i];
            } else {
                field[nx][ny] += sand[i];
            }
        }

        field[x][y] = 0;
    }

    private static void tornado() {
        int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int d = 0;
        int x = n >> 1;
        int y = n >> 1;
        double len = 1;

        while (true) {
            for (int i = 1; i <= len; i++) {
                x += dir[d][0];
                y += dir[d][1];

                if (x < 0 || x >= n || y < 0 || y >= n) {
                    return;
                }

                blow(x, y, d);
            }

            d = (d + 1) % 4;
            len += .5;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        field = new int[n][n];

        for (int i = 0; i < n; i++) {
            field[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        tornado();
        bw.write(Integer.toString(lostSand));
        br.close();
        bw.close();
    }
}
