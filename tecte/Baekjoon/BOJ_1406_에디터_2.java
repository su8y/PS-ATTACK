/*
 * 문제: 백준 1406번 - 에디터 (https://www.acmicpc.net/problem/1406)
 * 문제 풀이
 *  Stack을 사용한 방법
 *
 * 시간 복잡도: O(m)
 */

package Baekjoon;

import java.io.*;
import java.util.Stack;

public class BOJ_1406_에디터_2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int m = Integer.parseInt(br.readLine());
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char c : str.toCharArray())
            left.add(c);

        for (int i = 0; i < m; i++) {
            String cmd = br.readLine();

            switch (cmd.charAt(0)) {
                case 'L':
                    if (!left.isEmpty())
                        right.add(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty())
                        left.add(right.pop());
                    break;
                case 'B':
                    if (!left.isEmpty())
                        left.pop();
                    break;
                case 'P':
                    left.add(cmd.charAt(2));
                    break;
            }
        }

        for (char c : left)
            bw.write(Character.toString(c));

        while (!right.isEmpty())
            bw.write(Character.toString(right.pop()));

        br.close();
        bw.close();
    }
}
