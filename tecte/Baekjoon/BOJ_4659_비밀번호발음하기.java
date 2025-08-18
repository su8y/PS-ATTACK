/*
 * 문제: 백준 4659번 - 비밀번호 발음하기 (https://www.acmicpc.net/problem/4659)
 *
 * 시간 복잡도: O(t * n) - t: 테스트 케이스 수, n: 패스워드 길이
 */

package Baekjoon;

import java.io.*;

public class BOJ_4659_비밀번호발음하기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String password = br.readLine();

            if (password.equals("end"))
                break;

            char prev = 0;
            boolean hasVowel = false;
            int vowel = 0;
            int consonant = 0;
            StringBuilder sb = new StringBuilder();
            String result = " is acceptable.";

            sb.append("<").append(password).append(">");

            for (char c : password.toCharArray()) {
                if (c == 'a' || c == 'i' || c == 'u') {
                    if (vowel == 2 || c == prev) {
                        result = " is not acceptable.";
                        break;
                    }

                    hasVowel = true;
                    vowel++;
                    consonant = 0;
                } else if (c == 'e' || c == 'o') {
                    if (vowel == 2) {
                        result = " is not acceptable.";
                        break;
                    }

                    hasVowel = true;
                    vowel++;
                    consonant = 0;
                } else {
                    if (consonant == 2 || c == prev) {
                        result = " is not acceptable.";
                        break;
                    }

                    vowel = 0;
                    consonant++;
                }

                prev = c;
            }

            if (!hasVowel)
                result = " is not acceptable.";

            sb.append(result);
            bw.write(sb.toString());
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
