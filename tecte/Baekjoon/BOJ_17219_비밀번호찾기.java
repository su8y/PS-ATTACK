/*
 * 문제 : 백준 17219번 - 비밀번호 찾기 (https://www.acmicpc.net/problem/17219)
 *  HashMap에 주소 : 비밀번호를 넣고 주소를 입력받으면 비밀번호 출력
 */

package Baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219_비밀번호찾기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> memo = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            memo.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < m; i++)
            bw.write(memo.get(br.readLine()) + "\n");

        br.close();
        bw.close();
    }
}
