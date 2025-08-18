/*
 * 문제: 백준 2292번 - 벌집 (https://www.acmicpc.net/problem/2292)
 * 문제 풀이
 *  층이 늘어날수록 방이 6, 12, 18, ... 6의 배수만큼 늘어남.
 *
 * 시간 복잡도: O(√n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_2292_벌집_1 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int room = 1;
        int cnt = 1;

        while (room < n)
            room += cnt++ * 6;

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
