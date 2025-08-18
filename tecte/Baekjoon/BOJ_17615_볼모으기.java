/*
 * 문제: 백준 17615번 - 볼 모으기 (https://www.acmicpc.net/problem/17615)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_17615_볼모으기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String balls;
        int blueLeft = 0;
        int blueRight = 0;
        int redLeft = 0;
        int redRight = 0;
        int blueCnt = 0;
        int redCnt = 0;

        br.readLine();
        balls = br.readLine();

        for (char ball : balls.toCharArray()) {
            if (ball == 'R') {
                if (blueCnt != 0) {
                    blueRight += blueCnt;
                    blueCnt = 0;
                }

                if (blueRight != 0)
                    redLeft++;

                redCnt++;
            } else {
                if (redCnt != 0) {
                    redRight += redCnt;
                    redCnt = 0;
                }

                if (redRight != 0)
                    blueLeft++;

                blueCnt++;
            }
        }

        bw.write(Integer.toString(Math.min(Math.min(blueLeft, blueRight), Math.min(redLeft, redRight))));
        br.close();
        bw.close();
    }
}
