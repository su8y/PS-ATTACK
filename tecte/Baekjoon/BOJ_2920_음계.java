/*
 * 문 제 : 백준 2920번 - 음계 (https://www.acmicpc.net/problem/2920)
 */

package Baekjoon;

import java.io.*;

public class BOJ_2920_음계 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String result = "mixed";

        if (input.equals("1 2 3 4 5 6 7 8"))
            result = "ascending";
        else if (input.equals("8 7 6 5 4 3 2 1"))
            result = "descending";

        bw.write(result);

        br.close();
        bw.close();
    }
}
