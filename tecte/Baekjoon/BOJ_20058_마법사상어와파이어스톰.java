/*
 * 문제: 백준 20058번 - 마법사 상어와 파이어스톰 (https://www.acmicpc.net/problem/20058)
 *
 * 시간 복잡도: O(q * m^2) - m: 2^n
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20058_마법사상어와파이어스톰 {
    // public class Main {
    private static int m;
    private static int[][] ice;
    private static boolean[][] visited;
    private static Pos[] dir = {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};
    private static int sum = 0;
    private static int max = 0;

    private static void rotate(int x, int y, int len) {
        int[][] temp = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[i][j] = ice[x + len - 1 - j][y + i];
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                ice[x + i][y + j] = temp[i][j];
            }
        }
    }

    private static void melt() {
        int[][] newIce = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = 0;

                if (ice[i][j] == 0) {
                    continue;
                } else {
                    newIce[i][j] = ice[i][j];
                }

                for (Pos d : dir) {
                    int x = i + d.x;
                    int y = j + d.y;

                    if (x >= 0 && x < m && y >= 0 && y < m && ice[x][y] > 0) {
                        cnt++;
                    }
                }

                if (cnt < 3) {
                    newIce[i][j]--;
                }
            }
        }

        ice = newIce;
    }

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new LinkedList<>();
        int size = 0;

        queue.offer(pos);
        visited[pos.x][pos.y] = true;
        sum += ice[pos.x][pos.y];

        while (!queue.isEmpty()) {
            pos = queue.poll();
            size++;

            for (Pos d : dir) {
                int x = pos.x + d.x;
                int y = pos.y + d.y;

                if (x < 0 || x >= m || y < 0 || y >= m || visited[x][y] || ice[x][y] == 0) {
                    continue;
                }

                queue.offer(new Pos(x, y));
                visited[x][y] = true;
                sum += ice[x][y];
            }
        }

        max = Math.max(max, size);
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
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        m = 1 << n;
        ice = new int[m][m];
        visited = new boolean[m][m];

        for (int i = 0; i < m; i++) {
            ice[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] cast = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < q; i++) {
            int sub = 1 << cast[i];

            for (int j = 0; j < m; j += sub) {
                for (int k = 0; k < m; k += sub) {
                    rotate(j, k, sub);
                }
            }

            melt();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (ice[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                bfs(new Pos(i, j));
            }
        }

        bw.write(sum + "\n" + max);
        br.close();
        bw.close();
    }
}
