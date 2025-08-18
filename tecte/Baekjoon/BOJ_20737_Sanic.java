/*
 * 문제: 백준 20737번 - Sanic (https://www.acmicpc.net/problem/20737)
 * 문제 풀이
 *  루프의 반지름을 r, Sanic의 반지름을 x, 회전 수를 y라고 했을 때
 *  Sanic이 루프를 내접하여 회전하므로 루프의 길이가 아닌 Sanic의 중심을 기준으로 궤적을 계산하고 회전 수를 구해야 함.
 *  2π * (r-x) = 2π * x * y 이므로 y = r/x - 1
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;

public class BOJ_20737_Sanic {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double r = Double.parseDouble(br.readLine());

        bw.write(Double.toString(r - 1));
        br.close();
        bw.close();
    }
}
