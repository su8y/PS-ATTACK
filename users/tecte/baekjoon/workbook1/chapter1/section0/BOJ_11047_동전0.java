/*
 * 문제: 백준 11047번 - 동전 0 (https://www.acmicpc.net/problem/11047)
 * 문제 풀이
 * 	가치가 큰 동전부터 k를 나눠 나머지가 k가 되고 그다음으로 가치가 큰 동전으로 다시 나눔.
 * 	k가 0이 되면 동전으로 나눈 몫들의 합이 k가 되기 위한 동전의 최소 개수.
 *
 * 시간 복잡도: O(n)
 */

package baekjoon.workbook1.chapter1.section0;

import java.io.*;

public class BOJ_11047_동전0 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int coin[] = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++)
            coin[i] = Integer.parseInt(br.readLine());

        while (k != 0) {
            n--;
            cnt += k / coin[n];
            k %= coin[n];
        }

        bw.write(Integer.toString(cnt));
        bw.flush();

        br.close();
        bw.close();
    }
}
