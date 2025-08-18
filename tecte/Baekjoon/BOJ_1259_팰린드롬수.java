/*
 * 문제 : 백준 1259번 - 팰린드롬수 (https://www.acmicpc.net/problem/1259)
 */

package Baekjoon;

import java.io.*;

public class BOJ_1259_팰린드롬수 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String num = br.readLine();
            String result = "yes";

            if (num.equals("0"))
                break;

            for (int i = 0; i < num.length() / 2; i++) {
                if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
                    result = "no";
                    break;
                }
            }

            bw.write(result);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
