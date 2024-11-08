/*
 * 문제: 백준 11723번 - 집합 (https://www.acmicpc.net/problem/11723)
 * 문제 풀이
 *  hashSet으로 푼 방법
 *
 * 시간 복잡도: O(M)
 */

package Baekjoon;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_11723_집합_1 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "add":
                    set.add(st.nextToken());
                    break;
                case "remove":
                    set.remove(st.nextToken());
                    break;
                case "check":
                    bw.write(set.contains(st.nextToken()) ? "1" : "0");
                    bw.newLine();
                    break;
                case "toggle":
                    String x = st.nextToken();

                    if (set.contains(x))
                        set.remove(x);
                    else
                        set.add(x);

                    break;
                case "all":
                    for (int j = 1; j <= 20; j++)
                        set.add(j + "");

                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        br.close();
        bw.close();
    }
}
