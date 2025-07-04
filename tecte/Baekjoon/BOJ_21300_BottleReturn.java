/*
 * 문제: 백준 21300번 - Bottle Return (https://www.acmicpc.net/problem/21300)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_21300_BottleReturn {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();

        bw.write(Integer.toString(sum * 5));
        br.close();
        bw.close();
    }
}
