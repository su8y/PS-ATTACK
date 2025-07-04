/*
 * 문제: 백준 30492번 - Democratic Naming (https://www.acmicpc.net/problem/30492)
 *
 * 시간 복잡도: O(n * m)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_30492_DemocraticNaming {
    // public class Main {
    private static class Alphabet {
        char alphabet;
        int cnt = 0;

        public Alphabet(char alphabet) {
            this.alphabet = alphabet;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder[] names = new StringBuilder[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            names[i] = new StringBuilder(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            Alphabet[] alphabets = new Alphabet[26];

            for (int j = 0; j < 26; j++) {
                alphabets[j] = new Alphabet((char) (j + 'a'));
            }

            for (int j = 0; j < n; j++) {
                alphabets[names[j].charAt(i) - 'a'].cnt++;
            }

            Arrays.sort(alphabets, Comparator.comparingInt((Alphabet a) -> -a.cnt).thenComparingInt(a -> a.alphabet));
            sb.append(alphabets[0].alphabet);
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
