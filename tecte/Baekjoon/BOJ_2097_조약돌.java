/*
 * 문제: 백준 2097번 - 조약돌 (https://www.acmicpc.net/problem/2097)
 * 문제 풀이
 *  조약돌을 정사각형 형태일 때 가장 많이 가질 수 있음.
 *  정사각형의 둘레는 4의 배수이고, 직사각형의 둘레는 짝수이므로 각 정사각형의 사이에는 하나의 직사각형만 있음.
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;

public class BOJ_2097_조약돌 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        if (n < 3) {
            bw.write("4");
        } else {
            int r = (int) Math.round(Math.sqrt(n));

            bw.write(Integer.toString(r * r < n ? (r << 2) - 2 : (r - 1) << 2));
        }

        br.close();
        bw.close();
    }
}
