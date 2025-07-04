/*
 * 문제: 백준 20125번 - 쿠키의 신체 측정 (https://www.acmicpc.net/problem/20125)
 *
 * 시간 복잡도: O(N^2)
 */

package Baekjoon;

import java.io.*;

public class BOJ_20125_쿠키의신체측정 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] heart = new int[2];
        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;

        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();

            for (int j = 0; j < n; j++) {
                if (row[j] == '_')
                    continue;

                if (heart[0] == 0) {
                    heart[0] = i + 1;
                    heart[1] = j;
                } else if (i == heart[0]) {
                    if (j < heart[1])
                        leftArm++;
                    else if (j > heart[1])
                        rightArm++;
                } else if (j == heart[1]) {
                    waist++;
                } else {
                    if (j < heart[1])
                        leftLeg++;
                    else
                        rightLeg++;
                }
            }
        }

        bw.write((heart[0] + 1) + " " + (heart[1] + 1) + "\n");
        bw.write(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
        br.close();
        bw.close();
    }
}
