/*
 * 문제 : 백준 5525번 - IOIOI (https://www.acmicpc.net/problem/5525)
 * 문제풀이
 *  KMP 알고리즘을 사용해서 시간 복잡도를 줄이면 100점을 맞을 수 있음
 */

package Baekjoon;

import java.io.*;

public class BOJ_5525_IOIOI {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder sb = new StringBuilder("I");
        int cnt = 0;

        while (n-- > 0)
            sb.append("OI");

        int[] pi = new int[sb.length()];
        int j = 0;

        for (int i = 1; i < sb.length(); i++) {
            while (j > 0 && sb.charAt(i) != sb.charAt(j))
                j = pi[j - 1];

            if (sb.charAt(i) == sb.charAt(j))
                j++;

            pi[i] = j;
        }

        j = 0;

        for (int i = 0; i < m; i++) {
            while (j > 0 && s.charAt(i) != sb.charAt(j))
                j = pi[j - 1];

            if (s.charAt(i) == sb.charAt(j))
                j++;

            if (j == sb.length()) {
                cnt++;
                j = pi[j - 1];
            }
        }

        bw.write(cnt + "");
        br.close();
        bw.close();
    }
}
