/*
 * 문제: 백준 19238번 - 스타트 택시 (https://www.acmicpc.net/problem/19238)
 * 문제 풀이
 *  BFS로 최단 경로의 손님을 태우고 목적지까지 최단 경로로 이동.
 *
 * 시간 복잡도: O(m * n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19238_스타트택시 {
    // public class Main {
    private static int n, m;
    private static Cell[][] map;

    private static Taxi bfs(Taxi taxi) {
        Queue<Taxi> queue = new LinkedList<>();
        int[] visited = new int[n + 1];
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        Taxi temp = new Taxi(n + 1, n + 1, 0, Integer.MAX_VALUE, 0);

        queue.offer(taxi);
        visited[taxi.x] |= 1 << taxi.y;

        while (!queue.isEmpty()) {
            taxi = queue.poll();

            if (taxi.usedFuel > temp.usedFuel) {
                return temp;
            }

            if (taxi.customer == 0) {
                if (map[taxi.x][taxi.y].start != 0 && (taxi.x < temp.x || (taxi.x == temp.x && taxi.y < temp.y))) {
                    temp = taxi;
                    continue;
                }
            } else if (map[taxi.x][taxi.y].end[taxi.customer]) {
                break;
            }

            if (taxi.fuel == 0) {
                continue;
            }

            for (int[] d : dir) {
                int nx = taxi.x + d[0];
                int ny = taxi.y + d[1];

                if (nx > 0 && nx <= n && ny > 0 && ny <= n && !map[nx][ny].isWall && ((visited[nx] >> ny) & 1) == 0) {
                    queue.offer(new Taxi(nx, ny, taxi.fuel - 1, taxi.usedFuel + 1, taxi.customer));
                    visited[nx] |= 1 << ny;
                }
            }
        }

        return taxi;
    }

    private static int work(Taxi taxi) {
        for (int i = 0; i < m; i++) {
            taxi = bfs(taxi);
            taxi.customer = map[taxi.x][taxi.y].start;
            taxi.usedFuel = map[taxi.x][taxi.y].start = 0;
            taxi = bfs(taxi);

            if (taxi.customer == 0 || !map[taxi.x][taxi.y].end[taxi.customer]) {
                return -1;
            }

            taxi.customer = 0;
            taxi.fuel += taxi.usedFuel << 1;
            taxi.usedFuel = 0;
        }

        return taxi.fuel;
    }

    private static class Cell {
        int start;
        boolean[] end = new boolean[m + 1];
        boolean isWall;

        public Cell(boolean isWall) {
            this.isWall = isWall;
        }
    }

    private static class Taxi {
        int x, y, fuel, usedFuel, customer;

        public Taxi(int x, int y, int fuel, int usedFuel, int customer) {
            this.x = x;
            this.y = y;
            this.fuel = fuel;
            this.usedFuel = usedFuel;
            this.customer = customer;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        map = new Cell[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                map[i][j] = new Cell(Integer.parseInt(st.nextToken()) == 1);
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            map[sx][sy].start = i;
            map[ex][ey].end[i] = true;
        }

        bw.write(Integer.toString(work(new Taxi(x, y, f, 0, 0))));
        br.close();
        bw.close();
    }
}
