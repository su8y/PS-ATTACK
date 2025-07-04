/*
 * 문제: 백준 12919번 - A와 B 2 (https://www.acmicpc.net/problem/12919)
 * 문제 풀이
 *  s -> t로 바꾸는 과정에서 가지치기를 잘 못 하면 시간 초과가 날 수 있어서 t -> s로 바꾸는 과정이 더 편함.
 *
 * 시간 복잡도: O(t^2)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12919_A와B2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringBuilder t = new StringBuilder(br.readLine());
        Queue<StringBuilder> queue = new LinkedList<>();
        boolean isEquals = false;

        queue.offer(t);

        while (!queue.isEmpty()) {
            StringBuilder sb = queue.poll();

            if (sb.length() == s.length()) {
                isEquals = sb.toString().equals(s);

                if (isEquals)
                    break;
                else
                    continue;
            }

            if (sb.charAt(0) == 'B')
                queue.offer(new StringBuilder(sb).reverse().deleteCharAt(sb.length() - 1));

            if (sb.charAt(sb.length() - 1) == 'A')
                queue.offer(new StringBuilder(sb).deleteCharAt(sb.length() - 1));
        }

        bw.write(isEquals ? "1" : "0");
        br.close();
        bw.close();
    }
}
