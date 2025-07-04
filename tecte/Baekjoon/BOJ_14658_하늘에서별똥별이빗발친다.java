/*
 * 문제: 백준 14658번 - 하늘에서 별똥별이 빗발친다 (https://www.acmicpc.net/problem/14658)
 * 문제 풀이
 *  두 별똥별의 좌표를 가져와서 사각형을 만들고 사각형의 왼쪽 위 꼭짓점을 구함.
 *  해당 꼭짓점에 트램펄린을 배치했을 때 트램펄린 밖에 떨어지는 별똥별의 수를 구하고 최소값을 찾음.
 *
 * 시간 복잡도: O(k^3)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14658_하늘에서별똥별이빗발친다 {
    // public class Main {
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        st.nextToken();
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Pos[] star = new Pos[k];
        int answer = k;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            star[i] = new Pos(x, y);
        }

        for (Pos a : star) {
            for (Pos b : star) {
                int nx = Math.min(a.x, b.x);
                int ny = Math.min(a.y, b.y);
                int cnt = k;

                for (Pos s : star)
                    if (nx <= s.x && s.x <= nx + l && ny <= s.y && s.y <= ny + l)
                        cnt--;

                answer = Math.min(answer, cnt);
            }
        }

        bw.write(Integer.toString(answer));
        br.close();
        bw.close();
    }
}
