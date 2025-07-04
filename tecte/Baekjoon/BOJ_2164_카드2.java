/*
 * 문제: 백준 2164번 - 카드2 (https://www.acmicpc.net/problem/2164)
 *
 * 시간 복잡도: O(N)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++)
            queue.offer(i);

        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        bw.write(queue.poll() + "");

        br.close();
        bw.close();
    }
}
