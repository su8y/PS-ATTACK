/*
 * 문제: 백준 7682번 - 틱택토 (https://www.acmicpc.net/problem/7682)
 *
 * 시간 복잡도: O(t) - t: 테스트 케이스 수
 */

package Baekjoon;

import java.io.*;

public class BOJ_7682_틱택토 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String board = br.readLine();

            if (board.charAt(0) == 'e')
                break;

            int xCnt = 0;
            int oCnt = 0;
            int xWin = 0;
            int oWin = 0;

            for (char c : board.toCharArray()) {
                if (c == 'X')
                    xCnt++;
                else if (c == 'O')
                    oCnt++;
            }

            if (xCnt < 3 || xCnt > 5 || !(xCnt == oCnt || xCnt == oCnt + 1)) {
                bw.write("invalid\n");
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (board.charAt(i * 3) == board.charAt(i * 3 + 1) && board.charAt(i * 3) == board.charAt(i * 3 + 2)) {
                    if (board.charAt(i * 3) == 'X')
                        xWin++;
                    else if (board.charAt(i * 3) == 'O')
                        oWin++;
                }

                if (board.charAt(i) == board.charAt(i + 3) && board.charAt(i) == board.charAt(i + 6)) {
                    if (board.charAt(i) == 'X')
                        xWin++;
                    else if (board.charAt(i) == 'O')
                        oWin++;
                }
            }

            if ((board.charAt(0) == board.charAt(4) && board.charAt(0) == board.charAt(8)) ||
                    (board.charAt(2) == board.charAt(4) && board.charAt(2) == board.charAt(6))) {
                if (board.charAt(4) == 'X')
                    xWin++;
                else if (board.charAt(4) == 'O')
                    oWin++;
            }

            if ((xWin > 0 && oWin > 0) || (xWin == 0 && oWin == 0 && xCnt + oCnt != 9) ||
                    (xWin > 0 && xCnt == oCnt) || (oWin > 0 && xCnt == oCnt + 1))
                bw.write("invalid\n");
            else
                bw.write("valid\n");
        }

        br.close();
        bw.close();
    }
}
