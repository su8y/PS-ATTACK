/*
 * 문제: 백준 25516928번 - 뱀과 사다리 게임 (https://www.acmicpc.net/problem/16928)
 * 문제 풀이
 *  BFS로 주사위를 굴려야 하는 최소 횟수 구함.
 *
 * 시간 복잡도: O(v + e) - v: 칸의 수, e: 간선의 수
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] board = new int[101];
        boolean[] visited = new boolean[101];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            board[s] = e - s;
        }

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            cnt++;

            for (int i = queue.size(); i > 0; i--) {
                int now = queue.poll();

                for (int j = 1; j <= 6; j++) {
                    int next = now + j;

                    if (next <= 100 && !visited[next]) {
                        if (next == 100) {
                            bw.write(cnt + "");
                            br.close();
                            bw.close();
                            return;
                        }

                        queue.offer(next + board[next]);
                        visited[next] = true;
                        visited[next + board[next]] = true;
                    }
                }
            }
        }
    }
}
