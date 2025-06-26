/*
 * 문제: 백준 5637번 - 가장 긴 단어 (https://www.acmicpc.net/problem/5637)
 *
 * 시간 복잡도: O(n) - n: 입력받은 문자 수
 */

package Baekjoon;

import java.io.*;

public class BOJ_5637_가장긴단어 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = "";

        while (true) {
            String[] str = br.readLine().split("[^a-zA-Z-]+");

            for (String s : str) {
                if (s.equals("E-N-D")) {
                    bw.write(word);
                    br.close();
                    bw.close();

                    return;
                } else if (s.length() > word.length()) {
                    word = s.toLowerCase();
                }
            }
        }
    }
}
