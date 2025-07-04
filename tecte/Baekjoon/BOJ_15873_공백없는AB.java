/*
 * 문제: 백준 15873번 - 공백 없는 A+B (https://www.acmicpc.net/problem/15873)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;

public class BOJ_15873_공백없는AB {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String num = br.readLine();
        int m = num.charAt(1) == '0' ? 2 : 1;
        int a = Integer.parseInt(num.substring(0, m));
        int b = Integer.parseInt(num.substring(m));

        bw.write(Integer.toString(a + b));
        br.close();
        bw.close();
    }
}
