/*
 * 문제: 백준 10039번 - 평균 점수 (https://www.acmicpc.net/problem/10039)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;

public class BOJ_10039_평균점수 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;

        for (int i = 0; i < 5; i++)
            sum += Math.max(Integer.parseInt(br.readLine()), 40);

        bw.write(Integer.toString(sum / 5));
        br.close();
        bw.close();
    }
}
