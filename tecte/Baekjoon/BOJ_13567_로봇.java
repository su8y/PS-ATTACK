/*
 * 문제: 백준 13567번 - 로봇 (https://www.acmicpc.net/problem/13567)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_13567_로봇 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int x = 0;
        int y = 0;
        int dir = 0;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            if (flag) {
                continue;
            }

            char cmd = st.nextToken().charAt(0);
            int d = Integer.parseInt(st.nextToken());

            if (cmd == 'M') {
                if ((dir & 1) == 0) {
                    x += dir == 0 ? d : -d;
                } else {
                    y += dir == 1 ? -d : d;
                }

                if (x < 0 || x > m || y < 0 || y > m) {
                    flag = true;
                }
            } else {
                dir = (dir + 4 + (d == 0 ? -1 : 1)) % 4;
            }
        }

        bw.write(flag ? "-1" : x + " " + y);
        br.close();
        bw.close();
    }
}
