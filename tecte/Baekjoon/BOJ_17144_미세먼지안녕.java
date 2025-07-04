/*
 * 문제: 백준 17144번 - 미세먼지 안녕! (https://www.acmicpc.net/problem/17144)
 *
 * 시간 복잡도: O(T * R * C)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
    // public class Main {
    static int[][] house;
    static List<Pos> dusts;

    static int move(Pos start, Pos end, Pos dir, int dust) {
        int x = end.x;
        int y = end.y;
        int tmp = house[x][y];

        while (x != start.x || y != start.y) {
            int nx = x - dir.x;
            int ny = y - dir.y;

            if (house[nx][ny] > 0 && house[x][y] != -1)
                dusts.add(new Pos(x, y));

            house[x][y] = house[nx][ny];
            x = nx;
            y = ny;
        }

        if (dust > 0)
            dusts.add(new Pos(x, y));

        house[x][y] = dust;

        return tmp;
    }

    static class Pos {
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
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        house = new int[r][c];
        List<Pos> airCleaner = new ArrayList<>();
        dusts = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < c; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());

                if (house[i][j] == -1)
                    airCleaner.add(new Pos(i, j));
                else if (house[i][j] != 0)
                    dusts.add(new Pos(i, j));
            }
        }

        while (t-- > 0) {
            Pos[] dir = {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};
            int[][] newHouse = new int[r][c];
            List<Pos> newDusts = new ArrayList<>();
            int tmp;

            for (Pos dust : dusts) {
                int amount = house[dust.x][dust.y] / 5;

                if (newHouse[dust.x][dust.y] == 0 && dust.x != 0 && dust.x != airCleaner.get(0).x && dust.x != airCleaner.get(1).x && dust.x != r - 1 && dust.y != 0 && dust.y != c - 1)
                    newDusts.add(dust);

                newHouse[dust.x][dust.y] += house[dust.x][dust.y];

                for (Pos d : dir) {
                    int nx = dust.x + d.x;
                    int ny = dust.y + d.y;

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c || house[nx][ny] == -1)
                        continue;

                    if (amount > 0 && newHouse[nx][ny] == 0 && nx != 0 && nx != airCleaner.get(0).x && nx != airCleaner.get(1).x && nx != r - 1 && ny != 0 && ny != c - 1)
                        newDusts.add(new Pos(nx, ny));

                    newHouse[nx][ny] += amount;
                    newHouse[dust.x][dust.y] -= amount;
                }
            }

            house = newHouse;
            dusts = newDusts;
            tmp = move(new Pos(airCleaner.get(0).x, 1), new Pos(airCleaner.get(0).x, c - 1), dir[1], 0);
            tmp = move(new Pos(airCleaner.get(0).x - 1, c - 1), new Pos(0, c - 1), dir[0], tmp);
            tmp = move(new Pos(0, c - 2), new Pos(0, 0), dir[3], tmp);
            move(new Pos(1, 0), airCleaner.get(0), dir[2], tmp);
            tmp = move(new Pos(airCleaner.get(1).x, 1), new Pos(airCleaner.get(1).x, c - 1), dir[1], 0);
            tmp = move(new Pos(airCleaner.get(1).x + 1, c - 1), new Pos(r - 1, c - 1), dir[2], tmp);
            tmp = move(new Pos(r - 1, c - 2), new Pos(r - 1, 0), dir[3], tmp);
            move(new Pos(r - 2, 0), airCleaner.get(1), dir[0], tmp);
            house[airCleaner.get(0).x][airCleaner.get(0).y] = -1;
            house[airCleaner.get(1).x][airCleaner.get(1).y] = -1;
        }

        for (Pos dust : dusts) {
            if ((dust.x == airCleaner.get(0).x && dust.y == airCleaner.get(0).y) || (dust.x == airCleaner.get(1).x && dust.y == airCleaner.get(1).y))
                continue;

            total += house[dust.x][dust.y];
        }

        bw.write(Integer.toString(total));
        br.close();
        bw.close();
    }
}
