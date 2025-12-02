/*
 * 문제: 백준 9012번 - 괄호 (https://www.acmicpc.net/problem/9012)
 *
 * 시간 복잡도: O(t * n) - n: 문자열의 길이
 */

package baekjoon.workbook0.chapter9.section0;

import java.io.*;
import java.util.*;

public class BOJ_9012_괄호 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            String result = "YES";

            for (char c : input.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else if (stack.isEmpty()) {
                    result = "NO";
                    break;
                } else {
                    stack.pop();
                }
            }

            if (!stack.isEmpty())
                result = "NO";

            bw.write(result);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
