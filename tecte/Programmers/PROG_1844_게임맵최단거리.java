/*
 * 문제 : 프로그래머스 - 게임 맵 최단거리 (https://school.programmers.co.kr/learn/courses/30/lessons/1844)
 *  문제 풀이
 *  dfs 방식으로 풀면 프로그래머스에 제출시 정확성 테스트는 통과하나 효율성 테스트에서 시간 초과가 떠 틀렸다고 뜸.
 */

package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PROG_1844_게임맵최단거리 {
    static class Solution {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        boolean[][] visited;

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

    public static void main(String[] args) {
        int[][][] maps = {
                {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}},
                {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}
        };

        for (int[][] map : maps)
            System.out.println(new Solution().solution(map));
    }
}
