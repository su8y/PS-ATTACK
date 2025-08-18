/*
 * 문제: 백준 5073번 - 삼각형과 세 변 (https://www.acmicpc.net/problem/5073)
 *
 * 시간 복잡도: O(n) - n: 입력받은 줄 개수
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_5073_삼각형과세변 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int[] sides = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

            if (sides[0] == 0)
                break;

            if (sides[0] + sides[1] > sides[2]) {
                if (sides[0] == sides[2])
                    bw.write("Equilateral\n");
                else if (sides[0] == sides[1] || sides[1] == sides[2])
                    bw.write("Isosceles\n");
                else
                    bw.write("Scalene\n");
            } else {
                bw.write("Invalid\n");
            }
        }

        br.close();
        bw.close();
    }
}
