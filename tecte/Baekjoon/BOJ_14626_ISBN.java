/*
 * 문제: 백준 14626번 - ISBN (https://www.acmicpc.net/problem/14626)
 *
 * 시간 복잡도: O(n) - n: ISBN의 길이
 */

package Baekjoon;

import java.io.*;

public class BOJ_14626_ISBN {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String isbn = br.readLine();
        int weight = 0;
        int sum = isbn.charAt(isbn.length() - 1) - '0';

        for (int i = 0; i < isbn.length() - 1; i++) {
            if (isbn.charAt(i) == '*') {
                weight = (i & 1) == 0 ? 1 : 3;
            } else {
                sum += (isbn.charAt(i) - '0') * ((i & 1) == 0 ? 1 : 3);
            }

        }

        for (int i = 0; i < 10; i++) {
            if ((sum + i * weight) % 10 == 0) {
                bw.write(Integer.toString(i));
                break;
            }
        }

        br.close();
        bw.close();
    }
}
