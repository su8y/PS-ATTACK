/*
 * 문제: 백준 23971번 - ZOAC 4 (https://www.acmicpc.net/problem/23971)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_23971_ZOAC4 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken()) + 1;

        h = h / n + (h % n == 0 ? 0 : 1);
        w = w / m + (w % m == 0 ? 0 : 1);

        bw.write(Integer.toString(h * w));
        br.close();
        bw.close();
    }
}
