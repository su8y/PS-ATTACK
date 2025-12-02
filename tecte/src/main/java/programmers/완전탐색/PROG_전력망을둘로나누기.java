/*
 * 문제: 프로그래머스 - 완전탐색 - 전력망을 둘로 나누기 (https://school.programmers.co.kr/learn/courses/30/lessons/86971)
 * 문제 풀이
 *  DFS를 하면서 각 노드마다 자신의 자식 노드 개수를 구함.
 *  전체 노드 - (자신 + 자식 노드 수)를 하고 절대값을 구하면 송전탑 개수의 차이를 구할 수 있음.
 *
 * 시간 복잡도: O(n)
 */

package programmers.완전탐색;

import java.util.*;

public class PROG_전력망을둘로나누기 {
    // class Solution {
    private int n;
    private List<List<Integer>> graph = new ArrayList<>();
    private int diff = Integer.MAX_VALUE;

    private int dfs(int v, int p) {
        int cnt = 1;

        for (int to : graph.get(v))
            if (to != p)
                cnt += dfs(to, v);

        diff = Math.min(diff, Math.abs(n - cnt - cnt));

        return cnt;
    }

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
}
