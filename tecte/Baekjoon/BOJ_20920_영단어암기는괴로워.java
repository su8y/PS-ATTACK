/*
 * 문제: 백준 20920번 - 영단어 암기는 괴로워 (https://www.acmicpc.net/problem/20920)
 *
 * 시간 복잡도: O(N log N)
 */

package Baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_20920_영단어암기는괴로워 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        while (n-- > 0) {
            String word = br.readLine();

            if (word.length() < m)
                continue;

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        bw.write(map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(entry -> -entry.getKey().length())
                        .thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining("\n")));
        br.close();
        bw.close();
    }
}
