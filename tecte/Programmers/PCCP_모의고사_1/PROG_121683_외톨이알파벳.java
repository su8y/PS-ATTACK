/*
 * 문제: 프로그래머스 - [PCCP 모의고사 1] 1번 - 외톨이 알파벳 (https://school.programmers.co.kr/learn/courses/15008/lessons/121683)
 * 문제 풀이
 *  배열을 사용해 각 문자가 한 번이라도 나왔는지 확인.
 *  이미 나왔던 문자가 연속되지 않게 다시 나오면 TreeSet에 저장
 *  TreeSet에 문자가 있으면 합쳐서 반환하고 없으면 "N" 반환
 *
 * 시간 복잡도: O(n log k) - 최악의 경우 k는 26
 */

package Programmers.PCCP_모의고사_1;

import java.util.TreeSet;
import java.util.stream.Collectors;

public class PROG_121683_외톨이알파벳 {
    // class Solution {
    public String solution(String input_string) {
        boolean[] alphabet = new boolean[26];
        TreeSet<Character> set = new TreeSet<>();
        char prev = 0;
        String answer = "N";

        for (char c : input_string.toCharArray()) {
            if (c != prev) {
                prev = c;

                if (alphabet[c - 'a'])
                    set.add(c);
                else
                    alphabet[c - 'a'] = true;
            }
        }

        if (!set.isEmpty())
            answer = set.stream().map(String::valueOf).collect(Collectors.joining());

        return answer;
    }
}
