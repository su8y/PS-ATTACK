/*
 * 문제: 백준 2448번 - 별 찍기 - 11 (https://www.acmicpc.net/problem/2448)
 * 문제 풀이
 *  k번만큼 재귀를 함. 마지막 재귀에서는 가장 작은 삼각형은 반환.
 *  반환받은 삼각형을 옆과 위에 추가해서 더 큰 삼각형을 만들어서 반환.
 *
 * 시간 복잡도: O(2^k)
 */

package Baekjoon;

import java.io.*;

public class BOJ_2448_별찍기11 {
    // public class Main {
    static String[] star(int n) {
        String[] str = new String[3];

        if (n == 0) {
            str[0] = "  *  ";
            str[1] = " * * ";
            str[2] = "*****";
        } else if (n > 0) {
            String[] s = star(n - 1);
            str = new String[s.length * 2];
            StringBuilder blank = new StringBuilder();

            for (int i = 0; i < s[0].length() / 2 + 1; i++)
                blank.append(" ");

            for (int i = 0; i < s.length; i++)
                str[i] = blank + s[i] + blank;

            for (int i = 0; i < s.length; i++)
                str[i + s.length] = s[i] + " " + s[i];
        } else {
            str[0] = "     ";
            str[1] = "     ";
            str[2] = "     ";
        }

        return str;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] str = star(Integer.numberOfTrailingZeros(n / 3));

        for (String s : str) {
            bw.write(s);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
