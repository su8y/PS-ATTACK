/*
 * 문제: 백준 2631번 - 줄세우기 (https://www.acmicpc.net/problem/2631)
 * 문제 풀이
 *  증가하는 순서대로 서 있는 아이들은 맞게 서 있는 것이므로 이 아이들을 제외한 아이들을 옮기면 됨.
 *  lis로 증가하는 순서대로 서 있는 아이들의 최장 길이를 구하고 n에서 뺌.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_2631_줄세우기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[n + 1];
        int pos = 0;

        for (int i = 0; i < n; i++) {
            int child = Integer.parseInt(br.readLine());

            if (child > line[pos]) {
                line[++pos] = child;
            } else {
                int idx = Arrays.binarySearch(line, 1, pos + 1, child) * -1 - 1;

                line[idx] = child;
            }
        }

        bw.write(Integer.toString(n - pos));
        br.close();
        bw.close();
    }
}
