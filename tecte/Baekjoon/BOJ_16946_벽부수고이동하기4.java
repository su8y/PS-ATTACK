/*
 * 문제: 백준 16946번 - 벽 부수고 이동하기 4 (https://www.acmicpc.net/problem/16946)
 * 문제 풀이
 *  DFS로 영역을 탐색하고 그룹화하여 각 그룹의 크기를 저장.
 *  벽을 부쉈을 때 인접한 영역의 크기를 더함.
 *
 * 시간 복잡도: O(n * m)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_16946_벽부수고이동하기4 {
    // public class Main {
    private static int n, m;
    private static int[][] map;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static List<Integer> list = new ArrayList<>();

    private static int dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || map[x][y] != 0) {
            return 0;
        }

        int cnt = 1;

        map[x][y] = list.size();

        for (int[] d : dir) {
            cnt += dfs(x + d[0], y + d[1]);
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                if (row[j] == '1') {
                    map[i][j] = 1;
                }
            }
        }

        list.add(0);
        list.add(0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    list.add(dfs(i, j));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    boolean[] check = new boolean[list.size()];
                    int cnt = 1;

                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];

                        if (x >= 0 && x < n && y >= 0 && y < m && !check[map[x][y]]) {
                            cnt += list.get(map[x][y]);
                            check[map[x][y]] = true;
                        }
                    }

                    sb.append(cnt % 10);
                } else {
                    sb.append(0);
                }
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
