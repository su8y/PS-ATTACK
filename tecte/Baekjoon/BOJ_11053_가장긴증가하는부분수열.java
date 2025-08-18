/*
 * 문제 : 백준 11053번 - 가장 긴 증가하는 부분 수열 (https://www.acmicpc.net/problem/11053)
 * 문제 풀이
 *	Lower Bound(정렬된 배열에서 찾고자 하는 값 이상이 처음으로 나타나는 위치)를 이용
 * 	수열을 하나씩 돌면서 수열의 원소를 찾고자 하는 값으로 하여
 * 	원소의 값 이상이 처음나타는 위치에 원소를 저장, 원소의 값보다 큰 값이 없으면 맨 끝에 추가
 * 	수열을 다 돌면 배열의 길이 출력
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;

public class BOJ_11053_가장긴증가하는부분수열 {
    //public class Main	{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[] seq = new int[size];

        String[] num = br.readLine().split(" ");
        for (int i = 0; i < size; i++)
            seq[i] = Integer.parseInt(num[i]);

        ArrayList<Integer> lis = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int start = 0;
            int end = lis.size();
            int mid;

            while (start < end) { // end가 start보다 같거나 작아지면, 그 값이 Lower Bound이므로 반복을 종료
                mid = (start + end) / 2;

                if (lis.get(mid) < seq[i]) // lis의 중간값이 원소 값보다 작을 경우, 시작값을 중간값+1로 설정
                    start = mid + 1;
                else // lis의 중간값이 원소 값보다 크거나 같을 경우, 끝값을 중간값으로 설정
                    end = mid;
            }

            if (end < lis.size()) // lis에 원소의 값 이상인 수가 있으면 처음나타는 위치에 원소를 저장
                lis.set(end, seq[i]);
            else // 원소의 값보다 큰 값이 없으면 lis에 원소 추가
                lis.add(seq[i]);

//			System.out.println(lis);
        }


        bw.write(Integer.toString(lis.size()));
        bw.flush();
    }
}