/*
 * 문제 : 백준 28702번 - FizzBuzz (https://www.acmicpc.net/problem/28702)
 */

package Baekjoon;

import java.io.*;

public class BOJ_28702_FizzBuzz {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = 0;

        for (int i = 3; i > 0; i--) {
            String input = br.readLine();

            if (input.contains("Fizz") || input.contains("Buzz"))
                continue;

            num = Integer.parseInt(input) + i;
        }

        String result = "";

        if (num % 3 == 0)
            result += "Fizz";

        if (num % 5 == 0)
            result += "Buzz";

        if (result.isEmpty())
            result = num + "";

        bw.write(result);

        br.close();
        bw.close();
    }
}
