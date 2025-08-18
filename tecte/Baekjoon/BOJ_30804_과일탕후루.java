/*
 * 문제 : 백준 30804번 - 과일 탕후루 (https://www.acmicpc.net/problem/30804)
 * 문제 풀이
 *  두 포인터를 사용해서 품
 *  막대의 앞쪽에서 뒤쪽으로 이동하면서 과일을 확인하고 과일의 종류가 2개를 넘으면 앞쪽에서부터 과일을 빼서 다시 2종류가 되게 유지
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedHashMap;

public class BOJ_30804_과일탕후루 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] fruit = br.readLine().split(" ");
        LinkedHashMap<String, Integer> stick = new LinkedHashMap<>();
        int back = -1;
        int cnt = 0;

        for (int front = 0; front < n; front++) {
            stick.put(fruit[front], front);

            if (stick.size() > 2) {
                String key = stick.keySet().iterator().next();

                back = stick.get(key);
                stick.remove(key);
            }

            cnt = Math.max(cnt, front - back);
        }

        bw.write(cnt + "");
        br.close();
        bw.close();
    }
}
