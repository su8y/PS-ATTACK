/*
 * 문제: 백준 3048번 - 개미 (https://www.acmicpc.net/problem/3048)
 *
 * 시간 복잡도: O(t * n) - n: 개미의 수
 */

package Baekjoon;

import java.io.*;

public class BOJ_3048_개미 {
    // public class Main {
    private static StringBuilder sb;

    private static void change(int a, int b) {
        char tmp = sb.charAt(a);

        sb.setCharAt(a, sb.charAt(b));
        sb.setCharAt(b, tmp);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] isFirst = new boolean[26];

        br.readLine();
        sb = new StringBuilder(br.readLine()).reverse();

        for (int i = 0; i < sb.length(); i++)
            isFirst[sb.charAt(i) - 'A'] = true;

        sb.append(br.readLine());

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            for (int i = 0; i < sb.length(); i++) {
                if (isFirst[sb.charAt(i) - 'A'] && i < sb.length() - 1 && !isFirst[sb.charAt(i + 1) - 'A']) {
                    char tmp = sb.charAt(i);

                    sb.setCharAt(i, sb.charAt(++i));
                    sb.setCharAt(i, tmp);
                }
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
