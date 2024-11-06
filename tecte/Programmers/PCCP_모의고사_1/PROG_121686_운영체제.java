/*
 * 문제: 프로그래머스 - [PCCP 모의고사 1] 4번 - 운영체제 (https://school.programmers.co.kr/learn/courses/15008/lessons/121686)
 * 문제 풀이
 *  우선순위 큐를 사용하여 호출 시간을 기준으로 삽입된 프로그램을 정렬.
 *  현재 시간보다 이전에 호출된 프로그램을 꺼내서 점수를 기준으로 한 우선순위 큐에 삽입.
 *  이때 호출 시간을 두 번째 기준으로 해야함. 우선순위 큐에서 우선순위가 같은 요소는 삽입된 순서가 보장되지 않음.
 *  점수를 기준으로 한 우선순위 큐에서 프로그램을 하나씩 꺼내서 실행 시간에 따라 시간을 업데이트.
 *  점수 우선순위 큐는 비어있는데 호출 우선순위 큐가 비어있지 않다면 프로그램이 끝나고 다음 프로그램이 호출되기까지 텀이 있는 것임.
 *  이 때는 호출 우선순위 큐의 첫 번째 요소의 호출시간만큼 시간을 업데이트.
 *
 * 시간 복잡도: O(n log n) - n: 프로그램 수
 */

package Programmers.PCCP_모의고사_1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PROG_121686_운영체제 {
    // class Solution {
    public long[] solution(int[][] program) {
        PriorityQueue<int[]> callQ = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[1]));
        PriorityQueue<int[]> scoreQ = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
        long[] time = new long[11];

        for (int[] p : program)
            callQ.offer(p);

        while (true) {
            while (!callQ.isEmpty() && callQ.peek()[1] <= time[0])
                scoreQ.offer(callQ.poll());

            if (scoreQ.isEmpty()) {
                if (callQ.isEmpty())
                    break;
                else
                    time[0] = callQ.peek()[1];
            } else {
                int[] prog = scoreQ.poll();

                time[prog[0]] += time[0] - prog[1];
                time[0] += prog[2];
            }
        }

        return time;
    }
}
