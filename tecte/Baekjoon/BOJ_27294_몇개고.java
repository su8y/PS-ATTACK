/*
 * 문제: 백준 27294번 - 몇개고? (https://www.acmicpc.net/problem/27294)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_27294_몇개고 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        bw.write(t >= 12 && t <= 16 && s == 0 ? "320" : "280");
        br.close();
        bw.close();
    }
}
