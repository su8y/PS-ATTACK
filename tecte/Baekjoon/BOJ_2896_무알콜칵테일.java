/*
 * 문제: 백준 2896번 - 무알콜 칵테일 (https://www.acmicpc.net/problem/2896)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2896_무알콜칵테일 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double i = Double.parseDouble(st.nextToken());
        double j = Double.parseDouble(st.nextToken());
        double k = Double.parseDouble(st.nextToken());
        double ratio = Math.min(a / i, Math.min(b / j, c / k));
        StringBuilder sb = new StringBuilder();

        sb.append(a - ratio * i).append(" ").append(b - ratio * j).append(" ").append(c - ratio * k);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
