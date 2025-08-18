/*
 * 문제 : 백준 15829번 - Hashing (https://www.acmicpc.net/problem/15829)
 * 문제 풀이
 *  문자열을 하나씩 숫자로 바꿔서 계산을 해야하니 char 배열로 바꿈
 *  문자를 숫자로 바꿔야 하니 문자에서 ('a' + 1)를 빼고 31를 해당 문자의 항의 번호에 해당만큼 제곱하고 곱함
 *  계산한 문자들의 총 합을 1234567891로 나누었을 때의 나머지 값을 구함
 *  문자열의 길이는 최대 50까지인데 50번째 문자가 z인 문자열의 경우, 26*31^50이 되어서 int와 long의 범위를 초과하기 때문에 BigInteger로 계산
 */

package Baekjoon;

import java.io.*;
import java.math.BigInteger;

public class BOJ_15829_Hashing {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int l = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();
        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i < l; i++)
            sum = sum.add(BigInteger.valueOf(str[i] - 'a' + 1).multiply(BigInteger.valueOf(31).pow(i)));

        bw.write(sum.mod(BigInteger.valueOf(1234567891)).toString());

        br.close();
        bw.close();
    }
}
