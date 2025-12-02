/*
 * 문제: 백준 12869번 - 뮤탈리스크 (https://www.acmicpc.net/problem/12869)
 * 문제 풀이
 * 	배열의 크기가 입력받은 scv의 체력만큼 인 배열 dp 생성.
 * 	뮤탈리스크의 공격 방법은 (9,3,1), (9,1,3), (3,9,1), (3,1,9), (1,9,3), (1,3,9)로 총 6가지.
 * 	뮤탈리스크의 공격을 받은 scv의 체력을 인덱스 값으로 하는 dp에 최솟값이 있으면 최솟값 반환,
 * 	6가지 공격 방법을 모두 비교하여 공격 받기 전의 체력을 인덱스 값으로 하는 dp에 최솟값을 저장.
 * 	dp에 최솟값이 없으면 재귀호출.
 *
 * 시간 복잡도: O(h³) - h: scv의 체력
 */

package baekjoon.workbook1.chapter2.section8;

import java.io.*;
import java.util.*;

public class BOJ_12869_뮤탈리스크 {
    // public class Main {
    private static int atk[][] = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
    private static int dp[][][];

    private static int mutalisk(int scv1, int scv2, int scv3) {
        if (dp[scv1][scv2][scv3] != 0)
            return dp[scv1][scv2][scv3];
        else if (scv1 == 0 && scv2 == 0 && scv3 == 0)
            return 0;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 6; i++) {
            int dscv1 = Math.max(scv1 - atk[i][0], 0);
            int dscv2 = Math.max(scv2 - atk[i][1], 0);
            int dscv3 = Math.max(scv3 - atk[i][2], 0);

            min = Math.min(min, mutalisk(dscv1, dscv2, dscv3) + 1);
        }

        return dp[scv1][scv2][scv3] = min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int scv[] = new int[3];
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            scv[i] = Integer.parseInt(token.nextToken());

        dp = new int[scv[0] + 1][scv[1] + 1][scv[2] + 1];

        bw.write(Integer.toString(mutalisk(scv[0], scv[1], scv[2])));
        bw.flush();

        br.close();
        bw.close();
    }
}
