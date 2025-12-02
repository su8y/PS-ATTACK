/*
 * 문제: 백준 16499번 - 동일한 단어 그룹화하기 (https://www.acmicpc.net/problem/16499)
 * 문제 풀이
 *  정렬을 사용하면 순서 상관없이 단어를 이루고 있는 알파벳과 그 개수를 쉽게 알 수 있음.
 *
 * 시간 복잡도: O(n * m log m) - m: 단어의 길이
 */

package baekjoon.workbook1.chapter6.section4;

import java.io.*;
import java.util.*;

public class BOJ_16499_동일한단어그룹화하기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Set<String> group = new HashSet<>();

        for (int i = 0; i < n; i++) {
            char[] word = br.readLine().toCharArray();

            Arrays.sort(word);
            group.add(new String(word));
        }

        bw.write(Integer.toString(group.size()));
        br.close();
        bw.close();
    }
}
