/*
 * 문제 : 백준 16953번 - A → B (https://www.acmicpc.net/problem/16953)
 * 문제 풀이
 *  A를 B로 만드는 방법 말고 B를 A로 만드는 방법 사용
 *  B는 A에서 2를 곱하거나 1를 가장 오른쪽에 추가해서 만들어진 수이므로 2로 나어지지 않거나 맨 끝수가 1이 아니면 A가 될수 없어 -1
 *  B는 항상 A보다 커야하므로 B가 A보다 작아지면 -1
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_16953_AB {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt = 1;

        while (num[0] < num[1]) {
            cnt++;

            if (num[1] % 10 == 1) {
                num[1] /= 10;
            } else if (num[1] % 2 == 0) {
                num[1] >>= 1;
            } else {
                cnt = -1;
                break;
            }
        }

        bw.write(num[0] > num[1] ? "-1" : cnt + "");
        br.close();
        bw.close();
    }
}
