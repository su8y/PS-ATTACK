/*
 * 문제: 백준 1406번 - 에디터 (https://www.acmicpc.net/problem/1406)
 * 문제 풀이
 *  StringBuilder를 사용한 방법
 *
 * 시간 복잡도: O(m * n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_1406_에디터_1 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int cursor = sb.length();

        for (int i = 0; i < m; i++) {
            String cmd = br.readLine();

            switch (cmd.charAt(0)) {
                case 'L':
                    if (cursor > 0)
                        cursor--;

                    break;
                case 'D':
                    if (cursor < sb.length())
                        cursor++;

                    break;
                case 'B':
                    if (cursor > 0) {
                        cursor--;
                        sb.deleteCharAt(cursor);
                    }

                    break;
                case 'P':
                    sb.insert(cursor, cmd.charAt(2));
                    cursor++;
                    break;
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
