/*
 * 문 제: 백준 13144번 - List of Unique Numbers (https://www.acmicpc.net/problem/13144)
 * 문제 풀이
 *  시작 포인트와 끝 포인트, 두 개의 포인트를 처음에는 수열의 첫 번째 수를 가리키고 있다가 끝 포인트를 오른쪽으로 하나씩 이동하며 중복되는 수가 있는지 확인
 *  중복되는 수가 있으면 중복된 수 전까지의 모든 연속된 경우의 수(끝 포인트 - 시작 포인트)를 구하고 시작 포인트를 오른쪽으로 한 칸 이동해서 다시 중복 검사
 *  끝 포인트가 수열의 끝을 가리키면 시작 포인트를 오른쪽으로 하나씩 이동하며 시작 포인트와 끝 포인트 사이의 모든 연속된 경우의 수를 구해서 더함
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.HashSet;
import java.util.stream.Stream;

public class BOJ_13144_ListofUniqueNumbers {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] sequence = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashSet<Integer> set = new HashSet<>(); // HashSet을 사용해 중복 검사
        long cnt = 0;
        int start = 0; // 시작 포인트
        int end = 0; // 끝 포인트

        while (end < n) { // 끝 포인트가 수열의 끝 부분을 가리킬 때까지 반복
            if (set.contains(sequence[end])) { // 중복된 수가 있으면
                cnt += end - start; // 중복된 수 전까지의 연속된 경우의 수를 구해서 더함
                // HashSet에서 시작 포인트가 가리키는 수를 빼고 오른쪽으로 한 칸 이동
                set.remove(sequence[start]);
                start++;
            } else { // 중복된 수가 없으면 HashSet에 끝 포인트가 가리키면 수를 넣고 오른쪽으로 한 칸 이동
                set.add(sequence[end]);
                end++;
            }
        }

        // 시작 포인트를 오른쪽으로 하나씩 이동시키며 시작 포인트와 수열의 끝 사이의 연속된 경우의 수를 구해서 더함
        for (int i = start; i < n; i++)
            cnt += n - i;

        bw.write(Long.toString(cnt));
        bw.flush();

        br.close();
        bw.close();
    }
}
