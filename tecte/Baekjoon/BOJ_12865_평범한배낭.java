/*
 * 문제 : 백준 12865번 - 평범한 배낭 (https://www.acmicpc.net/problem/12865)
 * 문제 풀이
 * 	입력받은 값을 무게를 기준으로 정렬하고 n(개수)*w(무게)의 2차원 배열 dp를 만들어 최적의 가치 값을 저장
 * 	최적의 값은 원소의 무게 + dp의 인덱스가 (최대 무게-원소의 무게)인 값
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class BOJ_12865_평범한배낭 {
    //public class Main	{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String nw[] = br.readLine().split(" ");
        int n = Integer.parseInt(nw[0]);
        int w = Integer.parseInt(nw[1]);
        int item[][] = new int[n + 1][2];

        for (int i = 1; i <= n; i++)
            item[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 입력받은 무게와 가치를 무게를 기준으로 오름차순으로 정렬
        Arrays.sort(item, Comparator.comparingInt((int[] o) -> o[0]));
//		System.out.println(Arrays.deepToString(item));

        int dp[][] = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) { // i는 개수
            int iw = item[i][0]; // 원소 무게
            int iv = item[i][1]; // 원소 가치

            for (int j = item[1][0]; j <= w; j++) { // j는 최대 무게, 첫번째 원소의 무게가 가장 작으므로 item[1][0]부터 시작
                // 원소의 무게가 최대 무게보다 크거나 이전 원소의 가치가 더 크면 이전 원소의 가치를 가져옴
                if (iw > j)
                    dp[i][j] = dp[i - 1][j];
                else // 현재 원소의 가치 + 이전 원소에서 (최대 무게 - 현재 원소의 무게)일 때의 가치 값과 이전 원소의 가치 값을 비교해 큰값 저장
                    dp[i][j] = (iv + dp[i - 1][j - iw]) > dp[i - 1][j] ? iv + dp[i - 1][j - iw] : dp[i - 1][j];
            }
        }
//		System.out.println(Arrays.deepToString(dp));

        bw.write(Integer.toString(dp[n][w]));
        bw.flush();

        br.close();
        bw.close();
    }
}
