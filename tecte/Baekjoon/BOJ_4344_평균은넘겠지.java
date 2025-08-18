/*
 * 문 제 : 백준 4344번 - 평균은 넘겠지 (https://www.acmicpc.net/problem/4344)
 * 문제 풀이
 *  평균을 구하고 평균보다 높은 학생의 비율을 String.format()을 이용하여 소수점 셋째 자리까지 출력
 */

package Baekjoon;

import java.io.*;
import java.util.stream.Stream;

public class BOJ_4344_평균은넘겠지 {
    // public class  Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;

            for (int i = 1; i <= input[0]; i++)
                sum += input[i];

            float avg = (float) sum / input[0];
            int higher = 0;

            for (int i = 1; i <= input[0]; i++)
                if (input[i] > avg)
                    higher++;

            bw.write(String.format("%.3f", (float) higher / input[0] * 100) + "%");
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
