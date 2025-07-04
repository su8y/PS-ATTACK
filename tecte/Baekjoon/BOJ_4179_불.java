/*
 * 문제: 백준 4179번 - 불! (https://www.acmicpc.net/problem/4179)
 *
 * 시간 복잡도: O(r * c)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179_불 {
    // public class Main {
    static class Pos {
        int x, y, t;
        boolean isFire;

        public Pos(int x, int y, int t, boolean isFire) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.isFire = isFire;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] maze = new int[r][c];
        Queue<Pos> queue = new LinkedList<>();
        Pos jh = null;
        String result = "IMPOSSIBLE";

        for (int i = 0; i < r; i++) {
            char[] input = br.readLine().toCharArray();

            for (int j = 0; j < c; j++) {
                if (input[j] == '.')
                    continue;

                maze[i][j] = 1;

                if (input[j] == 'J')
                    jh = new Pos(i, j, 0, false);
                else if (input[j] == 'F')
                    queue.offer(new Pos(i, j, 0, true));
            }
        }

        queue.offer(jh);

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            boolean flag = false;

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (maze[nx][ny] == 0) {
                        queue.offer(new Pos(nx, ny, pos.t + 1, pos.isFire));
                        maze[nx][ny] = 1;
                    }
                } else {
                    if (pos.isFire)
                        continue;

                    flag = true;
                    break;
                }
            }

            if (flag) {
                result = Integer.toString(pos.t + 1);
                break;
            }
        }

        bw.write(result);
        br.close();
        bw.close();
    }
}
