/*
 * 문제: 백준 15678번 - 연세워터파크 (https://www.acmicpc.net/problem/15678)
 * 문제 풀이
 *  슬라이딩 윈도우와 덱을 사용하여 d칸 이내 범위에서의 최대 누적합을 구함.
 *  각 위치를 마지막으로 하는 최대 누적합을 계산.
 *  덱의 앞에서 범위를 벗어난 값을 제거하고 덱의 뒤에서 현재 값보다 작은 값을 제거하여 덱이 단조 감소하도록 함.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_15678_연세워터파크_2 {
    // public class Main {
    private static class Node {
        int i;
        long v;

        public Node(int i, long v) {
            this.i = i;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Deque<Node> deque = new ArrayDeque<>();
        long max = Long.MIN_VALUE;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst().i < i - d) {
                deque.pollFirst();
            }

            long s = Long.parseLong(st.nextToken()) + Math.max(0, (deque.isEmpty() ? 0 : deque.peekFirst().v));

            while (!deque.isEmpty() && deque.peekLast().v < s) {
                deque.pollLast();
            }

            deque.offerLast(new Node(i, s));
            max = Math.max(max, s);
        }

        bw.write(Long.toString(max));
        br.close();
        bw.close();
    }
}
