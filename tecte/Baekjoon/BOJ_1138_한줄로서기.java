/*
 * 문제: 백준 1138번 - 한 줄로 서기 (https://www.acmicpc.net/problem/1138)
 * 문제 풀이
 *  작은 사람부터 왼쪽에서 오른쪽으로 빈 자리를 세어가며 조건에 맞는 위치에 배치.
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_1138_한줄로서기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] line = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (line[j] == 0) {
                    if (people[i] == 0) {
                        line[j] = i + 1;
                        break;
                    }

                    people[i]--;
                }
            }
        }

        for (int i = 0; i < n; i++)
            bw.write(line[i] + " ");

        br.close();
        bw.close();
    }
}
