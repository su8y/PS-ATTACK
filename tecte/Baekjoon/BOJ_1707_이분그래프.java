/*
 * 문제 : 백준 1707번 - 이분 그래프 (https://www.acmicpc.net/problem/1707)
 *  모든 정점들을 돌면서 방문했던 정점들은 건너뛰고 방문하지 않았던 정점들을 큐에 넣고 BFS를 함
 *  집합 a, b가 있으면 큐에서 꺼낸 정점을 두 집합중 하나에 넣고 해당 정점과 인접한 정점은 다른 집합에 넣음
 *  만약 인접한 정점이 이미 방문한 정점이라면 인접한 정점이 자신과 같은 집합에 있는지 확인
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707_이분그래프 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[v + 1];
            int[] visited = new int[v + 1];
            Queue<Integer> queue = new LinkedList<>();
            boolean flag = true;

            for (int i = 1; i <= v; i++)
                graph[i] = new ArrayList<>();

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                graph[end].add(start);

            }

            for (int i = 1; i <= v && flag; i++) {
                if (visited[i] == 0) {
                    queue.offer(i);
                    visited[i] = 1;
                } else {
                    continue;
                }

                while (!queue.isEmpty() && flag) {
                    int node = queue.poll();

                    for (int near : graph[node]) {
                        if (visited[near] == 0) {
                            visited[near] = visited[node] % 2 + 1;
                            queue.offer(near);
                        } else if (visited[near] == visited[node]) {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if (flag)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }

        br.close();
        bw.close();
    }
}
