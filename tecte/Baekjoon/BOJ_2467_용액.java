/*
 * 문제: 백준 2467번 - 용액 (https://www.acmicpc.net/problem/2467)
 * 문제 풀이
 *  용액이 오름차순으로 정렬되어 있으므로 투 포인터를 사용해 양 끝에서부터 특성값이 0에 가장 가까운 두 용액을 찾음.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_2467_용액 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] solutions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int left = 0;
        int right = n - 1;
        int solutionA = left;
        int solutionB = right;
        int mixture = Integer.MAX_VALUE;

        while (left < right) {
            int newMixture = solutions[left] + solutions[right];
            int absMixture = Math.abs(newMixture);

            if (absMixture < mixture) {
                solutionA = solutions[left];
                solutionB = solutions[right];
                mixture = absMixture;
            }

            if (newMixture == 0)
                break;
            else if (newMixture < 0)
                left++;
            else
                right--;
        }

        bw.write(solutionA + " " + solutionB);
        br.close();
        bw.close();
    }
}
