/*
 * 문제: 프로그래머스 - [PCCP 모의고사 1] 3번 - 유전법칙 (https://school.programmers.co.kr/learn/courses/15008/lessons/121685)
 * 문제 풀이
 *  재귀 호출를 사용하여 형질을 계산. 각 세대의 형질은 부모 세대의 형질에 따라 결정.
 *  부모가 순종(RR,rr)이면 자식은 무조건 순종이고 부모가 잡종(Rr)이면 자식은 RR,Rr,rr 모두 나올 수 있음.
 *  그러므로 재귀호출로 구한 부모의 형질이 잡종일 때만 자신의 형질을 계산하여 구함.
 *
 * 시간 복잡도: O(q * n) - q: 쿼리의 수, n: 완두콩의 세대
 */

package Programmers.PCCP_모의고사_1;

public class PROG_121685_유전법칙 {
    // class Solution {
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++)
            answer[i] = findTrait(queries[i][0], queries[i][1] - 1);

        return answer;
    }

    String findTrait(int n, int p) {
        if (n == 1)
            return "Rr";

        String trait = findTrait(n - 1, p / 4);

        if (trait.equals("Rr")) {
            if (p % 4 == 0)
                trait = "RR";
            if (p % 4 == 3)
                trait = "rr";
        }

        return trait;
    }
}
