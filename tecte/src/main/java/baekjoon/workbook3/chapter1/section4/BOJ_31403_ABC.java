/*
 * 문제: 백준 31403번 - A+B-C (https://www.acmicpc.net/problem/31403)
 *
 * 시간 복잡도: O(1)
 */

package baekjoon.workbook3.chapter1.section4;

import java.io.*;

public class BOJ_31403_ABC {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        bw.write(Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c) + "");
        bw.newLine();
        bw.write(Integer.parseInt(a + b) - Integer.parseInt(c) + "");
        br.close();
        bw.close();
    }
}
