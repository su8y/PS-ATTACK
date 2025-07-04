/*
 * 문제: 백준 14890번 - 경사로 (https://www.acmicpc.net/problem/14890)
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
    // public class Main {
    private static int n, l;

    private static boolean path(int[] map) {
        int prev = map[0];
        int cont = 1;
        boolean hasGap = false;

        for (int i = 1; i < n; i++) {
            if (prev == map[i]) {
                cont++;
            } else if (prev + 1 == map[i] && cont >= l) {
                cont = 1;
            } else if (prev == map[i] + 1 && !hasGap) {
                hasGap = true;
                cont = 1;
            } else {
                return false;
            }

            if (hasGap && cont >= l) {
                hasGap = false;
                cont = 0;
            }

            prev = map[i];
        }

        return !hasGap;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        int cnt = 0;

        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            int[] colMap = new int[n];

            for (int j = 0; j < n; j++)
                colMap[j] = map[j][i];

            if (path(map[i]))
                cnt++;

            if (path(colMap))
                cnt++;
        }

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
