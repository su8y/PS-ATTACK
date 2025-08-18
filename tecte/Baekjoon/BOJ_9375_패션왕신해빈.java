/*
 * 문제 : 백준 9375번 - 패션왕 신해빈 (https://www.acmicpc.net/problem/9375)
 *  hashMap으로 의상의 종류에 따라 집합을 만듬
 *  각 집합에서 원소를 선택하지 않는 경우도 있으니까 각 집합의 크기에 1을 더해서 곱함
 *  모든 집합에서 원소를 하나도 뽑지 않는 경우인 공집합을 제외하기 위해 곱한 다음에 1을 뺌
 */

package Baekjoon;

import java.io.*;
import java.util.HashMap;

public class BOJ_9375_패션왕신해빈 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            int cases = 1;

            while (n-- > 0) {
                String key = br.readLine().split(" ")[1];

                map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
            }

            for (String key : map.keySet())
                cases *= map.get(key) + 1;

            bw.write(cases - 1 + "\n");
        }

        br.close();
        bw.close();
    }
}
