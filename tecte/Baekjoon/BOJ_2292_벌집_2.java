/*
 * 문제: 백준 2292번 - 벌집 (https://www.acmicpc.net/problem/2292)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;

public class BOJ_2292_벌집_2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double n = Double.parseDouble(br.readLine());

        bw.write(Integer.toString((int) (Math.sqrt(n / 3 - .1) + 1.5)));
        br.close();
        bw.close();
    }
}
