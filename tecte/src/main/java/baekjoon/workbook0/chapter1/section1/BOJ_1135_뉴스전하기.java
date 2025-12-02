/*
 * 문제: 백준 1135번 - 뉴스 전하기 (https://www.acmicpc.net/problem/1135)
 * 문제 풀이
 *  ArrayList<HashMap<>>을 사용하여 인덱스가 직원i인 HashMap에는 키로 직원i의 직속 부하들, 값으로 직원i부터 직원i의 직·간접적인 부하까지 연락하는데 걸리는 시간을 저장.
 *  HashMap 리스트의 끝에서부터 HashMap의 값을 기준으로 정렬하고, 값 + 연락 순서를 계산하여 최대값을 자신을 키로 하는 HashMap에 저장.
 *  예를 들어, 값이 1, 3, 5가 있으면 내림차순으로 정렬하고 5, 3, 1 가장 오래 걸리는 값인 5부터 연락을 하면 5+1, 3+2, 1+3 으로 이 중 최대값인 6이 저장됨.
 *
 * 시간 복잡도: O(n log n)
 */

package baekjoon.workbook0.chapter1.section1;

import java.io.*;
import java.util.*;

public class BOJ_1135_뉴스전하기 {
    // public class  Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>(n);
        String[] input = br.readLine().split(" ");
        int[] superior = new int[n];

        for (int i = 0; i < n; i++) {
            list.add(new HashMap<>());
        }

        for (int i = 1; i < n; i++) {
            int p = Integer.parseInt(input[i]);

            superior[i] = p;
            list.get(p).put(i, 0);
        }

        for (int i = n - 1; i >= 0; i--) {
            List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(list.get(i).entrySet());
            entryList.sort(Map.Entry.comparingByValue());

            int seq = list.get(i).size();
            int max = 0;

            for (Map.Entry<Integer, Integer> entry : entryList) {
                max = Math.max(max, entry.getValue() + seq--);
            }

            list.get(superior[i]).put(i, max);
        }

        bw.write(Integer.toString(list.getFirst().get(0)));
        br.close();
        bw.close();
    }
}
