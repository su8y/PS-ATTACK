/*
 * 문제 : 백준 11286번 - 절댓값 힙 (https://www.acmicpc.net/problem/11286)
 * 문제 풀이
 *  우선순위 큐를 사용하여 품. Comparator를 활용해 두 가지 기준으로 정렬
 */

package Baekjoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값힙 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt((Integer a) -> Math.abs(a)).thenComparingInt(a -> a));

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
