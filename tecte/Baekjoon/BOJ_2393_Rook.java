/*
 * 문제: 백준 2393번 - Rook (https://www.acmicpc.net/problem/2393)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;

public class BOJ_2393_Rook {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("  ___  ___  ___\n" +
                "  | |__| |__| |\n" +
                "  |           |\n" +
                "   \\_________/\n" +
                "    \\_______/\n" +
                "     |     |\n" +
                "     |     |\n" +
                "     |     |\n" +
                "     |     |\n" +
                "     |_____|\n" +
                "  __/       \\__\n" +
                " /             \\\n" +
                "/_______________\\");
        br.close();
        bw.close();
    }
}
