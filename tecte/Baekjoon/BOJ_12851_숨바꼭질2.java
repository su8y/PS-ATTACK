/*
 * 문제: 백준 12851번 - 숨바꼭질 2 (https://www.acmicpc.net/problem/12851)
 * 문제 풀이
 *  BFS로 동생의 위치까지 갈 수 있는 경로의 수를 찾음.
 *
 * 시간 복잡도: O(v) - 0 <= v <= 100,000
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12851_숨바꼭질2 {
    // public class Main {
    static class Pos {
        int x, t;

        public Pos(int x, int t) {
            this.x = x;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] time = new int[100001];
        int cnt = 0;
        Queue<Pos> queue = new LinkedList<>();

        time[k] = Integer.MAX_VALUE;
        queue.offer(new Pos(n, 0));

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();

            if (time[pos.x] == 0)
                time[pos.x] = pos.t;

            if (pos.t > time[k]) {
                break;
            } else if (time[pos.x] < pos.t) {
                continue;
            } else if (pos.x == k) {
                time[k] = pos.t;
                cnt++;
                continue;
            }

            int[] move = {pos.x - 1, pos.x + 1, pos.x * 2};

            for (int m : move) {
                if (m < 0 || m > 100000)
                    continue;

                queue.offer(new Pos(m, pos.t + 1));
            }
        }

        bw.write(time[k] + "\n");
        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
