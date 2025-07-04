/*
 * 문제: 백준 20959번 - Šifra (https://www.acmicpc.net/problem/20959)
 *
 * 시간 복잡도: O(n) - n: 문자열의 길이
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_20959_Sifra {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), "abcdefghijklmnopqrstuvwxyz");
        Set<Integer> set = new HashSet<>();

        while (st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(Integer.toString(set.size()));
        br.close();
        bw.close();
    }
}
