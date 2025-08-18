/*
 * 문제 : 백준 5554번 - 심부름 가는 길 (https://www.acmicpc.net/problem/5554)
 */

package Baekjoon;

import java.io.*;

public class BOJ_5554_심부름가는길 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int time = 0;

        for (int i = 0; i < 4; i++)
            time += Integer.parseInt(br.readLine());

        bw.write(time / 60 + "\n");
        bw.write(time % 60 + "");
        br.close();
        bw.close();
    }
}
