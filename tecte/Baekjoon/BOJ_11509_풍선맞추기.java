/*
 * 문제 : 백준 11509번 - 풍선 맞추기 (https://www.acmicpc.net/problem/11509)
 * 문제 풀이
 * 	화살의 높이를 알려주는 배열 선언
 * 	만약 화살이 3, 5 높이에 있으면 배열의 인덱스가 3, 5인 값을 1씩 증가시킴
 * 	입력받은 풍선 배열을 하나씩 돌면서 같은 높이의 화살이 있는지 검사
 * 	화살의 높이가 h일때 화살의 높이와 풍선의 높이가 같으면 화살배열[h]를 1감소, 화살배열[h-1]를 1증가시킴
 * 	화살의 높이와 풍선의 높이가 같지 않으면 화살의 개수와 화살배열[h-1]를 1증가시킴
 */

package Baekjoon;

import java.io.*;
import java.util.stream.Stream;

public class BOJ_11509_풍선맞추기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int balloon[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int arrow[] = new int[1000001]; // 풍선의 최대 높이가 1000000이므로 화살의 최대 높이도 1000000
        int arrowCnt = 0;

        for (int i = 0; i < n; i++) {
            if (arrow[balloon[i]] == 0) // 풍선의 높이에 화살이 없는 경우, 화살 개수와 arrow[풍선의 높이-1] 값을 1증가시킴
                arrowCnt++;
            else // 풍선의 높이에 화살이 있는 경우, arrow[풍선의 높이] 값을 1감소시키고 arrow[풍선의 높이-1] 값을 1증가시킴
                arrow[balloon[i]]--;

            arrow[balloon[i] - 1]++;
        }

        bw.write(Integer.toString(arrowCnt));
        bw.flush();

        br.close();
        bw.close();
    }
}
