/*
 * 문제: 코드포스 - D. Scrambled! (https://codeforces.com/gym/105416/problem/D)
 */

package Codeforces;

import java.io.*;
import java.util.Arrays;

public class CF_105416_D_Scrambled {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] str = br.readLine().toCharArray();
        boolean[] alphabet = new boolean[26];
        StringBuilder suffix = new StringBuilder();
        StringBuilder postfix = new StringBuilder();


        Arrays.sort(str);

        for (char c : str) {
            int i = c - 'a';

            if (alphabet[i]) {
                suffix.append(c);
                postfix.insert(0, c);
            }

            alphabet[i] = !alphabet[i];
        }

        for (int i = 0; i < alphabet.length; i++)
            if (alphabet[i])
                suffix.append((char) (i + 'a'));

        bw.write(suffix.append(postfix).toString());
        br.close();
        bw.close();
    }
}
