/*
 * 문제: 백준 2342번 - Dance Dance Revolution (https://www.acmicpc.net/problem/2342)
 * 문제 풀이
 *  DP를 이용하여 왼발과 오른발의 각 상태에 대한 최소 값을 갱신.
 *
 * 시간 복잡도: O(n) - n: 지시 사항의 수
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2342_DanceDanceRevolution {
    // public class Main {
    private static int move(int foot, int inst) {
        if (foot == 0) {
            return 2;
        } else if (foot == inst) {
            return 1;
        } else if ((foot + 1) % 4 + 1 == inst) {
            return 4;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] memo = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                memo[i][j] = Integer.MAX_VALUE >> 1;
            }
        }

        memo[0][0] = 0;

        while (true) {
            int inst = Integer.parseInt(st.nextToken());

            if (inst == 0) {
                int result = Integer.MAX_VALUE;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        result = Math.min(result, memo[i][j]);
                    }
                }

                bw.write(Integer.toString(result));
                break;
            }

            int[][] newMemo = new int[5][5];

            for (int i = 0; i < 5; i++) {
                Arrays.fill(newMemo[i], Integer.MAX_VALUE >> 1);
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    int p = move(j, inst);

                    newMemo[i][inst] = Math.min(newMemo[i][inst], memo[i][j] + p);
                    newMemo[inst][i] = Math.min(newMemo[inst][i], memo[j][i] + p);
                }
            }

            memo = newMemo;
        }

        br.close();
        bw.close();
    }
}
