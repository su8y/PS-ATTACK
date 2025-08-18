/*
 * 문제 : 백준 1764번 - 듣보잡 (https://www.acmicpc.net/problem/1764)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_1764_듣보잡 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeSet<String> nSet = new TreeSet<>();
        TreeSet<String> mSet = new TreeSet<>();

        for (int i = 0; i < n; i++)
            nSet.add(br.readLine());

        for (int i = 0; i < m; i++)
            mSet.add(br.readLine());

        nSet.retainAll(mSet);
        bw.write(nSet.size() + "");
        bw.newLine();

        for (String s : nSet) {
            bw.write(s);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
