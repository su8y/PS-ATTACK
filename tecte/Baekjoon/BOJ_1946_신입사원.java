/*
 * 문제 : 백준 1946번 - 신입 사원 (https://www.acmicpc.net/problem/1946)
 * 문제 풀이
 * 	서류심사 순위 또는 면접심사 순위를 기준으로 정렬하고 기준이 되지 않은 심사를 차례대로 반복문 수행
 * 	기준이 되지 않은 심사를 변수 higher와 비교하여 더 작은 값을 higher에 저장
 * 	higher 값이 바뀔 때마다 그 사람이 채용되었다는 것을 의미
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class BOJ_1946_신입사원 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            int ranking[][] = new int[n][2];
            int higher = Integer.MAX_VALUE;
            int recruitment = 0;

            for (int i = 0; i < n; i++)
                ranking[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(ranking, Comparator.comparingInt((int[] o) -> o[0])); // 서류심사 순위를 기준으로 정렬

            for (int i = 0; i < n; i++) {
                // 면접심사 순위를 비교하여 더 높은 순위(작은 값)를 higher에 저장하고 채용 인원 1증가
                if (higher > ranking[i][1]) {
                    higher = ranking[i][1];
                    recruitment++;
                }
            }

            bw.write(Integer.toString(recruitment) + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
