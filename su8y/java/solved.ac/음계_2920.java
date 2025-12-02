package solved.ac;

import java.io.*;
import java.util.StringTokenizer;

public class 음계_2920 {
    static int K, N, M, T;

    /**
     * https://www.acmicpc.net/problem/2920 음계
     * 12345678 ascending <> descending
     * input [1 2 3 4 5 6 7 8]
     *
     * @return ex ) asending
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int previousNum = -1;
        int startNumber = Integer.parseInt(st.nextToken());
        int iterNum = 0;
        if (startNumber == 1) {
            previousNum = 1;
            iterNum = 1;
        } else if (startNumber == 8) {
            previousNum = 8;// 8부터 시작하기때문에
            iterNum = -1;
        } else {
            bw.write("mixed\n");
            bw.flush();
            return;
        }

        for (int i = 1; i < 8; i++) {
            int inputNumber = Integer.parseInt(st.nextToken());
            if (previousNum + iterNum != inputNumber) {
                bw.write("mixed\n");
                bw.flush();
                return;
            }
            previousNum = inputNumber;
        }
        bw.write(startNumber == 1 ? "ascending\n" : "descending\n");


        bw.close();
        br.close();
    }
}