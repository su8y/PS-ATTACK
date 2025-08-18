/*
 * 문제 : 백준 10828번 - 스택 (https://www.acmicpc.net/problem/10828)
 */

package Baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    stack.push(st.nextToken());
                    break;
                case "pop":
                    bw.write(stack.isEmpty() ? "-1" : stack.pop());
                    bw.newLine();
                    break;
                case "size":
                    bw.write(stack.size() + "");
                    bw.newLine();
                    break;
                case "empty":
                    bw.write(stack.isEmpty() ? "1" : "0");
                    bw.newLine();
                    break;
                case "top":
                    bw.write(stack.isEmpty() ? "-1" : stack.peek());
                    bw.newLine();
                    break;
            }
        }

        br.close();
        bw.close();
    }
}
