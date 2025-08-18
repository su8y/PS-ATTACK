/*
 * 문제 : 백준 2638번 - 치즈 (https://www.acmicpc.net/problem/2638)
 * 문제 풀이
 *  치즈 외부 공기를 BFS로 돌면서 외부 공기와 접촉되는 치즈 격자의 스택 증가.
 *  스택이 2번 이상 쌓인 치즈 격자는 한 시간 후 녹을 치즈 격자임.
 *  이 과정을 반복하여 치즈가 모두 녹는데 걸리는 시간을 구함.
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2638_치즈 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] cheese = new int[n][];
        Queue<Pos> queue = new LinkedList<>();

        for (int i = 0; i < n; i++)
            cheese[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; ; i++) {
            boolean flag = true;
            Pos[] dir = {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};

            queue.offer(new Pos(0, 0));

            while (!queue.isEmpty()) {
                Pos pos = queue.poll();

                for (Pos d : dir) {
                    int nx = pos.x + d.x;
                    int ny = pos.y + d.y;

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && cheese[nx][ny] > -i) {
                        if (cheese[nx][ny] > 0) {
                            flag = false;
                            cheese[nx][ny] = cheese[nx][ny] == i + 1 ? -i : i + 1;
                        } else {
                            queue.offer(new Pos(nx, ny));
                            cheese[nx][ny] = -i;
                        }
                    }
                }
            }

            if (flag) {
                bw.write(Integer.toString(i - 1));
                break;
            }
        }

        br.close();
        bw.close();
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
