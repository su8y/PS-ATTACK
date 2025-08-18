/*
 * 문제 : 백준 1931번 - 회의실 배정 (https://www.acmicpc.net/problem/1931)
 * 문제 풀이
 * 	회의가 끝나는 시간이 빠른 순으로 정렬하고 정렬하고 진행한 회의가 끝나는 시간을 변수 endTime에 저장
 * 	회의 시작 시간과 endTime을 비교해서 회의 시작 시간이 endTime보다 클 경우 회의의 최대 개수를 증가시키고 endTime에 회의가 끝나는 시간을 저장
 *	회의 시간을 정렬할 때 처음 정렬 기준이 같음 경우 그다음 정렬 기준이 있어야 함
 *	그렇지 않으면 (5,5), (3,5), (1,3)를 입력 받았을 때 정렬이 (1,3), (5,5), (3,5)로 정렬될 수 있어
 *	(1,3)회의를 진행하고 (5,5)회의를 진행해 endTime이 5가 되어 (3,5)회의는 진행하지 않음
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class BOJ_1931_회의실배정 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int meetingInfo[][] = new int[n][2];
        int meeting = 0;

        for (int i = 0; i < n; i++)
            meetingInfo[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 회의가 끝나는 시간을 기준으로 정렬하고 끝나는 시간이 같을 경우 회의 시작 시간을 기준으로 정렬
        Arrays.sort(meetingInfo, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
//		System.out.println(Arrays.deepToString(meetingInfo));

        int endTime = 0; // 진행한 회의의 끝나는 시간을 저장하는 변수
        for (int i = 0; i < n; i++) {
            if (meetingInfo[i][0] < endTime) // 회의 시작 시간이 endTime보다 작을 경우 continue
                continue;

            // 회의 시작 시간이 endTime보다 크거나 같을 경우 회의 개수 증가시키고 endTime에 회의 끝나는 시간 저장
            meeting++;
            endTime = meetingInfo[i][1];
        }

        bw.write(Integer.toString(meeting));
        bw.flush();

        br.close();
        bw.close();
    }
}
