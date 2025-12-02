/*
 * 문제: 백준 4101번 - 크냐? (https://www.acmicpc.net/problem/4101)
 *
 * 시간 복잡도: O(t) - t: 테스트 케이스 개수
 */

package baekjoon.workbook0.chapter4.section1;

import java.io.*;
import java.util.*;

public class BOJ_4101_크냐 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0)
                break;

            bw.write(a > b ? "Yes" : "No");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
