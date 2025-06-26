/*
 * 문제: 백준 14928번 - 큰 수 (BIG) (https://www.acmicpc.net/problem/14928)
 *
 * 시간 복잡도: O(l) - l: n의 자릿수
 */

package Baekjoon;

import java.io.*;

public class BOJ_14928_큰수BIG {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();
        long num = 0;

        for (char c : n.toCharArray()) {
            num = (num * 10 + (c - '0')) % 20000303;
        }

        bw.write(Long.toString(num));
        br.close();
        bw.close();
    }
}
