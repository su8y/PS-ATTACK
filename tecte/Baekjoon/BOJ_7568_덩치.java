/*
 * 문제: 백준 7568번 - 덩치 (https://www.acmicpc.net/problem/7568)
 * 문제 풀이
 *  각 사람마다 N명의 몸무게와 키를 비교하여 둘 다 작으면 등수 증가.
 *
 * 시간 복잡도: O(N^2)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_7568_덩치 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] people = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int[] person : people) {
            int rank = 1;

            for (int i = 0; i < n; i++)
                if (people[i][0] > person[0] && people[i][1] > person[1])
                    rank++;

            bw.write(rank + " ");
        }

        br.close();
        bw.close();
    }
}
