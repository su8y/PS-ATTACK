/*
 * 문제: 백준 1094번 - 막대기 (https://www.acmicpc.net/problem/1094)
 * 문제 풀이
 *  막대를 절반씩 나누는 과정은 이진수 변환과 동일한 의미를 가지므로 막대의 최소 개수는 이진수에서 1의 개수와 같음.
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;

public class BOJ_1094_막대기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(Integer.bitCount(x)));
        br.close();
        bw.close();
    }
}
