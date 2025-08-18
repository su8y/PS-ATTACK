/*
 * 문제: 백준 1027번 - 고층 건물 (https://www.acmicpc.net/problem/1027)
 * 문제 풀이
 *  두 빌딩의 지붕을 연결했을 때 생기는 선분의 기울기를 구하고 두 빌딩 사이의 빌딩이 기울기를 넘어가거나 접하는지 확인.
 *
 * 시간 복잡도: O(n^3)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_1027_고층건물_1 {
    // public class Main {
    static int[] buildings;

    static boolean isNotBlocked(int a, int b) {
        long xInc = a - b;
        long yInc = buildings[a] - buildings[b];

        for (int i = b + 1; i < a; i++)
            if ((buildings[i] - buildings[b]) * xInc >= yInc * (i - b))
                return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        buildings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cnt = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (isNotBlocked(i, j))
                    cnt[i]++;

            for (int j = i + 1; j < n; j++)
                if (isNotBlocked(j, i))
                    cnt[i]++;

            max = Math.max(max, cnt[i]);
        }

        bw.write(Integer.toString(max));
        br.close();
        bw.close();
    }
}
