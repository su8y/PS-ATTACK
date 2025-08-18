/*
 * 문제: 백준 5338번 - 마이크로소프트 로고 (https://www.acmicpc.net/problem/5338)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BOJ_5338_마이크로소프트로고 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("       _.-;;-._\n");
        bw.write("'-..-'|   ||   |\n");
        bw.write("'-..-'|_.-;;-._|\n");
        bw.write("'-..-'|   ||   |\n");
        bw.write("'-..-'|_.-''-._|");
        bw.close();
    }
}
