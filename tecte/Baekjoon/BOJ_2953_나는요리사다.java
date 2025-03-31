/*
 * 문제: 백준 2953번 - 나는 요리사다 (https://www.acmicpc.net/problem/2953)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2953_나는요리사다 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int idx = 0;
        int max = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;

            for (int j = 0; j < 4; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            if (sum > max) {
                idx = i;
                max = sum;
            }
        }

        bw.write(sb.append(idx).append(" ").append(max).toString());
        br.close();
        bw.close();
    }
}
