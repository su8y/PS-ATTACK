/*
 * 문제: 백준 14724번 - 관리자는 누구? (https://www.acmicpc.net/problem/14724)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14724_관리자는누구 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] club = {"PROBRAIN", "GROW", "ARGOS", "ADMIN", "ANT", "MOTION", "SPG", "COMON", "ALMIGHTY"};
        int max = 0;
        int manager = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int cnt = Integer.parseInt(st.nextToken());

                if (cnt > max) {
                    max = cnt;
                    manager = i;
                }
            }
        }

        bw.write(club[manager]);
        br.close();
        bw.close();
    }
}
