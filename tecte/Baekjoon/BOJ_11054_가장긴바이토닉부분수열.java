/*
 * 문제: 백준 11054번 - 가장 긴 바이토닉 부분 수열 (https://www.acmicpc.net/problem/11054)
 * 문제 풀이
 *  가장 긴 증가하는 부분 수열(LIS)과 가장 긴 감소하는 부분 수열(LDS)을 구함.
 *  각 원소에서의 LIS와 LDS를 합해서 가장 긴 바이토닉 수열의 길이를 구함.
 *
 * 시간 복잡도: O(N log N)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_11054_가장긴바이토닉부분수열 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lis = new int[n];
        List<Integer> list = new ArrayList<>();
        int longest = 0;

        for (int i = 0; i < n; i++) {
            int head = Collections.binarySearch(list, a[i]);

            head = head < 0 ? -head - 1 : head;

            if (head < list.size())
                list.set(head, a[i]);
            else
                list.add(a[i]);

            lis[i] = list.size();
        }

        list = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            int head = Collections.binarySearch(list, a[i]);

            head = head < 0 ? -head - 1 : head;

            if (head < list.size())
                list.set(head, a[i]);
            else
                list.add(a[i]);

            longest = Math.max(longest, lis[i] + list.size() - 1);
        }

        bw.write(Integer.toString(longest));
        br.close();
        bw.close();
    }
}
