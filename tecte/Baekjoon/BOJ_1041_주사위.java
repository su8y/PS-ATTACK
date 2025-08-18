/*
 * 문 제 : 백준 1041번 - 줄 서기 (https://www.acmicpc.net/problem/1041)
 * 문제 풀이
 *  N=1 인 정육면체는 하나의 면만 빼고 나머지 부분을 더하면 되지만 N이 2이상인 경우
 *  N*N*N 크기의 정육면체에서 위쪽의 4개의 꼭짓점이 주사위의 3면이 보이고 정육면체의 모서리 부분이 주사위의 2면이 보인고 그 외 나머지 부분이 주사위의 1면만 보임
 *  주사위의 A, B, C, D, E, F에서 (A,F), (B,E), (C,D)가 서로 마주보는 면이고 주사위의 수 중 3개의 수만 알면 되기 때문에 마주보는 면끼리 작은 수를 구함
 *  정육면체 위쪽에 꼭짓점은 주사위의 가장 작은 3개 수의 합을 모서리는 가장 작은 2개 수의 합을 나머지 부분은 가장 작은 수의 합으로 답을 구함
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_1041_주사위 {
    // public class  Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] dice = br.readLine().split(" ");
        int[] smallNum = new int[3]; // 주사위의 가장 작의 3개의 수
        long minimum = 0;

        if (n == 1) { // n이 1일 경우 주사위 숫자의 합에서 가장 큰 수만 뺌
            int biggestNum = 0;

            for (String num : dice) {
                biggestNum = Math.max(biggestNum, Integer.parseInt(num));
                minimum += Integer.parseInt(num);
            }

            minimum -= biggestNum;
        } else { // n이 2이상일 경우
            // 주사위의 마주보는 면의 숫자 중 작은 값을 구함
            for (int i = 0; i < dice.length; i++) {
                if (i < dice.length / 2) {
                    smallNum[i] = Integer.parseInt(dice[i]);
                } else {
                    smallNum[dice.length - 1 - i] = Math.min(smallNum[dice.length - 1 - i], Integer.parseInt(dice[i]));
                }
            }

            Arrays.sort(smallNum);
            minimum += (smallNum[0] + smallNum[1] + smallNum[2]) * 4L; // 정육면체 위쪽의 꼭짓점에는 주사위의 가장 작은 3개 수의 합을
            minimum += (smallNum[0] + smallNum[1]) * ((n - 2) * 4L + (n - 1) * 4L); // 모서리에는 주사위의 가장 작은 2개 수의 합을
            minimum += smallNum[0] * (Math.pow(n - 2, 2) + (long) (n - 2) * (n - 1) * 4); // 나머지 부분에는 주사위의 가장 작은 수의 합을
        }

        bw.write(Long.toString(minimum));
        bw.flush();

        br.close();
        bw.close();
    }
}
