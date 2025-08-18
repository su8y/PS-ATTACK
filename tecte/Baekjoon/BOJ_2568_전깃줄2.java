/*
 * 문제: 백준 2568번 - 전깃줄 - 2 (https://www.acmicpc.net/problem/2568)
 * 문제 풀이
 *  LIS 길이를 구할 때 마지막에 나온 배열이 LIS를 만족하지 않을 수 있음. 그때 역추적을 사용하여 올바른 LIS를 구함.
 *  이분 탐색을 사용하여 LIS에 들어갈 위치를 찾고, 해당 위치를 별도의 배열에 저장.
 *  LIS 길이를 구한 뒤, 저장된 위치 정보를 역순으로 추적하여 올바른 LIS 원소들을 복원.
 *  LIS에 포함되지 않은 전깃줄이 제거해야 하는 전깃줄.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2568_전깃줄2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] pole = new int[500_001];
        List<Integer> list = new ArrayList<>();
        int[] backtrack = new int[500_001];
        int pos;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pole[a] = b;
        }

        list.add(0);

        for (int i = 1; i < pole.length; i++) {
            if (pole[i] == 0) {
                continue;
            }

            pos = Collections.binarySearch(list, pole[i]);
            pos = pos < 0 ? -pos - 1 : pos;

            if (pos < list.size()) {
                list.set(pos, pole[i]);
            } else {
                list.add(pole[i]);
            }

            backtrack[i] = pos;
        }

        pos = list.size() - 1;
        sb.append(n - pos).append("\n");
        list = new ArrayList<>();

        for (int i = backtrack.length - 1; i >= 0; i--) {
            if (backtrack[i] == 0) {
                continue;
            }

            if (backtrack[i] == pos) {
                pos--;
            } else {
                list.add(i);
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
