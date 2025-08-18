/*
 * 문제: 백준 19637번 - IF문 좀 대신 써줘 (https://www.acmicpc.net/problem/19637)
 * 문제 풀이
 *  캐릭터의 전투력 수준을 이분 탐색으로 찾고 전투력에 해당하는 칭호 출력.
 *
 * 시간 복잡도: O(m log n)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_19637_IF문좀대신써줘 {
    // public class Main {
    static int lowerBound(int[] arr, int key) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] title = new String[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());

            bw.write(title[lowerBound(value, power)]);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
