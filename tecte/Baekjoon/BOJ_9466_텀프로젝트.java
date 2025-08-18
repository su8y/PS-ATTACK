/*
 * 문제: 백준 9466번 - 텀 프로젝트 (https://www.acmicpc.net/problem/9466)
 * 문제 풀이
 *  DFS를 통해 사이클을 형성하지 못한 학생들의 수를 구함.
 *
 * 시간 복잡도: O(t * n)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9466_텀프로젝트 {
    // public class Main {
    private static int cnt;
    private static int[] students;
    private static boolean[] visited, finished;

    private static int dfs(int student) {
        if (finished[student]) {
            return -1;
        } else if (visited[student]) {
            return student;
        }

        int s;

        visited[student] = true;
        s = dfs(students[student]);
        finished[student] = true;

        if (s == -1) {
            cnt++;
        } else if (s == student) {
            s = -1;
        }

        return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            cnt = 0;
            students = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
