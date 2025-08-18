/*
 * 문제: 백준 15029 - Cued In (https://www.acmicpc.net/problem/15029)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_15029_CuedIn {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int max = 0;
        int score = 0;

        for (int i = 0; i < n; i++) {
            switch (br.readLine().charAt(2)) {
                case 'd':
                    cnt++;
                    break;
                case 'l':
                    max = Math.max(max, 2);
                    score += 2;
                    break;
                case 'e':
                    max = Math.max(max, 3);
                    score += 3;
                    break;
                case 'o':
                    max = Math.max(max, 4);
                    score += 4;
                    break;
                case 'u':
                    max = Math.max(max, 5);
                    score += 5;
                    break;
                case 'n':
                    max = Math.max(max, 6);
                    score += 6;
                    break;
                case 'a':
                    max = 7;
                    score += 7;
            }
        }


        bw.write(score == 0 ? "1" : Integer.toString(++max * cnt + score));
        br.close();
        bw.close();
    }
}
