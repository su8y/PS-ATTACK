/*
 * 문제: 백준 16693번 - Pizza Deal (https://www.acmicpc.net/problem/16693)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_16693_PizzaDeal {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] slice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] whole = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        bw.write((double) slice[0] / slice[1] > whole[0] * whole[0] * Math.PI / whole[1] ? "Slice of pizza" : "Whole pizza");
        br.close();
        bw.close();
    }
}
