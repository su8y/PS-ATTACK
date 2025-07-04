/*
 * 문제: 백준 15824번 - 너 봄에는 캡사이신이 맛있단다 (https://www.acmicpc.net/problem/15824)
 * 문제 풀이
 *  최대, 최소 순서쌍을 구하면 시간초과가 나서 최대값을 포함한 조합의 개수와 최소값을 포함한 조합의 개수를 따로 구함.
 *  어떤 메뉴 X가 포함되는 조합의 개수는 2^(N-1) 이므로,
 *  N번째 수를 최댓값으로 갖는 조합은 2^(N-1)가지, N-1번째 수를 최댓값으로 갖는 조합은 2^(N-2)가지 ... 1번째 수를 최댓값으로 갖는 조합은 2^0가지.
 *  N번째 수를 최솟값으로 갖는 조합은 2^(N-1)가지, N-1번째 수를 최솟값으로 갖는 조합은 2^(N-2)가지 ... 1번째 수를 최솟값으로 갖는 조합은 2^0가지.
 *  이를 일반화하면, 모든 스코빌지수를 정렬한 값이 A[1], A[2], ..., A[n] 일 때
 *  2^(N-1) * (A[n] - A[1]) + 2^(N-2) * (A[n-1] - A[2]) + ... + 2^0 * (A[1] - A[n])
 *  모듈러 연산 수행 후 계산하는 과정에서 음수가 나올 수 있어서 마지막에 모듈러 값을 더한 후, 모듈러 연산을 수행.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_15824_너봄에는캡사이신이맛있단다 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scoville = new int[n];
        final int MOD = 1_000_000_007;
        long cnt = 1;
        long result = 0;

        for (int i = 0; i < n; i++) {
            scoville[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scoville);

        for (int i = 0; i < n; i++) {
            result += (scoville[i] - scoville[n - 1 - i]) * cnt % MOD;
            result %= MOD;
            cnt = (cnt << 1) % MOD;
        }

        result = (result + MOD) % MOD;
        bw.write(Long.toString(result));
        br.close();
        bw.close();
    }
}
