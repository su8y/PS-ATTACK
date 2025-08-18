/*
 * 문제: 백준 1766번 - 문제집 (https://www.acmicpc.net/problem/1766)
 * 문제 풀이
 *  문제 간의 선행 관계를 방향 그래프로 나타냄.
 *  우선순위 큐를 사용하여 문제 번호가 작은 순서대로 위상 정렬을 함.
 *
 * 시간 복잡도: O((n + m) log n)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766_문제집 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        int[] inDegree = new int[n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            inDegree[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int problem = pq.poll();

            sb.append(problem).append(" ");

            for (int next : graph.get(problem)) {
                if (--inDegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
