/*
 * 문제 : 백준 2558번 - 뉴비의 기준은 뭘까? (https://www.acmicpc.net/problem/19944)
 */

package Baekjoon;

import java.io.*;

public class BOJ_19944_뉴비의기준은뭘까 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        if (m == 1 || m == 2) {
            bw.write("NEWBIE!");
        } else if (m <= n) {
            bw.write("OLDBIE!");
        } else {
            bw.write("TLE!");
        }

        br.close();
        bw.close();
    }
}
