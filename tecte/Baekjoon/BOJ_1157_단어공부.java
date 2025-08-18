/*
 * 문제: 백준 1157번 - 단어 공부 (https://www.acmicpc.net/problem/1157)
 *
 * 시간 복잡도: O(n) - n: 문자열의 길이
 */

package Baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1157_단어공부 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        Map<Character, Integer> alphabet = new HashMap<>();
        char key = 0;
        int value = 0;

        for (char c : str.toCharArray()) {
            c = Character.toUpperCase(c);
            alphabet.put(c, alphabet.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : alphabet.entrySet()) {
            if (entry.getValue() >= value) {
                key = entry.getValue() == value ? '?' : entry.getKey();
                value = entry.getValue();
            }
        }

        bw.write(Character.toString(key));
        br.close();
        bw.close();
    }
}
