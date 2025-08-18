/*
 * 문제: 백준 2252번 - 줄 세우기 (https://www.acmicpc.net/problem/2252)
 * 문제 풀이
 *  일부 학생들의 키를 비교한 결과를 방향 그래프로 변환한 후 위상 정렬을 이용하여 줄을 세운 결과를 구함.
 *
 * 시간 복잡도: O(n + m)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2252_줄세우기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        int[] inDegree = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
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
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int student = queue.poll();

            sb.append(student).append(" ");

            for (int next : graph.get(student)) {
                if (--inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
