/*
 * 문제: 백준 14719번 - 빗물 (https://www.acmicpc.net/problem/14719)
 * 문제 풀이
 *  각 높이에서 왼쪽 벽과 오른쪽 벽을 찾아서 중간에 있는 칸을 빗물로 계산.
 *
 * 시간 복잡도: O(h * w)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        boolean[][] world = new boolean[h][w];
        int rainwater = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < w; i++)
            for (int j = Integer.parseInt(st.nextToken()) - 1; j >= 0; j--)
                world[j][i] = true;

        for (int i = 0; i < h; i++) {
            boolean hasBlock = false;
            int cnt = 0;

            for (int j = 0; j < w; j++) {
                if (hasBlock) {
                    if (world[i][j]) {
                        rainwater += cnt;
                        cnt = 0;
                    } else {
                        cnt++;
                    }
                } else if (world[i][j]) {
                    hasBlock = true;
                }
            }
        }

        bw.write(Integer.toString(rainwater));
        br.close();
        bw.close();
    }
}
