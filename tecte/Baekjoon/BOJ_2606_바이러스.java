/*
 * 문제 : 백준 2606번 - 바이러스 (https://www.acmicpc.net/problem/2606)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2606_바이러스 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Integer>[] graph = new ArrayList[n + 1];
        boolean visited[] = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                    cnt++;
                }
            }
        }

        bw.write(cnt + "");
        br.close();
        bw.close();
    }
}
