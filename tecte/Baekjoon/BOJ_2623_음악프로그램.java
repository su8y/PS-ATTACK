/*
 * 문제: 백준 2623번 - 음악프로그램 (https://www.acmicpc.net/problem/2623)
 * 문제 풀이
 *  위상 정렬을 사용하여 전체 가수의 순서를 정함.
 *
 * 시간 복잡도: O(n + e) - e: 보조 PD들이 제안 순서의 총 수
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2623_음악프로그램 {
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
            int k = Integer.parseInt(st.nextToken());
            int prev;

            if (k == 0) {
                continue;
            } else {
                prev = Integer.parseInt(st.nextToken());
                k--;
            }

            while (k-- > 0) {
                int next = Integer.parseInt(st.nextToken());

                graph.get(prev).add(next);
                inDegree[next]++;
                prev = next;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                sb = new StringBuilder("0");
                break;
            }

            int singer = queue.poll();

            sb.append(singer).append("\n");

            for (int next : graph.get(singer)) {
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
