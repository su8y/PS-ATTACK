/*
 * 문제 : 백준 21736번 - 헌내기는 친구가 필요해 (https://www.acmicpc.net/problem/21736)
 * 문제 풀이
 *  DFS로 만날 수 있는 사람의 수를 구함
 */

package Baekjoon;

import java.io.*;

public class BOJ_21736_헌내기는친구가필요해 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        char[][] campus = new char[n][];
        int x = 0;
        int y = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            campus[i] = br.readLine().toCharArray();

            for (int j = 0; j < campus[i].length; j++) {
                if (campus[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        result = dfs(campus, x, y);

        bw.write(result == 0 ? "TT" : result + "");
        br.close();
        bw.close();
    }

    public static int dfs(char[][] campus, int x, int y) {
        if (x < 0 || x >= campus.length || y < 0 || y >= campus[0].length || campus[x][y] == 'X')
            return 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int p = campus[x][y] == 'P' ? 1 : 0;
        campus[x][y] = 'X';

        for (int i = 0; i < 4; i++)
            p += dfs(campus, x + dx[i], y + dy[i]);

        return p;
    }
}
