/*
 * 문제 : 프로그래머스 - 전력망을 둘로 나누기 (https://school.programmers.co.kr/learn/courses/30/lessons/86971)
 * 문제 풀이
 *  DFS를 하면서 각 노드마다 자신의 자식 노드 개수를 구함.
 *  전체 노드 - (자신 + 자식 노드 수)를 하고 절대값을 구하면 송전탑 개수의 차이를 구할 수 있음.
 */

package Programmers;

import java.util.ArrayList;
import java.util.List;

public class PROG_86971_전력망을둘로나누기 {
    static class Solution {
        int n;
        List<List<Integer>> graph = new ArrayList<>();
        int diff = Integer.MAX_VALUE;

        public int solution(int n, int[][] wires) {
            for (int i = 0; i <= n; i++)
                graph.add(new ArrayList<>());

            for (int[] edge : wires) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            this.n = n;
            dfs(1, 0);

            return diff;
        }

        int dfs(int v, int p) {
            int cnt = 1;

            for (int to : graph.get(v))
                if (to != p)
                    cnt += dfs(to, v);

            diff = Math.min(diff, Math.abs(n - cnt - cnt));

            return cnt;
        }
    }

    public static void main(String[] args) {
        int[] n = {9, 4, 7};
        int[][][] wires = {
                {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}},
                {{1, 2}, {2, 3}, {3, 4}},
                {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}
        };

        for (int i = 0; i < n.length; i++)
            System.out.println(new Solution().solution(n[i], wires[i]));
    }
}
