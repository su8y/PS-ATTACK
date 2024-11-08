/*
 * 문제: 백준 2607번 - 비슷한 단어 (https://www.acmicpc.net/problem/2607)
 *
 * 시간 복잡도: O(n * m) - n: 단어의 개수, m: 단어의 길이
 */

package Baekjoon;

import java.io.*;

public class BOJ_2607_비슷한단어 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        String word = br.readLine();
        int cnt = 0;

        for (int c : word.toCharArray())
            alphabet[c - 'A']++;

        for (int i = 1; i < n; i++) {
            String w = br.readLine();
            int[] wa = new int[26];
            int diff = word.length() == w.length() ? 2 : 1;

            if (w.length() < word.length() - 1 || w.length() > word.length() + 1)
                continue;

            for (int c : w.toCharArray())
                wa[c - 'A']++;

            for (int j = 0; j < 26; j++) {
                diff -= Math.abs(alphabet[j] - wa[j]);
            }

            if (diff >= 0)
                cnt++;
        }

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
