/*
 * 문제: 백준 16770번 - The Bucket List (https://www.acmicpc.net/problem/16770)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_16770_TheBucketList {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] buckets = new int[1001];
        int max = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = s; j <= t; j++) {
                buckets[j] += b;
            }
        }

        bw.write(Integer.toString(Arrays.stream(buckets).max().getAsInt()));
        br.close();
        bw.close();
    }
}
