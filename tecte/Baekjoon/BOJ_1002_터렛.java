/*
 * 문 제 : 백준 1002번 - 터렛 (https://www.acmicpc.net/problem/1002)
 * 문제 풀이
 *  (x1, y1)과 (x2, y2) 사이의 거리보다 r1 + r2가 큰 경우 2
 *  (x1, y1)과 (x2, y2) 사이의 거리보다 r1 + r2가 작은 경우 0
 *  (x1, y1)과 (x2, y2) 사이의 거리와 r1 + r2가 같을 경우 1
 *  (x1, y1)와 (x2, y2) 위치가 같고 r1과 r2가 같은 경우 -1
 *  (x1, y1)와 (x2, y2) 위치가 같고 r1과 r2가 다른 경우 0
 *  (x1, y1)와 (x2, y2) 위치가 같고 r1과 r2가 0인 경우 1
 *  (x1, y1)과 (x2, y2) 사이의 거리보다 r1 - r2의 절대값이 큰 경우 0
 *  (x1, y1)과 (x2, y2) 사이의 거리와 r1 - r2의 절대값이 같을 경우 1
 */

package Baekjoon;

import java.io.*;
import java.util.stream.Stream;

public class BOJ_1002_터렛 {
    // public class  Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            double distance = Math.sqrt(Math.pow(input[0] - input[3], 2) + Math.pow(input[1] - input[4], 2));

            if (distance == 0) {
                if (input[2] != input[5])
                    bw.write("0");
                else if (input[2] == 0)
                    bw.write("1");
                else
                    bw.write("-1");
            } else if (distance < Math.abs(input[2] - input[5])) {
                bw.write("0");
            } else if (distance == Math.abs(input[2] - input[5])) {
                bw.write("1");
            } else {
                if (distance > input[2] + input[5])
                    bw.write("0");
                else if (distance < input[2] + input[5])
                    bw.write("2");
                else
                    bw.write("1");
            }

            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
