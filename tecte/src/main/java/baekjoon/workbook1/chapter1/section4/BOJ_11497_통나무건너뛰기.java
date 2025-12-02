/*
 * 문제: 백준 11497번 - 통나무 건너뛰기 (https://www.acmicpc.net/problem/11497)
 * 문제 풀이
 *  통나무를 높이 순으로 정렬.
 *  높이가 가장 낮은 통나무를 기준으로 양옆에 번갈아 배치하면 인접한 통나무끼리의 높이가 비슷해져서 최소 난이도를 구할 수 있음.
 *
 * 시간 복잡도:
 */

package baekjoon.workbook1.chapter1.section4;

import java.io.*;
import java.util.*;

public class BOJ_11497_통나무건너뛰기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            int left = arr[0];
            int right = arr[0];
            boolean isRight = true;
            int difficulty = 0;

            for (int i = 1; i < n; i++) {
                if (isRight) {
                    difficulty = Math.max(difficulty, arr[i] - right);
                    right = arr[i];
                } else {
                    difficulty = Math.max(difficulty, arr[i] - left);
                    left = arr[i];
                }

                isRight = !isRight;
            }

            sb.append(difficulty).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
