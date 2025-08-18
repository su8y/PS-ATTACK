/*
 * 문제: 백준 6169번 - Long Distance Racing (https://www.acmicpc.net/problem/6169)
 *
 * 시간 복잡도: O(t)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_6169_LongDistanceRacing {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int dist = 0;
        int time = 0;

        for (int i = 0; i < t; i++) {
            time += br.readLine().charAt(0) == 'f' ? f << 1 : u + d;

            if (time <= m) {
                dist++;
            }
        }

        bw.write(Integer.toString(dist));
        br.close();
        bw.close();
    }
}
