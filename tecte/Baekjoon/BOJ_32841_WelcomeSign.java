/*
 * 문제: 백준 32841번 - Welcome Sign (https://www.acmicpc.net/problem/32841)
 *
 * 시간 복잡도: O(r * c)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_32841_WelcomeSign {
    // public class Main {
    private static StringBuilder sb = new StringBuilder();

    private static void append(char c, int cnt) {
        for (int i = 0; i < cnt; i++) {
            sb.append(c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        boolean flag = false;

        for (int i = 1; i <= r; i++) {
            String str = br.readLine();
            int empty = c - str.length();
            int left = empty >> 1;
            int right = left;

            if ((empty & 1) != 0) {
                if (flag) {
                    left++;
                } else {
                    right++;
                }

                flag = !flag;
            }

            append('.', left);
            sb.append(str);
            append('.', right);
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
