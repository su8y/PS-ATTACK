/*
 * 문제 : 백준 11866번 - 요세푸스 문제 0 (https://www.acmicpc.net/problem/11866)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866_요세푸스문제0 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++)
            queue.offer(i);

        int cnt = 1;
        StringBuilder sb = new StringBuilder("<");

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (cnt == k) {
                cnt = 1;
                sb.append(now).append(", ");
            } else {
                queue.offer(now);
                cnt++;
            }
        }

        sb.replace(sb.length() - 2, sb.length(), ">");
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
