/*
 * 문제: 백준 14650번 - 걷다보니 신천역 삼 (Small) (https://www.acmicpc.net/problem/14650)
 * 문제 풀이
 *  백트래킹을 사용하여 3의 배수의 개수를 구함.
 *
 * 시간 복잡도: O(3ⁿ)
 */

package baekjoon.workbook1.chapter4.section6;

import java.io.*;

public class BOJ_14650_걷다보니신천역삼Small {
    // public class Main {
    private static int n, cnt;

    private static void backtracking(int depth, int num) {
        if (depth == n) {
            if (num % 3 == 0) {
                cnt++;
            }

            return;
        }

        for (int i = depth == 0 ? 1 : 0; i < 3; i++) {
            backtracking(depth + 1, num * 10 + i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        backtracking(0, 0);
        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
