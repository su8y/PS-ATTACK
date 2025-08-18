/*
 * 문제: 백준 1943번 - 동전 분배 (https://www.acmicpc.net/problem/1943)
 * 문제 풀이
 *  DP를 사용해서 각 동전마다 만들수 있는 금액을 메모이제이션.
 *  동전을 중복 사용하는 것을 방지하기 위해 0부터 검사하는 것이 아니라 최대 금액의 반인 50,000부터 검사
 *  동전의 총 합이 홀수이면 정확하게 반으로 나눌 수 없어 0 출력. 짝수면 동전으로 총 금액의 반을 만들 수 있는지 확인해서 출력.
 *
 * 시간 복잡도: O(n * w * m) - w: 최대 금액 100,000의 반인 50,000, m: 동전의 개수
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1943_동전분배 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 0; t < 3; t++) {
            int n = Integer.parseInt(br.readLine());
            boolean[] memo = new boolean[100_001];
            int sum = 0;

            memo[0] = true;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int coin = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());

                sum += coin * cnt;

                for (int j = 50000 - coin; j >= 0; j--)
                    if (memo[j])
                        for (int k = 1; k <= cnt; k++)
                            memo[j + coin * k] = true;
            }

            bw.write(((sum & 1) == 0 && memo[sum >> 1]) ? "1" : "0");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
