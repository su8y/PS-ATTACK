/*
 * 문제: 백준 15683번 - 감시 (https://www.acmicpc.net/problem/15683)
 *
 * 시간 복잡도: O(4^k) - k: CCTV 개수
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
    // public class Main {
    private static int n, m;
    private static List<Pos> cctv = new ArrayList<>();
    private static int[][] office;

    private static int monitor(int[] visited, Pos pos, int dir, int blindSpot) {
        if (dir == 0) {
            for (int i = pos.x - 1; i >= 0; i--) {
                if (office[i][pos.y] == 6)
                    break;

                int y = 1 << pos.y;

                if ((visited[i] & y) != 0)
                    continue;

                visited[i] |= y;
                blindSpot--;
            }
        } else if (dir == 1) {
            for (int i = pos.y + 1; i < m; i++) {
                if (office[pos.x][i] == 6)
                    break;

                int y = 1 << i;

                if ((visited[pos.x] & y) != 0)
                    continue;

                visited[pos.x] |= y;
                blindSpot--;
            }
        } else if (dir == 2) {
            for (int i = pos.x + 1; i < n; i++) {
                if (office[i][pos.y] == 6)
                    break;

                int y = 1 << pos.y;

                if ((visited[i] & y) != 0)
                    continue;

                visited[i] |= y;
                blindSpot--;
            }
        } else {
            for (int i = pos.y - 1; i >= 0; i--) {
                if (office[pos.x][i] == 6)
                    break;

                int y = 1 << i;

                if ((visited[pos.x] & y) != 0)
                    continue;

                visited[pos.x] |= y;
                blindSpot--;
            }
        }

        return blindSpot;
    }

    private static int dfs(int depth, int[] visited, int blindSpot) {
        if (depth == cctv.size())
            return blindSpot;

        Pos pos = cctv.get(depth);
        int nbs = blindSpot;

        if (office[pos.x][pos.y] == 1) {
            for (int i = 0; i < 4; i++) {
                int[] newVisited = visited.clone();
                int nnbs = monitor(newVisited, pos, i, blindSpot);

                nbs = Math.min(nbs, dfs(depth + 1, newVisited, nnbs));
            }
        } else if (office[pos.x][pos.y] == 2) {
            for (int i = 0; i < 2; i++) {
                int[] newVisited = visited.clone();
                int nnbs = monitor(newVisited, pos, i, blindSpot);

                nnbs = monitor(newVisited, pos, i + 2, nnbs);
                nbs = Math.min(nbs, dfs(depth + 1, newVisited, nnbs));
            }
        } else if (office[pos.x][pos.y] == 3) {
            for (int i = 0; i < 4; i++) {
                int[] newVisited = visited.clone();
                int nnbs = monitor(newVisited, pos, i, blindSpot);

                nnbs = monitor(newVisited, pos, (i + 1) % 4, nnbs);
                nbs = Math.min(nbs, dfs(depth + 1, newVisited, nnbs));
            }
        } else if (office[pos.x][pos.y] == 4) {
            for (int i = 0; i < 4; i++) {
                int[] newVisited = visited.clone();
                int nnbs = monitor(newVisited, pos, i, blindSpot);

                nnbs = monitor(newVisited, pos, (i + 1) % 4, nnbs);
                nnbs = monitor(newVisited, pos, (i + 2) % 4, nnbs);
                nbs = Math.min(nbs, dfs(depth + 1, newVisited, nnbs));
            }
        } else {
            int[] newVisited = visited.clone();
            int nnbs = monitor(newVisited, pos, 0, blindSpot);

            nnbs = monitor(newVisited, pos, 1, nnbs);
            nnbs = monitor(newVisited, pos, 2, nnbs);
            nnbs = monitor(newVisited, pos, 3, nnbs);
            nbs = Math.min(nbs, dfs(depth + 1, newVisited, nnbs));
        }

        return nbs;
    }

    private static class Pos {
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
        office = new int[n][m];
        int blindSpot = n * m;
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());

                if (office[i][j] == 0)
                    continue;
                else if (office[i][j] != 6)
                    cctv.add(new Pos(i, j));

                blindSpot--;
                visited[i] |= 1 << j;
            }
        }

        bw.write(Integer.toString(dfs(0, visited, blindSpot)));
        br.close();
        bw.close();
    }
}
