/*
 * 문제: 백준 14889번 - 스타트와 링크 (https://www.acmicpc.net/problem/14889)
 * 문제 풀이
 *  모든 팀의 구성을 조합하고 각 조합의 능력치 차이를 계산해서 능력치 차가 최소인 값을 구함.
 *
 * 시간 복잡도: O(2^n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_14889_스타트와링크 {
    // public class Main {
    private static int n, diff;
    private static int[][] stat;
    private static boolean[] team;

    private static int getDiff() {
        int a = 0;
        int b = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (team[i] != team[j])
                    continue;

                if (team[i])
                    a += stat[i][j];
                else
                    b += stat[i][j];
            }
        }

        return Math.abs(a - b);
    }

    private static void dfs(int depth) {
        if (depth < 0)
            return;

        team[depth] = false;

        for (int i = depth + 1; i < n; i++) {
            if (team[i])
                break;

            team[i] = true;
            diff = Math.min(diff, getDiff());
            dfs(depth - 1);
            team[i] = false;
        }

        team[depth] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        stat = new int[n][];
        team = new boolean[n];

        for (int i = 0; i < n; i++)
            stat[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n >> 1; i++)
            team[i] = true;

        diff = getDiff();
        dfs((n >> 1) - 1);
        bw.write(Integer.toString(diff));
        br.close();
        bw.close();
    }
}
