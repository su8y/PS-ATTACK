/*
 * 문제: 백준 9527번 - 1의 개수 세기 (https://www.acmicpc.net/problem/9527)
 * 문제 풀이
 *  1의 누적 개수를 구할 때 규칙이 있음.
 *  2진수 1(1) -> 10(2) -> 100(4) -> i 처럼 1에서부터 2배씩 올라갈 때, i의 누적 개수 = (i/2의 누적 개수 * 2 + (i/2 - 1))
 *  입력받은 수의 가장 큰 비트(가장 왼쪽에 있는 1)의 위치를 찾음. 그 비트를 기준으로 두 부분으로 나눠 각 부분에 대해 1의 개수를 구함.
 *  예를 들어, 이진수 1011(11)가 있으면 첫번째 1을 기준으로 1000, 0011로 나눠서 개수를 구함.
 *  1000, 0011의 누적 개수를 구하고 1011과 1000의 차를 구해서 더하면 1011의 누적 개수.
 *  1000은 위에서 미리 구해서 저장했지만 0011은 구하지 못했음.
 *  0011은 위 과정과 똑같이 반복. 첫번째 1을 기준으로 0010, 0001로 나눠서 개수를 구하고 0011과 0010의 차를 더함.
 *  즉, 1011의 개수 = 1000의 개수 + (1011 - 1000) + (0011의 개수 = 0010의 개수 + (0011 - 0010) + 0001의 개수)
 *  1011의 개수 = 13 + (11 - 8) + (2 + (3 - 2) + 1) = 20
 *
 * 시간 복잡도: O(log b)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9527_1의개수세기 {
    // public class Main {
    static long[] memo;

    private static long countOnes(long num) {
        if (num == 0)
            return 0;

        int idx = Long.SIZE - Long.numberOfLeadingZeros(num) - 1;
        long n = 1L << idx;

        return memo[idx] + num - n + countOnes(num ^ n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        memo = new long[55];
        memo[0] = 1;

        for (int i = 0; i < 54; i++)
            memo[i + 1] = (memo[i] << 1) + (1L << i) - 1;

        bw.write(Long.toString(countOnes(b) - countOnes(a - 1)));
        br.close();
        bw.close();
    }
}
