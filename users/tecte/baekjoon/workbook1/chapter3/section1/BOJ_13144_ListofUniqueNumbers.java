/*
 * 문 제: 백준 13144번 - List of Unique Numbers (https://www.acmicpc.net/problem/13144)
 * 문제 풀이
 *  시작 포인트와 끝 포인트, 두 개의 포인트를 처음에는 수열의 첫 번째 수를 가리키고 있다가 끝 포인트를 오른쪽으로 하나씩 이동하며 중복되는 수가 있는지 확인
 *  중복되는 수가 있으면 중복된 수 전까지의 모든 연속된 경우의 수(끝 포인트 - 시작 포인트)를 구하고 시작 포인트를 오른쪽으로 한 칸 이동해서 다시 중복 검사
 *  끝 포인트가 수열의 끝을 가리키면 시작 포인트를 오른쪽으로 하나씩 이동하며 시작 포인트와 끝 포인트 사이의 모든 연속된 경우의 수를 구해서 더함
 *
 * 시간 복잡도: O(n)
 */

package baekjoon.workbook1.chapter3.section1;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class BOJ_13144_ListofUniqueNumbers {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] sequence = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashSet<Integer> set = new HashSet<>();
        long cnt = 0;
        int start = 0;
        int end = 0;

        while (end < n) {
            if (set.contains(sequence[end])) {
                cnt += end - start;
                set.remove(sequence[start]);
                start++;
            } else {
                set.add(sequence[end]);
                end++;
            }
        }

        for (int i = start; i < n; i++)
            cnt += n - i;

        bw.write(Long.toString(cnt));
        br.close();
        bw.close();
    }
}
