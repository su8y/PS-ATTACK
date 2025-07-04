/*
 * 문제: 백준 18258번 - 큐 2 (https://www.acmicpc.net/problem/18258)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_18258_큐2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Queue<String> queue = new LinkedList<>();
        String num = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken().charAt(1)) {
                case 'u':
                    num = st.nextToken();
                    queue.offer(num);
                    break;
                case 'o':
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                    break;
                case 'i':
                    sb.append(queue.size()).append("\n");
                    break;
                case 'm':
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 'r':
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                    break;
                case 'a':
                    sb.append(queue.isEmpty() ? -1 : num).append("\n");
            }
        }

        bw.write(sb.toString() );
        br.close();
        bw.close();
    }
}
