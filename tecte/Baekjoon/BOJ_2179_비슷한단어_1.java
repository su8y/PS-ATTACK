/*
 * 문제: 백준 2179번 - 비슷한 단어 (https://www.acmicpc.net/problem/2179)
 * 문제 풀이
 *  입력받은 순서대로 모든 단어 쌍을 비교하여 가장 비슷한 두 단어를 구함.
 *
 * 시간 복잡도: O(n^2 * l) - l: 영단어의 길이
 */

package Baekjoon;

import java.io.*;

public class BOJ_2179_비슷한단어_1 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        String wordA = words[0];
        String wordB = words[1];
        int cnt = 0;

        for (int i = 0; i < n; i++)
            words[i] = br.readLine();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = Math.min(words[i].length(), words[j].length());
                int newCnt = 0;

                for (int k = 0; k < len; k++, newCnt++)
                    if (words[i].charAt(k) != words[j].charAt(k))
                        break;

                if (words[i].length() == newCnt && words[j].length() == newCnt)
                    continue;

                if (newCnt > cnt) {
                    wordA = words[i];
                    wordB = words[j];
                    cnt = newCnt;
                }
            }
        }

        bw.write(wordA + "\n" + wordB);
        br.close();
        bw.close();
    }
}
