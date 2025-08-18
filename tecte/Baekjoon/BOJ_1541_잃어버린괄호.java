/*
 * 문제 : 백준 1541번 - 잃어버린 괄호 (https://www.acmicpc.net/problem/1541)
 * 문제 풀이
 *  식의 앞에서 뒤로 가면서 -가 있으면 - 뒤에 괄호를 열고 다음 -가 나오거나 식이 끝나기 전에 괄호를 닫으면 최솟값을 구할 수 있음
 */

package Baekjoon;

import java.io.*;

public class BOJ_1541_잃어버린괄호 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] expression = br.readLine().split("-");
        int result = 0;

        for (int i = 0; i < expression.length; i++) {
            for (String num : expression[i].split("\\+")) {
                if (i == 0)
                    result += Integer.parseInt(num);
                else
                    result -= Integer.parseInt(num);
            }
        }

        bw.write(result + "");
        br.close();
        bw.close();
    }
}
