/*
 * 문제: 백준 16566번 - 카드 게임 (https://www.acmicpc.net/problem/16566)
 * 문제 풀이
 *  이진 탐색으로 민수의 카드보다 첫 번째로 큰 카드를 찾음.
 *  해당 카드가 이미 사용된 카드라면 Union-Find를 이용해 사용하지 않은 가장 가까운 큰 카드를 가져와서 사용.
 *  사용한 카드는 다음으로 사용 가능한 큰 카드와 연결.
 *
 * 시간 복잡도: O(m log m)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_16566_카드게임 {
    // public class Main {
    private static int m;
    private static int[] cards, parents;

    private static int upperBound(int t) {
        int left = 0;
        int right = m;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (cards[mid] > t) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int find(int e) {
        return parents[e] == e ? e : (parents[e] = find(parents[e]));
    }

    private static void union(int e) {
        parents[e] = find(e + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        cards = new int[m];
        parents = new int[m + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }

        Arrays.sort(cards);
        parents[m] = m;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            int card = Integer.parseInt(st.nextToken());

            card = find(upperBound(card));
            sb.append(cards[card]).append("\n");
            union(card);
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
