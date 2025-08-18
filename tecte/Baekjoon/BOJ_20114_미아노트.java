/*
 * 문제: 백준 20114번 - 미아 노트 (https://www.acmicpc.net/problem/20114)
 *
 * 시간 복잡도: O(h * n * w)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_20114_미아노트 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append("?");
        }

        for (int i = 0; i < h; i++) {
            StringBuilder str = new StringBuilder(br.readLine());

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) != '?') {
                    sb.setCharAt(j / w, str.charAt(j));
                }
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
