/*
 * 문제 : 백준 31656번 - Sticky Keys (https://www.acmicpc.net/problem/31656)
 */

package Baekjoon;

import java.io.*;

public class BOJ_31656_StickyKeys {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        char previous = 0;

        for (char c : str.toCharArray()) {
            if (previous != c) {
                sb.append(c);
                previous = c;
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
