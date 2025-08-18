/*
 * 문제 : 백준 1043번 - 거짓말 (https://www.acmicpc.net/problem/1043)
 * 문제 풀이
 *  Union-Find로 진실을 아는 그룹과 모르는 그룹으로 나눔.
 *  각 파타에 진실을 아는 사람이 있는지 확인해서 지민이가 과장된 이야기를 할 수 있는 파티 개수를 구함.
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {
    // public class Main {
    static int[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        people = new int[n + 1];
        int[] party = new int[m];
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for (int i = 1; i <= n; i++)
            people[i] = i;

        while (t-- > 0)
            people[Integer.parseInt(st.nextToken())] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());

            party[i] = prev;

            while (p-- > 1) {
                int person = Integer.parseInt(st.nextToken());

                union(prev, person);
            }
            System.out.println(Arrays.toString(people));
        }

        for (int p : party)
            if (find(p) != 0)
                cnt++;

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }

    static int find(int e) {
        return e == people[e] ? e : (people[e] = find(people[e]));
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA < rootB)
            people[rootB] = rootA;
        else
            people[rootA] = rootB;
    }
}
