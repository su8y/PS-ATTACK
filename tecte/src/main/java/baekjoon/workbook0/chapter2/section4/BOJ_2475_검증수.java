/*
 * 문제: 백준 2475번 - 검증수 (https://www.acmicpc.net/problem/2475)
 *
 * 시간 복잡도: O(1)
 */

package baekjoon.workbook0.chapter2.section4;

import java.io.*;
import java.util.*;

public class BOJ_2475_검증수 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;

        for (int i : num)
            sum += i * i;

        bw.write(Integer.toString(sum % 10));
        br.close();
        bw.close();
    }
}
