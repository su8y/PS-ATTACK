/*
 * 문제 : 백준 1026번 - 보물 (https://www.acmicpc.net/problem/1026)
 * 문제 풀이
 * 	정수 배열 A의 가장 작은 값과 정수 배열 B의 가장 큰 값을 순서대로 곱해서 더한 값이 가장 작으므로
 * 	A와 B를 정렬해서 A는 첫번째 값, B는 마지막 값으로 서로 곱함
 * 	위와 같은 방식으로 A는 첫번째에서 마지막으로 B는 마지막에서 첫번째로 순서대로 곱한 값을 더함
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class BOJ_1026_보물 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int a[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int b[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int s = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        // A는 첫번째에서 마지막, B는 마지막에서 첫번째 순서대로 서로 곱한 값을 더함
        for (int i = 0; i < n; i++)
            s += a[i] * b[n - 1 - i];

        bw.write(Integer.toString(s));
        bw.flush();

        br.close();
        bw.close();
    }
}
