/*
 * 문제: 백준 30805번 - 사전 순 최대 공통 부분 수열 (https://www.acmicpc.net/problem/30805)
 * 문제 풀이
 *  수열의 수가 최대 100이므로 100부터 0까지 반복하며 A, B에 있는 수인지 확인.
 *  A, B 둘 다 있으면 해당 수를 부분 수열에 추가하고 다음 공통 수를 찾을 때는 각 수열에서 해당 수의 다음부터 찾을 수 있도록 함.
 *
 * 시간 복잡도: O(N)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_30805_사전순최대공통부분수열 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[m];
        int[] aNums = new int[101];
        int[] bNums = new int[101];
        List<Integer> seq = new ArrayList<>();
        int pos = 100;
        int posA = 0;
        int posB = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            a[i] = num;
            aNums[num]++;
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            b[i] = num;
            bNums[num]++;
        }

        while (posA < n && posB < m && pos > 0) {
            if (aNums[pos] == 0 || bNums[pos] == 0) {
                pos--;
                continue;
            }

            seq.add(pos);

            for (int i = posA; i < n; i++) {
                aNums[a[i]]--;

                if (a[i] == pos) {
                    posA = i + 1;
                    break;
                }
            }

            for (int i = posB; i < m; i++) {
                bNums[b[i]]--;

                if (b[i] == pos) {
                    posB = i + 1;
                    break;
                }
            }
        }

        bw.write(Integer.toString(seq.size()));
        bw.newLine();

        for (int s : seq)
            bw.write(s + " ");

        br.close();
        bw.close();
    }
}
