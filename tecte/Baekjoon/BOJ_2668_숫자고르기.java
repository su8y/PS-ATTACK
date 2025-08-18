/*
 * 문제: 백준 2668번 - 숫자고르기 (https://www.acmicpc.net/problem/2668)
 * 문제 풀이
 *  1부터 n까지 dfs로 돌면서 dfs를 시작한 숫자로 돌아오면 dfs를 돌면서 방문한 숫자들을 뽑음.
 *  반면 시작한 숫자로 돌아오지 못하고 중간에 방문했던 숫자가 있으면 해당 숫자들을 뽑지 않음.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_2668_숫자고르기 {
    // public class Main {
    static int[] nums;
    static boolean[] visited;

    static boolean dfs(int origin, int num) {
        if (visited[num])
            return false;

        visited[num] = true;

        if (origin == num || dfs(origin, nums[num]))
            return true;

        return visited[num] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringBuilder sb = new StringBuilder("\n");

        nums = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++)
            nums[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++)
            dfs(i, nums[i]);

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                sb.append(i).append("\n");
                cnt++;
            }
        }

        sb.insert(0, cnt);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
