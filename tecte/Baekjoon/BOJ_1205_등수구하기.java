/*
 * 문제: 백준 1205번 - 등수 구하기 (https://www.acmicpc.net/problem/1205)
 * 문제 풀이
 *  태수의 점수와 랭킹 1~n등 점수를 비교하며 태수의 등수 갱신.
 *
 * 시간 복잡도: O(N)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1205_등수구하기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int rank = 1;

        if (n != 0)
            st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int s = Integer.parseInt(st.nextToken());

            if (s < score) {
                break;
            } else if (i == p) {
                rank = -1;
                break;
            } else if (s > score) {
                rank = i + 1;
            }
        }

        bw.write(Integer.toString(rank));
        br.close();
        bw.close();
    }
}
