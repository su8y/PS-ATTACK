/*
 * 문제: 백준 5522번 - 카드 게임 (https://www.acmicpc.net/problem/5522)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;

public class BOJ_5522_카드게임 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = 0;

        for (int i = 0; i < 5; i++)
            total += Integer.parseInt(br.readLine());

        bw.write(Integer.toString(total));
        br.close();
        bw.close();
    }
}
