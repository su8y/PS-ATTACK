/*
 * 문제: 백준 14502번 - 연구소 (https://www.acmicpc.net/problem/14502)
 * 문제 풀이
 *  백트래킹으로 벽을 설치할 수 있는 모든 경우의 수를 구함.
 *  각 경우의 수마다 BFS로 바이러스가 퍼진 후의 안전 영역의 크기를 구해서 가장 큰 안전 영역의 크기 반환.
 *
 * 시간 복잡도: O((N * M)^4)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14502_연구소 {
    // public class Main {
    static int n;
    static int m;
    static List<Pos> viruses = new ArrayList<>();
    static int wall = 3;
    static int maxSize = 0;

    static void bfs(int[] lab) {
        int size = n * m - wall;
        Queue<Pos> queue = new LinkedList<>();
        int[] visited = lab.clone();
        Pos[] dir = {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};

        for (Pos virus : viruses)
            queue.offer(virus);

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();

            size--;

            for (Pos d : dir) {
                int nx = pos.x + d.x;
                int ny = pos.y + d.y;

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && (visited[nx] & 1 << ny) == 0) {
                    queue.offer(new Pos(nx, ny));
                    visited[nx] |= 1 << ny;
                }
            }
        }

        maxSize = Math.max(maxSize, size);
    }

    static void backtracking(int depth, int[] visited, Pos prev) {
        if (depth > 3) {
            bfs(visited);
            return;
        }

        for (int i = prev.x; i < n; i++) {
            for (int j = (prev.x == i ? prev.y + 1 : 0); j < m; j++) {
                if ((visited[i] & 1 << j) != 0)
                    continue;

                visited[i] |= 1 << j;
                backtracking(depth + 1, visited, new Pos(i, j));
                visited[i] ^= 1 << j;
            }
        }
    }

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] lab = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int cell = Integer.parseInt(st.nextToken());

                if (cell == 1)
                    wall++;
                else if (cell == 2)
                    viruses.add(new Pos(i, j));
                else
                    continue;

                lab[i] |= 1 << j;
            }
        }

        backtracking(1, lab, new Pos(0, -1));
        bw.write(Integer.toString(maxSize));
        br.close();
        bw.close();
    }
}
