/*
 * 문 제: 백준 1987번 - 알파벳 (https://www.acmicpc.net/problem/1987)
 * 문제 풀이
 *  DFS을 사용하여 다음 이동할 곳의 알파벳이 이미 지나온 길의 알파벳인지 확인하고 지나온 알파벳이 아니면 이동, 지나온 알파벳이면 다른 곳을 확인하여 이동
 *
 * 시간 복잡도: O(r * c)
 */

package Baekjoon;

import java.io.*;
import java.util.stream.Stream;

public class BOJ_1987_알파벳 {
    // public class  Main {
    static int r;
    static int c;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        board = new int[r][c];

        // 알파벳을 아스키 코드로 바꿔 저장
        for (int i = 0; i < r; i++)
            board[i] = Stream.of(br.readLine().split("")).flatMapToInt(String::chars).toArray();

        bw.write(Integer.toString(move(0, 0, 0))); // 재귀함수로 이동한 칸 수를 구함
        bw.flush();

        br.close();
        bw.close();
    }

    public static int move(int x, int y, int p) {
        p |= 1 << (board[x][y] - (int) 'a'); // 비트 마스크를 사용하여 현재 칸을 이동경로에 저장

        int moveCnt = Integer.bitCount(p); // 이진수에서 1의 개수를 구함, 1의 개수가 이동한 칸 수

        for (int i = 0; i < dx.length; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            // 이동한 곳이 보드의 범위 안에 없으면 continue
            if (mx < 0 || my < 0 || mx >= r || my >= c)
                continue;

            // 비트 마스크를 사용하여 이동할 곳의 알파벳이 이동한 경로의 알파벳과 겹치지 않을 경우 재귀함수 호출
            if ((p & (1 << (board[mx][my] - (int) 'a'))) == 0)
                moveCnt = Math.max(move(mx, my, p), moveCnt); // 이동할 수 있는 곳 중 비교하여 가장 많이 이동한 칸 수 저장
        }

        return moveCnt;
    }
}
