/*
 * 문제: 백준 25904번 - 안녕 클레오파트라 세상에서 제일가는 포테이토칩 (https://www.acmicpc.net/problem/25904)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_25904_안녕클레오파트라세상에서제일가는포테이토칩 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] voices = new int[n];
        int pos = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            voices[i] = Integer.parseInt(st.nextToken());
        }

        while (voices[pos++] >= x) {
            pos %= n;
            x++;
        }

        bw.write(Integer.toString(pos));
        br.close();
        bw.close();
    }
}
