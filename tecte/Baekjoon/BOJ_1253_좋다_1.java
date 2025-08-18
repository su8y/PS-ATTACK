/*
 * 문제: 백준 1253번 - 좋다 (https://www.acmicpc.net/problem/1253)
 * 문제 풀이
 *  n 번째 수를 다른 두 수의 합으로 나타낼 수 있는지 확인하기 위해 n에서 다른 수를 빼서 차를 구함.
 *  차가 배열에 존재하는지 이진 탐색으로 확인.
 *
 * 시간 복잡도: O(n^2 log n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_1253_좋다_1 {
    // public class Main {
    static int n;
    static int[] num;

    static int search(int start, int key) {
        int left = start;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (num[mid] < key)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int pos = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; ) {
                if (i != j) {
                    int diff = num[i] - num[j];

                    pos = search(pos, diff);

                    if (pos < n && num[pos] == diff) {
                        if (pos == i) {
                            pos = i + 1;
                            continue;
                        } else if (pos == j) {
                            pos = j + 1;
                            continue;
                        } else {
                            pos = 0;
                            cnt++;
                            break;
                        }
                    }
                }

                pos = 0;
                j++;
            }
        }

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
