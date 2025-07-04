/*
 * 문제: 백준 1743번 - 음식물 피하기 (https://www.acmicpc.net/problem/1743)
 * 문제 풀이
 *  BFS로 쓰레기의 크기를 계산하여 최대 크기 갱신.
 *
 * 시간 복잡도: O(k)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743_음식물피하기 {
    // public class Main {
    static int n, m;
    static boolean[][] corridor;

    private static int bfs(Pos pos) {
        int size = 0;
        Queue<Pos> queue = new LinkedList<>();
        Pos[] dir = {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};

        queue.offer(pos);
        corridor[pos.x][pos.y] = false;

        while (!queue.isEmpty()) {
            pos = queue.poll();
            size++;

            for (Pos d : dir) {
                int nx = pos.x + d.x;
                int ny = pos.y + d.y;

                if (nx > 0 && nx <= n && ny > 0 && ny <= m && corridor[nx][ny]) {
                    queue.offer(new Pos(nx, ny));
                    corridor[nx][ny] = false;
                }
            }
        }

        return size;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        corridor = new boolean[n + 1][m + 1];
        Pos[] garbage = new Pos[k];
        int result = 0;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            corridor[r][c] = true;
            garbage[i] = new Pos(r, c);
        }

        for (Pos pos : garbage)
            if (corridor[pos.x][pos.y])
                result = Math.max(result, bfs(pos));

        bw.write(Integer.toString(result));
        br.close();
        bw.close();
    }
}
