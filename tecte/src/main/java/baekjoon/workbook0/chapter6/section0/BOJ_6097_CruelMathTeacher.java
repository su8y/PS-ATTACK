/*
 * 문제: 백준 6097번 - Cruel Math Teacher (https://www.acmicpc.net/problem/6097)
 *
 * 시간 복잡도: O(log n * k²) - k: nᵖ의 자릿수
 */

package baekjoon.workbook0.chapter6.section0;

import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ_6097_CruelMathTeacher {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(st.nextToken()).pow(Integer.parseInt(st.nextToken()));
        StringBuilder sb = new StringBuilder(n.toString());
        int len = sb.length();
        int size = 70;

        for (int i = 0; i < len; i += size) {
            bw.write(sb.substring(i, Math.min(i + size, len)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
