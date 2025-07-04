/*
 * 문제: 백준 20437번 - 문자열 게임 2 (https://www.acmicpc.net/problem/20437)
 * 문제 풀이
 *  각 알파벳이 등장한 인덱스를 리스트에 저장하여 k번 이상 등장한 알파벳을 슬라이딩 윈도우로 최소 길이와 최대 길이를 구함.
 *
 * 시간 복잡도: O(t * w)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_20437_문자열게임2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            char[] w = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                bw.write("1 1\n");
                continue;
            }

            List<List<Integer>> alphabet = new ArrayList<>(26);
            int min = Integer.MAX_VALUE;
            int max = 0;

            for (int i = 0; i < 26; i++)
                alphabet.add(new ArrayList<>());

            for (int i = 0; i < w.length; i++)
                alphabet.get(w[i] - 'a').add(i);

            for (int i = 0; i < 26; i++) {
                if (alphabet.get(i).size() < k)
                    continue;

                for (int left = 0, right = k - 1; right < alphabet.get(i).size(); left++, right++) {
                    min = Math.min(min, alphabet.get(i).get(right) - alphabet.get(i).get(left) + 1);
                    max = Math.max(max, alphabet.get(i).get(right) - alphabet.get(i).get(left) + 1);
                }
            }

            bw.write(max == 0 ? "-1\n" : min + " " + max + "\n");
        }

        br.close();
        bw.close();
    }
}
