/*
 * 문제 : 프로그래머스 - 깊이/너비 우선 탐색(DFS/BFS) - 게임 맵 최단거리 (https://school.programmers.co.kr/learn/courses/30/lessons/1844)
 * 문제 풀이
 *  dfs 방식으로 풀면 프로그래머스에 제출시 정확성 테스트는 통과하나 효율성 테스트에서 시간 초과가 떠 틀렸다고 뜸.
 *
 * 시간 복잡도: O(n * m)
 */

package programmers.깊이너비우선탐색dfsbfs;

import java.util.*;

public class PROG_게임맵최단거리 {
    // class Solution {
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {-1, 0, 1, 0};
    private boolean[][] visited;

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new LinkedList<>();

        visited = new boolean[n][m];
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            if (node[0] == n - 1 && node[1] == m - 1)
                return node[2];

            for (int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny, node[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }
}
