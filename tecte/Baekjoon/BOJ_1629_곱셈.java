/*
 * 문제 : 백준 1629번 - 곱셈 (https://www.acmicpc.net/problem/1629)
 */

package Baekjoon;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        BigInteger c = new BigInteger(st.nextToken());

        bw.write(a.modPow(b, c).toString());
        br.close();
        bw.close();
    }
}
