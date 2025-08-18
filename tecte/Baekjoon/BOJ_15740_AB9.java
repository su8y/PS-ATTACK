/*
 * 문제 : 백준 15740번 - A+B - 9 (https://www.acmicpc.net/problem/15740)
 */

package Baekjoon;

import java.io.*;
import java.math.BigInteger;

public class BOJ_15740_AB9 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] num = br.readLine().split(" ");
        BigInteger a = new BigInteger(num[0]);
        BigInteger b = new BigInteger(num[1]);

        bw.write(a.add(b).toString());
        br.close();
        bw.close();
    }
}
