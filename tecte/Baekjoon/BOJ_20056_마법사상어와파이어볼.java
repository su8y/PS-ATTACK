/*
 * 문제: 백준 20056번 - 마법사 상어와 파이어볼 (https://www.acmicpc.net/problem/20056)
 *
 * 시간 복잡도: O(k * n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20056_마법사상어와파이어볼 {
    // public class Main {
    private static class FireBall {
        int x, y, m, d, s;

        public FireBall(int x, int y, int m, int d, int s) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }

    private static class Cell {
        int m = 0;
        int s = 0;
        int d = 0;
        int cnt = 0;
        boolean isEven = false;
        boolean isOdd = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<FireBall> list = new ArrayList<>(m);
        int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        int result = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int ms = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new FireBall(r, c, ms, d, s));
        }

        while (k-- > 0) {
            Cell[][] field = new Cell[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    field[i][j] = new Cell();
                }
            }

            for (FireBall fireBall : list) {
                int nx = (fireBall.x + dir[fireBall.d][0] * fireBall.s + (n << 10)) % n;
                int ny = (fireBall.y + dir[fireBall.d][1] * fireBall.s + (n << 10)) % n;

                field[nx][ny].m += fireBall.m;
                field[nx][ny].s += fireBall.s;
                field[nx][ny].d = fireBall.d;
                field[nx][ny].cnt++;

                if ((fireBall.d & 1) == 0) {
                    field[nx][ny].isEven = true;
                } else {
                    field[nx][ny].isOdd = true;
                }
            }

            list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (field[i][j].cnt == 0) {
                        continue;
                    } else if (field[i][j].cnt == 1) {
                        list.add(new FireBall(i, j, field[i][j].m, field[i][j].d, field[i][j].s));
                        continue;
                    }

                    int nm = field[i][j].m / 5;
                    int ns = field[i][j].s / field[i][j].cnt;

                    if (nm == 0) {
                        continue;
                    }

                    for (int l = 0; l < 8; l += 2) {
                        list.add(new FireBall(i, j, nm, (field[i][j].isEven && field[i][j].isOdd) ? l + 1 : l, ns));
                    }
                }
            }
        }

        for (FireBall fireBall : list) {
            result += fireBall.m;
        }

        bw.write(Integer.toString(result));
        br.close();
        bw.close();
    }
}
