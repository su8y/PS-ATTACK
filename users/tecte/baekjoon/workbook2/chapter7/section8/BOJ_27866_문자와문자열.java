/*
 * 문제: 백준 27866번 - 문자와 문자열 (https://www.acmicpc.net/problem/27866)
 *
 * 시간 복잡도: O(n) - n: 문자열의 길이
 */

package baekjoon.workbook2.chapter7.section8;

import java.io.*;

public class BOJ_27866_문자와문자열 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());

        bw.write(s.charAt(i - 1) + "");
        br.close();
        bw.close();
    }
}
