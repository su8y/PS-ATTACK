/*
 * 문제: 백준 14888번 - 연산자 끼워넣기 (https://www.acmicpc.net/problem/14888)
 * 문제 풀이
 *  백트래킹으로 모든 연산자 조합을 탐색하여 최솟값과 최대값을 구함.
 *
 * 시간 복잡도: O(4^n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_14888_연산자끼워넣기 {
    // public class Main {
    private static int n;
    private static int[] seq, op;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    private static void dfs(int depth, int num) {
        if (depth == n) {
            min = Math.min(min, num);
            max = Math.max(max, num);

            return;
        }

        depth++;

        if (op[0] > 0) {
            op[0]--;
            dfs(depth, num + seq[depth]);
            op[0]++;
        }

        if (op[1] > 0) {
            op[1]--;
            dfs(depth, num - seq[depth]);
            op[1]++;
        }

        if (op[2] > 0) {
            op[2]--;
            dfs(depth, num * seq[depth]);
            op[2]++;
        }

        if (op[3] > 0) {
            int div = num < 0 ? Math.abs(num) / seq[depth] * -1 : num / seq[depth];

            op[3]--;
            dfs(depth, div);
            op[3]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine()) - 1;
        seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dfs(0, seq[0]);
        bw.write(max + "\n" + min);
        br.close();
        bw.close();
    }
}
