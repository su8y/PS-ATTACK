/*
 * 문제: 백준 22233번 - 가희와 키워드 (https://www.acmicpc.net/problem/22233)
 *
 * 시간 복잡도: O(m * l) - l: 새로 쓴 글과 관련된 키워드의 개수
 */

package baekjoon.workbook2.chapter2.section2;

import java.io.*;
import java.util.*;

public class BOJ_22233_가희와키워드 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++)
            set.add(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), ",");

            while (st.hasMoreTokens())
                set.remove(st.nextToken());

            bw.write(Integer.toString(set.size()));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
