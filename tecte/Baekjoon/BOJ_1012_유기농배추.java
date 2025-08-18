/*
 * 문제 : 백준 1012번 - 유기농 배추 (https://www.acmicpc.net/problem/1012)
 * 문제 풀이
 *  boolean 타입의 2차원 배열을 만들어서 배추가 있는 곳을 true로 저장. 2차원 배열 하나를 더 만들어서 배추가 있는 곳의 좌표를 저장
 *  BFS로 인접한 배추를 찾음. 찾은 배추는 false로 저장. 큐가 비어지면 배추흰지렁이의 개수를 1증가.
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[][] field = new boolean[m][n];
            int[][] cabbages = new int[k][2];
            int worm = 0;
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                field[x][y] = true;
                cabbages[i][0] = x;
                cabbages[i][1] = y;
            }

            for (int[] cabbage : cabbages) {
                if (field[cabbage[0]][cabbage[1]]) {
                    queue.offer(cabbage);
                    field[cabbage[0]][cabbage[1]] = false;
                    worm++;

                    while (!queue.isEmpty()) {
                        int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
                        int[] c = queue.poll();

                        for (int[] d : dir) {
                            int x = c[0] + d[0];
                            int y = c[1] + d[1];

                            if (x >= 0 && x < m && y >= 0 && y < n && field[x][y]) {
                                queue.offer(new int[]{x, y});
                                field[x][y] = false;
                            }
                        }
                    }
                }
            }

            bw.write(worm + "");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
