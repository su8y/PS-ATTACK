/*
 * 문제 : 백준 2338번 - 긴자리 계산 (https://www.acmicpc.net/problem/2338)
 */

package Baekjoon;

import java.io.*;
import java.math.BigInteger;

public class BOJ_2338_긴자리계산 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        bw.write(a.add(b)+"\n");
        bw.write(a.subtract(b)+"\n");
        bw.write(a.multiply(b).toString());
        br.close();
        bw.close();
    }
}
