/*
 * 문제: 백준 1515번 - 수 이어 쓰기 (https://www.acmicpc.net/problem/1515)
 * 문제 풀이
 *  남은 수를 이어 붙인 수를 하나씩 반복하면서 해당 숫자가 N에 포함되는지 확인.
 *  N에 포함되면 다음 수도 N에 포함되는지 확인하고 N에 포함되지 않으면 N값을 1증가.
 *  남은 수를 이어 붙인 수를 모두 돌았을 때의 N값이 최솟값.
 *
 * 시간 복잡도: O(m * log10 n) - n: 가능한 N 중에 최솟값, m: N의 자릿수
 */

package Baekjoon;

import java.io.*;

public class BOJ_1515_수이어쓰기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] n = br.readLine().toCharArray();
        int num = 1;
        int pos = 0;

        for (int i = 0; i < n.length; ) {
            char[] cNum = Integer.toString(num).toCharArray();
            boolean hasNum = false;

            for (int j = pos; j < cNum.length; j++) {
                if (n[i] == cNum[j]) {
                    pos = j + 1;
                    hasNum = true;
                    break;
                }
            }

            if (hasNum) {
                i++;
            } else {
                num++;
                pos = 0;
            }
        }

        bw.write(Integer.toString(num));
        br.close();
        bw.close();
    }
}
