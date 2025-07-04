/*
 * 문제: 백준 28691번 - 정보보호학부 동아리 소개 (https://www.acmicpc.net/problem/28691)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;

public class BOJ_28691_정보보호학부동아리소개 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String name = "";

        switch (br.readLine()) {
            case "M":
                name = "MatKor";
                break;
            case "W":
                name = "WiCys";
                break;
            case "C":
                name = "CyKor";
                break;
            case "A":
                name = "AlKor";
                break;
            case "$":
                name = "$clear";
                break;
        }

        bw.write(name);
        br.close();
        bw.close();
    }
}
