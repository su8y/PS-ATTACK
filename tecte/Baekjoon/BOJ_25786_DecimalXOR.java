/*
 * 문제: 백준 25786번 - Decimal XOR (https://www.acmicpc.net/problem/25786)
 *
 * 시간 복잡도: O(n) - n: 두 수 중에서 더 큰 수의 자릿수
 */

package Baekjoon;

import java.io.*;

public class BOJ_25786_DecimalXOR {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder a = new StringBuilder(br.readLine());
        StringBuilder b = new StringBuilder(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = Math.max(a.length(), b.length()); i > 0; i--) {
            int aDigit = i > a.length() ? 0 : a.charAt(a.length() - i) - '0';
            int bDigit = i > b.length() ? 0 : b.charAt(b.length() - i) - '0';

            sb.append((aDigit <= 2 && bDigit <= 2) || (aDigit >= 7 && bDigit >= 7) ? 0 : 9);
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
