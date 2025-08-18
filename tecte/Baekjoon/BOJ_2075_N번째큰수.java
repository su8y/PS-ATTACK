/*
 * 문제: 백준 2075번 - N번째 큰 수 (https://www.acmicpc.net/problem/2075)
 *
 * 시간 복잡도: O(n^2 log n)
 */

package Baekjoon;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075_N번째큰수 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++)
                queue.offer(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < n; i++)
            queue.poll();

        bw.write(Integer.toString(queue.poll()));
        br.close();
        bw.close();
    }
}
