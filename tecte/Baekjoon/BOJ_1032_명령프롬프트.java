/*
 * 문제: 백준 1032번 - 명령 프롬프트 (https://www.acmicpc.net/problem/1032)
 *
 * 시간 복잡도: O(n * m) - m: 파일 이름의 길이
 */

package Baekjoon;

import java.io.*;

public class BOJ_1032_명령프롬프트 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] files = new char[n][];

        for (int i = 0; i < n; i++)
            files[i] = br.readLine().toCharArray();

        for (int i = 1; i < n; i++)
            for (int j = 0; j < files[0].length; j++)
                if (files[0][j] != files[i][j])
                    files[0][j] = '?';

        bw.write(String.valueOf(files[0]));
        br.close();
        bw.close();
    }
}
