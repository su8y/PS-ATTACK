/*
 * 문제: 백준 30458번 - 팰린드롬 애너그램 (https://www.acmicpc.net/problem/30458)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_30458_팰린드롬애너그램 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] alphabet = new int[26];

        for (int i = 0; i < n; i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        if ((n & 1) == 1) {
            alphabet[s.charAt(n >> 1) - 'a']--;
        }

        bw.write(Arrays.stream(alphabet).anyMatch(c -> (c & 1) == 1) ? "No" : "Yes");
        br.close();
        bw.close();
    }
}
