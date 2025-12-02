/*
 * 문제: 백준 10845번 - 큐 (https://www.acmicpc.net/problem/10845)
 *
 * 시간 복잡도: O(n)
 */

package baekjoon.workbook1.chapter0.section8;

import java.io.*;
import java.util.*;

public class BOJ_10845_큐 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Queue<String> queue = new LinkedList<>();
        String last = "";

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    last = st.nextToken();
                    queue.offer(last);
                    break;
                case "pop":
                    bw.write(queue.isEmpty() ? "-1" : queue.poll());
                    bw.newLine();
                    break;
                case "size":
                    bw.write(queue.size() + "");
                    bw.newLine();
                    break;
                case "empty":
                    bw.write(queue.isEmpty() ? "1" : "0");
                    bw.newLine();
                    break;
                case "front":
                    bw.write(queue.isEmpty() ? "-1" : queue.peek());
                    bw.newLine();
                    break;
                case "back":
                    bw.write(queue.isEmpty() ? "-1" : last);
                    bw.newLine();
                    break;
            }
        }

        br.close();
        bw.close();
    }
}
