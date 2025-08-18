/*
 * 문제: 백준 2143번 - 두 배열의 합 (https://www.acmicpc.net/problem/2143)
 * 문제 풀이
 *  배열에서 가능한 부분합을 모두 HashMap에 저장하고 다른 배열에서 보완되는 값이 존재하는 확인.
 *
 * 시간 복잡도: O(n^2 + m^2)
 */

package Baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2143_두배열의합 {
    // public class Main {
    private static void subArrSum(int[] arr, Map<Integer, Long> map) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int key = arr[j] - arr[i];

                map.put(key, map.getOrDefault(key, 0L) + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] sn = new int[n + 1];
        int[] sm = new int[m + 1];
        Map<Integer, Long> mapN = new HashMap<>();
        Map<Integer, Long> mapM = new HashMap<>();
        long result = 0;

        for (int i = 1; i <= n; i++) {
            sn[i] = sn[i - 1] + Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= m; i++) {
            sm[i] = sm[i - 1] + Integer.parseInt(st.nextToken());
        }

        subArrSum(sn, mapN);
        subArrSum(sm, mapM);

        for (int k : mapN.keySet()) {
            long nc = mapN.getOrDefault(k, 0L);
            long mc = mapM.getOrDefault(t - k, 0L);

            result += nc * mc;
        }

        bw.write(Long.toString(result));
        br.close();
        bw.close();
    }
}
