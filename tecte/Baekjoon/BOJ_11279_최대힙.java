/*
 * 문제 : 백준 11279번 - 최대 힙 (https://www.acmicpc.net/problem/11279)
 * 문제 풀이
 *  우선순위 큐를 사용하여 품
 *  comparator를 정의하지 않으면 자연 순서로 우선순위가 결정되므로 Collections의 reverseOrder을 사용하여 역순으로 나오게 함
 */

package Baekjoon;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279_최대힙 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0)
                bw.write(queue.isEmpty() ? "0\n" : queue.poll() + "\n");
            else
                queue.offer(x);
        }

        br.close();
        bw.close();
    }
}
