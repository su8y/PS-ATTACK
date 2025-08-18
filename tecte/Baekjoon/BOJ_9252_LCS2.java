/*
 * 문제: 백준 9252번 - LCS 2 (https://www.acmicpc.net/problem/9252)
 * 문제 풀이
 *  DP로 LCS를 구함.
 *  i 번째 문자와 j 번째 문자가 같으면 memo[i-1][j-1]+1로 갱신하고 다르면 memo[i-1][j]와 memo[i][j-1] 중에 큰 값으로 갱신.
 *  메모이제이션한 배열을 역추적하면 LCS 문자열을 구할 수 있음.
 *  i 번째 문자와 j 번째 문자가 같으면 LCS 문자열 앞에 추가하고 i-1, j-1로 이동, 다르면 더 큰 값이 있는 방향으로 이동.
 *
 * 시간 복잡도: O(x * y) - x: 첫 번째 문자열의 길이, y: 두 번째 문자열의 길이
 */

package Baekjoon;

import java.io.*;

public class BOJ_9252_LCS2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        int x = a.length;
        int y = b.length;
        int[][] memo = new int[x + 1][y + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                memo[i + 1][j + 1] = a[i] == b[j] ? memo[i][j] + 1 : Math.max(memo[i + 1][j], memo[i][j + 1]);
            }
        }

        while (true) {
            if (a[x - 1] == b[y - 1]) {
                sb.insert(0, a[x - 1]);
                x--;
                y--;
            } else if (memo[x - 1][y] > memo[x][y - 1]) {
                x--;
            } else {
                y--;
            }

            if (x == 0 || y == 0) {
                break;
            }
        }

        bw.write(sb.insert(0, "\n").insert(0, memo[a.length][b.length]).toString());
        br.close();
        bw.close();
    }
}
