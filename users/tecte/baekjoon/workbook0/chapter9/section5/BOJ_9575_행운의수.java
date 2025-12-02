/*
 * 문제: 백준 9575번 - 행운의 수 (https://www.acmicpc.net/problem/9575)
 * 문제 풀이
 *
 *
 * 시간 복잡도: O(t * n * m * k * d) - t: 테스트 케이스 수, d: 만들어진 수의 자릿수
 */

package baekjoon.workbook0.chapter9.section5;

import java.io.*;
import java.util.*;

public class BOJ_9575_행운의수 {
    // public class Main {
    private static boolean isLuckyNumber(int num) {
        while (num > 0) {
            if (num % 10 == 5 || num % 10 == 8) {
                num /= 10;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = Integer.parseInt(br.readLine());
            int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(br.readLine());
            int[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int l = 0; l < k; l++) {
                        int num = a[i] + b[j] + c[l];

                        if (isLuckyNumber(num)) {
                            set.add(num);
                        }
                    }
                }
            }

            sb.append(set.size()).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
