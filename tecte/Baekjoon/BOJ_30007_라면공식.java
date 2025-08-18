/*
 * 문제: 백준 30007번 - 라면 공식 (https://www.acmicpc.net/problem/30007)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_30007_라면공식 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            bw.write(Integer.toString((x - 1) * a + b));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
