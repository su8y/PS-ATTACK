/*
 * 문제: 백준 1786번 - 찾기 (https://www.acmicpc.net/problem/1786)
 * 문제 풀이
 *  KMP(Knuth-Morris-Pratt) 알고리즘을 사용하여 본문 문자열에서 패턴 문자열이 등장하는 모든 위치를 찾음.
 *  패턴에 대해 부분 일치 테이블을 생성하고 본문과 패턴이 불일치 시 패턴 내에서 얼마나 건너뛸 수 있는지를 저장.
 *
 * 시간 복잡도: O(t + p)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1786_찾기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String t = br.readLine();
        String p = br.readLine();
        int[] pos = new int[p.length()];
        int tp = 0;
        int pp = 0;

        pos[0] = -1;

        for (int i = 1; i < pos.length; i++) {
            pos[i] = pp;

            while (pp >= 0 && p.charAt(i) != p.charAt(pp)) {
                pp = pos[pp];
            }

            pp++;
        }

        pp = 0;

        while (tp < t.length()) {
            while (pp != -1 && t.charAt(tp) != p.charAt(pp)) {
                pp = pos[pp];
            }

            if (pp == p.length() - 1) {
                list.add(tp - pp + 1);
                pp = pos[pp];
            } else {
                pp++;
                tp++;
            }
        }

        sb.append(list.size()).append("\n");
        list.forEach(i -> sb.append(i).append(" "));
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
