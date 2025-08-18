/*
 * 문제: 백준 2138번 - 전구와 스위치 (https://www.acmicpc.net/problem/2138)
 * 문제 풀이
 *  첫 번째 전구를 누르는 경우와 누르지 않는 경우를 나누어서 두 가지 경우의 수를 검사.
 *  두 번째 전구부터 n 번째 전구 전까지 누를지 말지를 검사.
 *  i-1 번째 전구의 상태가 만들고자 하는 전구와 다를 때 i번째 전구를 눌러서 상태를 바꿈.
 *  n 번째 전구에서는 만들고자 하는 전구와 같으면 여태까지 전구를 몇 번 눌렀는지 출력하고 같지 안으면 -1을 출력.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_2138_전구와스위치 {
    // public class Main {
    static void press(StringBuilder sb, int idx) {
        sb.setCharAt(idx, sb.charAt(idx) == '0' ? '1' : '0');
        sb.setCharAt(++idx, sb.charAt(idx) == '0' ? '1' : '0');
        sb.setCharAt(++idx, sb.charAt(idx) == '0' ? '1' : '0');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String bulb = br.readLine();
        StringBuilder bulbA = new StringBuilder(br.readLine()).append(0);
        StringBuilder bulbB = new StringBuilder(bulbA);
        int aCnt = 0;
        int bCnt = 1;
        int answer = -1;

        bulbB.setCharAt(0, bulbB.charAt(0) == '0' ? '1' : '0');
        bulbB.setCharAt(1, bulbB.charAt(1) == '0' ? '1' : '0');

        for (int i = 0; i < n - 1; i++) {
            if (bulb.charAt(i) != bulbA.charAt(i)) {
                press(bulbA, i);
                aCnt++;
            }

            if (bulb.charAt(i) != bulbB.charAt(i)) {
                press(bulbB, i);
                bCnt++;
            }
        }

        if (bulb.charAt(n - 1) == bulbA.charAt(n - 1))
            answer = aCnt;
        else if (bulb.charAt(n - 1) == bulbB.charAt(n - 1))
            answer = bCnt;

        bw.write(Integer.toString(answer));
        br.close();
        bw.close();
    }
}
