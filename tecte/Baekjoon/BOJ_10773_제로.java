/*
 * 문제 : 백준 10773번 - 제로 (https://www.acmicpc.net/problem/10773)
 */

package Baekjoon;

import java.io.*;
import java.util.Stack;

public class BOJ_10773_제로 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < k; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0 && !stack.isEmpty())
                result -= stack.pop();
            else
                result += stack.push(input);
        }

        bw.write(result + "");
        br.close();
        bw.close();
    }
}
