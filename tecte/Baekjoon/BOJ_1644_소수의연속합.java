/*
 * 문제: 백준 1644번 - 소수의 연속합 (https://www.acmicpc.net/problem/1644)
 * 문제 풀이
 *  에라토스테네스의 체를 사용하여 n까지의 소수를 모두 찾음.
 *  투 포인터를 이용하여 연속된 소수의 합이 n이 되는 경우의 수를 찾음.
 *
 * 시간 복잡도: O(n log log n)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1644_소수의연속합 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                continue;
            }

            primes.add(i);

            for (int j = 2; i * j <= n; j++) {
                isPrime[i * j] = true;
            }
        }

        while (right <= primes.size()) {
            if (sum < n) {
                if (right == primes.size()) {
                    break;
                }

                sum += primes.get(right++);
            } else {
                if (sum == n) {
                    cnt++;
                }

                sum -= primes.get(left++);
            }
        }

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
