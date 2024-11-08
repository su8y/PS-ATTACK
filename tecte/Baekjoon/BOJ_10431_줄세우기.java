/*
 * 문제: 백준 10431번 - 줄세우기 (https://www.acmicpc.net/problem/10431)
 * 문제 풀이
 *  자기 앞에 자기보다 키가 큰 학생이 있으면 lowerBound로 위치를 찾고
 *  자기를 포함해서 현재까지 줄을 서 있는 학생 수 - 찾은 위치를 하면 뒤로 몇 번 물러서게 되는지 구할 수 있음.
 *
 * 시간 복잡도: O(t * n^2) - t: 테스트 케이스, n: 학생 수
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_10431_줄세우기 {
    // public class Main {
    static int lowerBound(List<Integer> list, int key) {
        int left = 1;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < key)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int[] students = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Integer> list = new ArrayList<>();
            int total = 0;

            list.add(0);

            for (int i = 1; i < students.length; i++) {
                if (students[i] < list.get(i - 1)) {
                    int idx = lowerBound(list, students[i]);

                    total += list.size() - idx;
                    list.add(idx, students[i]);
                } else {
                    list.add(students[i]);
                }
            }

            bw.write(students[0] + " " + total);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
