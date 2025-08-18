/*
 * 문제: 백준 25757번 - 임스와 함께하는 미니게임 (https://www.acmicpc.net/problem/25757)
 * 문제 풀이
 *  Y, F, O의 아스키 코드값이 89, 70, 79로 각각 4로 모듈러 연산을 하면 1, 2, 3으로 임스를 뺀 인원수가 나옴.
 *  hashSet으로 플레이하고자 하는 사람의 중복을 없애고 위에서 구한 인원수로 나누면 임스가 최대 몇 번 게임을 플레이하는지 나옴.
 *
 * 시간 복잡도: O(N)
 */

package Baekjoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_25757_임스와함께하는미니게임 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int player = st.nextToken().charAt(0) % 4;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++)
            set.add(br.readLine());

        bw.write(Integer.toString(set.size() / player));
        br.close();
        bw.close();
    }
}
