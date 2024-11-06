/*
 * 문제: 프로그래머스 - [PCCP 모의고사 1] 2번 - 체육대회 (https://school.programmers.co.kr/learn/courses/15008/lessons/121684)
 * 문제 풀이
 *  백트래킹을 사용하여 각 종목에 대표 학생을 뽑는 모든 경우의 수를 탐색.
 *  비트마스크를 사용하여 대표로 뽑힌 학생은 건너뜀.
 *
 * 시간 복잡도: O(n^m) - n: 학생 수, m: 종목 수
 */

package Programmers.PCCP_모의고사_1;

public class PROG_121684_체육대회 {
    // class Solution {
    int[][] ability;
    int answer = 0;

    public int solution(int[][] ability) {
        this.ability = ability;
        dfs(0, 0, 0);

        return answer;
    }

    void dfs(int depth, int visited, int sum) {
        if (depth >= ability[0].length) {
            answer = Math.max(answer, sum);

            return;
        }

        for (int i = 0; i < ability.length; i++) {
            int newVisited = visited | 1 << i;

            if (newVisited == visited)
                continue;

            dfs(depth + 1, newVisited, sum + ability[i][depth]);
        }
    }
}
