/*
 * 문제: 백준 8979번 - 올림픽 (https://www.acmicpc.net/problem/8979)
 * 문제 풀이
 *  금, 은, 동메달 순으로 기준을 정해서 정렬. 이전 국가와 메달 수가 다르면 등수 갱신.
 *
 * 시간 복잡도: O(N log N)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_8979_올림픽 {
    // public class Main {
    static class Country {
        int country, gold, silver, bronze;

        public Country(int country, int gold, int silver, int bronze) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Country[] counties = new Country[n + 1];
        int rank = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            counties[c] = new Country(c, g, s, b);
        }

        counties[0] = new Country(0, 0, 0, 0);
        Arrays.sort(counties, 1, counties.length, Comparator.comparingInt((Country a) -> -a.gold)
                .thenComparingInt(a -> -a.silver)
                .thenComparingInt(a -> -a.bronze));

        for (int i = 1; i <= n; i++) {
            Country prev = counties[i - 1];

            if (counties[i].gold != prev.gold || counties[i].silver != prev.silver || counties[i].bronze != prev.bronze)
                rank = i;

            if (counties[i].country == k)
                break;
        }

        bw.write(Integer.toString(rank));
        br.close();
        bw.close();
    }
}
