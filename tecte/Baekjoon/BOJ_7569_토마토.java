/*
 * 문제 : 백준 7569번 - 토마토 (https://www.acmicpc.net/problem/7569)
 * 문제 풀이
 *  BFS를 사용. 큐에 삽입할 때 개수를 세어서 익은 토마토의 개수를 구함
 *  BFS가 끝났을 때 익은 토마토의 개수가 전체 토마토의 개수보다 작은면 -1, 같으면 최소 날짜
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] box = new int[m][n][h];
        int cnt = m * n * h;
        Queue<Pos> queue = new LinkedList<>();

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < m; j++) {
                    int tomato = Integer.parseInt(st.nextToken());

                    if (tomato == 0)
                        cnt--;
                    else if (tomato == 1)
                        queue.offer(new Pos(j, i, k));

                    box[j][i][k] = tomato;
                }
            }
        }

        Pos[] dir = {new Pos(-1, 0, 0), new Pos(1, 0, 0), new Pos(0, -1, 0), new Pos(0, 1, 0), new Pos(0, 0, 1), new Pos(0, 0, -1)};
        Pos pos = null;

        while (!queue.isEmpty()) {
            pos = queue.poll();

            for (Pos d : dir) {
                int nx = pos.x + d.x;
                int ny = pos.y + d.y;
                int nh = pos.h + d.h;

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && nh >= 0 && nh < h && box[nx][ny][nh] == 0) {
                    box[nx][ny][nh] = box[pos.x][pos.y][pos.h] + 1;
                    cnt++;
                    queue.offer(new Pos(nx, ny, nh));
                }
            }
        }

        if (cnt == m * n * h && pos != null)
            bw.write(box[pos.x][pos.y][pos.h] - 1 + "");
        else
            bw.write("-1");

        br.close();
        bw.close();
    }

    public static class Pos {
        int x, y, h;

        public Pos(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
