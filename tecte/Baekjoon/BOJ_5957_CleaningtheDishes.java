/*
 * 문제: 백준 5957번 - Cleaning the Dishes (https://www.acmicpc.net/problem/5957)
 * 문제 풀이
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_5957_CleaningtheDishes {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> dish = new Stack<>();
        Stack<Integer> wash = new Stack<>();
        Stack<Integer> dry = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = n; i > 0; i--) {
            dish.add(i);
        }

        while (!(dish.isEmpty() && wash.isEmpty())) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                for (int i = 0; i < b; i++) {
                    wash.add(dish.pop());
                }
            } else {
                for (int i = 0; i < b; i++) {
                    dry.add(wash.pop());
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(dry.pop()).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
