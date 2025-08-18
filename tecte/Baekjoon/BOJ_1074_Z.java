/*
 * 문제 : 백준 1074번 - Z (https://www.acmicpc.net/problem/1074)
 * 문제 풀이
 *  r과 c를 2로 나눈 나머지에 따라 배열을 4등분 했을 때 어느 부분인지를 알 수 있음.
 *  어느 부분인지에 따라 현재 크기에서 값을 빼야함. 처음 크기는 2^n * 2^n
 *  나머지가 0, 0일 때는 2^n * 2^n / 4 * 3을, 0, 1일 때는 2^n * 2^n / 4 * 2
 *  나머지가 1, 0일 때는 2^n * 2^n / 4 * 1을, 1, 1일 때는 2^n * 2^n / 4 * 0을 현재 크기에서 빼주면 됨
 *  이 과정을 n번 반복
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(z(r, c, n, 1) - 1 + "");
        br.close();
        bw.close();
    }

    public static int z(int x, int y, int n, int call) {
        if (call > n)
            return (int) Math.pow(2, n * 2);

        int num = z(x / 2, y / 2, n, call + 1);
        int modX = x % 2;
        int modY = y % 2;
        int size = (int) Math.pow(2, call * 2);

        if (modX == 0 && modY == 0) {
            num -= size / 4 * 3;
        } else if (modX == 0 && modY == 1) {
            num -= size / 4 * 2;
        } else if (modX == 1 && modY == 0) {
            num -= size / 4;
        }

        return num;
    }
}
