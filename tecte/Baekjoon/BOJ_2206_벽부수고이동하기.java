/*
 * 문제: 백준 2206번 - 벽 부수고 이동하기 (https://www.acmicpc.net/problem/2206)
 * 문제 풀이
 *  BFS로 최단 경로를 탐색하면서 boolean 변수로 벽을 부수고 이동할 수 있는지 확인.
 *  boolean으로 방문 여부를 판단하면 처음 벽을 부수고 이동한 경로가 아직 벽을 부수지 않고 이동한 경로를 가로막는 경우가 생겨
 *  나중에 벽을 부숴야 하는 상황에서 부수지 못하고 -1를 출력할 수 있음.
 *  그래서 벽을 부수고 이동한 경로와 벽을 부수지 않고 이동한 경로를 구분해야 함.
 *  따로 방문 여부를 판단하는 배열을 만들지 않고 입력받은 맵에서 벽을 부수고 이동하면 '2'로 바꾸고 벽을 부수지 않고 이동하면 '3'으로 바꿈.
 *  벽을 부수고 이동한 경로와 벽을 부시지 않고 이동한 경로가 겹치는 경우,
 *  '3'은 아예 이동하지 못하고 벽을 부술 수 있으면 '0', '1', '2'로 이동할 수 있고 벽을 부술 수 없으면 '0'으로만 이동 할 수 있음.
 *
 * 시간 복잡도: O(n * m)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2206_벽부수고이동하기 {
    // public class Main {
    static class Pos {
        int x, y, dist;
        boolean canBreak;

        public Pos(int x, int y, int dist, boolean canBreak) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.canBreak = canBreak;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        StringBuilder[] map = new StringBuilder[n];
        Queue<Pos> queue = new LinkedList<>();
        int dist = -1;

        for (int i = 0; i < n; i++)
            map[i] = new StringBuilder(br.readLine());

        queue.offer(new Pos(0, 0, 1, true));
        map[0].setCharAt(0, '2');

        while (!queue.isEmpty()) {
            int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            Pos pos = queue.poll();

            if (pos.x == n - 1 && pos.y == m - 1) {
                dist = pos.dist;
                break;
            }

            for (int[] d : dir) {
                int nx = pos.x + d[0];
                int ny = pos.y + d[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx].charAt(ny) != '3') {
                    Pos next = new Pos(nx, ny, pos.dist + 1, pos.canBreak);

                    if (pos.canBreak) {
                        next.canBreak = map[nx].charAt(ny) != '1';
                        map[nx].setCharAt(ny, '3');
                    } else if (map[nx].charAt(ny) == '0') {
                        map[nx].setCharAt(ny, '2');
                    } else {
                        continue;
                    }

                    queue.offer(next);
                }
            }
        }

        bw.write(dist + "");
        br.close();
        bw.close();
    }
}
