/*
 * 문제: 백준 1283번 - 단축키 지정 (https://www.acmicpc.net/problem/1283)
 *
 * 시간 복잡도: O(n * m) - m: 옵션을 나타내는 문자열의 길이
 */

package Baekjoon;

import java.io.*;

public class BOJ_1283_단축키지정 {
    // public class Main {
    static int getKey(char c) {
        return Character.toLowerCase(c) - 'a';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[] hotkey = new boolean[26];

        while (n-- > 0) {
            StringBuilder sb = new StringBuilder(br.readLine());
            int idx = 0;

            if (hotkey[getKey(sb.charAt(0))]) {
                do {
                    idx = sb.indexOf(" ", idx) + 1;
                } while (idx > 0 && hotkey[getKey(sb.charAt(idx))]);

                if (idx <= 0) {
                    idx--;

                    for (int i = 0; i < sb.length(); i++) {
                        if (sb.charAt(i) == ' ') {
                            i++;
                        } else if (!hotkey[getKey(sb.charAt(i))]) {
                            idx = i;
                            break;
                        }
                    }
                }
            }

            if (idx >= 0) {
                hotkey[getKey(sb.charAt(idx))] = true;
                sb.insert(idx + 1, ']');
                sb.insert(idx, '[');
            }

            bw.write(sb.toString());
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
