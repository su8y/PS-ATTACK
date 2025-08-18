/*
 * 문 제 : 백준 2609번 - 최대공약수와 최소공배수 (https://www.acmicpc.net/problem/2609)
 * 문제 풀이
 *  두 수 A, B의 최대공약수를 G, 최소공배수를 L일 때, AB = GL
 *  최대공약수를 찾을 때, 유클리드 호제법을 사용하는 것이 빠름
 *  유클리드 호제법은 "A를 B로 나눈 몫을 Q라 하고 나머지를 R이라 할 때, gcd(A, B) = gcd(B, R)이다."
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2609_최대공약수와최소공배수 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int gcd = findGCD(a, b);
        int lcm = a * b / gcd;

        bw.write(gcd + "");
        bw.newLine();
        bw.write(lcm + "");

        br.close();
        bw.close();
    }

    public static int findGCD(int a, int b) {
        if (b == 0)
            return a;

        return findGCD(b, a % b);
    }
}
