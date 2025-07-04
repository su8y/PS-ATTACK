/*
 * 문제: 백준 1260번 - DFS와 BFS (https://www.acmicpc.net/problem/1260)
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[n + 1][n + 1];
        boolean[] sVisited = new boolean[n + 1];
        boolean[] qVisited = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sResult = new StringBuilder();
        StringBuilder qResult = new StringBuilder();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s][e] = true;
            graph[e][s] = true;
        }

        stack.push(v);
        queue.offer(v);

        while (!stack.isEmpty()) {
            int sv = stack.pop();
            int qv = queue.poll();

            if (!sVisited[sv]) {
                sVisited[sv] = true;
                sResult.append(sv).append(" ");
            }

            if (!qVisited[qv]) {
                qVisited[qv] = true;
                qResult.append(qv).append(" ");
            }

            for (int i = 0; i < n; i++) {
                if (graph[sv][n - i] && !sVisited[n - i]) {
                    stack.push(n - i);
                }

                if (graph[qv][i + 1] && !qVisited[i + 1]) {
                    queue.offer(i + 1);
                }
            }
        }

        bw.write(sResult.toString());
        bw.newLine();
        bw.write(qResult.toString());
        br.close();
        bw.close();
    }
}
