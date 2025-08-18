/*
 * 문제: 백준 1253번 - 좋다 (https://www.acmicpc.net/problem/1253)
 * 문제 풀이
 *  입력받은 n개의 수들을 돌면서 배열의 양쪽 끝에서부터 두 수의 합을 구해서 i 번째 수와 같은지 확인.
 *  i 번째 수보다 작은면 왼쪽 포인터를 오른쪽으로 옮기고 i 번째 수보다 크면 오른쪽 포인터를 왼쪽으로 옮김.
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_1253_좋다_2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int sum = num[left] + num[right];

                if (sum == num[i]) {
                    if (left == i) {
                        left++;
                        continue;
                    } else if (right == i) {
                        right--;
                        continue;
                    }

                    cnt++;
                    break;
                } else if (sum < num[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
