/*
 * 문제: 백준 17266번 - 어두운 굴다리 (https://www.acmicpc.net/problem/17266)
 * 문제 풀이
 *
 *
 * 시간 복잡도: O(M)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_17266_어두운굴다리 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] streetlight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int height = Math.max(streetlight[0], n - streetlight[m - 1]);

        for (int i = 1; i < m; i++)
            height = Math.max(height, (streetlight[i] - streetlight[i - 1] + 1) / 2);

        bw.write(Integer.toString(height));
        br.close();
        bw.close();
    }
}
