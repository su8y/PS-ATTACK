/*
 * 문제: 백준 1271번 - 엄청난 부자2 (https://www.acmicpc.net/problem/1271)
 *
 * 시간 복잡도: O(l²) - l: 숫자의 자릿수
 */

package baekjoon.workbook0.chapter1.section2;

import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ_1271_엄청난부자2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        bw.write(n.divide(m) + "\n");
        bw.write(n.remainder(m).toString());
        br.close();
        bw.close();
    }
}
