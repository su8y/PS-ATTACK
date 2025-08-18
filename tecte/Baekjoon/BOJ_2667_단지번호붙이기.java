/*
 * 문제 : 백준 2667번 - 단지번호붙이기 (https://www.acmicpc.net/problem/2667)
 * 문제 풀이
 *  BFS로 단지수를 모두 구하고 정렬해서 출력
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        ArrayList<Integer> complex = new ArrayList<>();

        for (int i = 0; i < n; i++)
            map[i] = br.readLine().chars().map(Character::getNumericValue).toArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 1)
                    continue;

                Queue<Pos> queue = new LinkedList<>();
                int group = complex.size() + 2;
                int cnt = 0;

                queue.offer(new Pos(i, j));
                map[i][j] = group;
                cnt++;

                while (!queue.isEmpty()) {
                    Pos[] dir = {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};
                    Pos pos = queue.poll();

                    for (Pos d : dir) {
                        int nx = pos.x + d.x;
                        int ny = pos.y + d.y;

                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1) {
                            queue.offer(new Pos(nx, ny));
                            map[nx][ny] = group;
                            cnt++;
                        }
                    }
                }

                complex.add(cnt);
            }
        }

        bw.write(complex.size() + "\n");
        complex.sort(null);

        for (int c : complex)
            bw.write(c + "\n");

        br.close();
        bw.close();
    }

    public static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
