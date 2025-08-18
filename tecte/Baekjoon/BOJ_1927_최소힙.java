/*
 * 문제: 백준 1927번 - 최소 힙 (https://www.acmicpc.net/problem/1927)
 * 문제 풀이
 *  PriorityQueue(우선순위 큐)로 품
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ_1927_최소힙 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                bw.write(queue.isEmpty() ? "0" : queue.poll() + "");
                bw.newLine();
            } else {
                queue.offer(x);
            }
        }

        br.close();
        bw.close();
    }
}
