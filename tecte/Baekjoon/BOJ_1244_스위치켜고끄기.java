/*
 * 문제: 백준 1244번 - 스위치 켜고 끄기 (https://www.acmicpc.net/problem/1244)
 *
 * 시간 복잡도: O(n * m) - n: 스위치 개수, m: 학생 수
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[] sw = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int student = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++)
            if (st.nextToken().equals("1"))
                sw[i] = true;

        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().equals("1")) {
                int num = Integer.parseInt(st.nextToken());

                for (int j = num; j <= n; j += num)
                    sw[j] = !sw[j];
            } else {
                int num = Integer.parseInt(st.nextToken());
                int left = num;
                int right = num;

                while (left > 0 && right <= n) {
                    if (sw[left] != sw[right])
                        break;

                    sw[left] = sw[right] = !sw[left];
                    left--;
                    right++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (sw[i])
                bw.write("1 ");
            else
                bw.write("0 ");

            if (i % 20 == 0)
                bw.newLine();
        }

        br.close();
        bw.close();
    }
}
