/*
 * 문제: 백준 16173번 - 점프왕 쩰리 (Small) (https://www.acmicpc.net/problem/16173)
 * 문제 풀이
 *  BFS로 쩰리가 끝 점까지 올 수 있는지 구함.
 *  칸의 수가 0인 곳은 움직일 수 없으므로 다른 경로로 가야 함.
 *
 * 시간 복잡도: O(N^2)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16173_점프왕쩰리Small {
    // public class Main {
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
        int n = Integer.parseInt(br.readLine());
        int[][] area = new int[n][];
        Queue<Pos> queue = new LinkedList<>();
        String result = "Hing";

        for (int i = 0; i < n; i++)
            area[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        queue.offer(new Pos(0, 0));

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();

            if (pos.x >= n || pos.y >= n || area[pos.x][pos.y] == 0) {
                continue;
            } else if (area[pos.x][pos.y] == -1) {
                result = "HaruHaru";
                break;
            }

            queue.offer(new Pos(pos.x + area[pos.x][pos.y], pos.y));
            queue.offer(new Pos(pos.x, pos.y + area[pos.x][pos.y]));
        }

        bw.write(result);
        br.close();
        bw.close();
    }
}
