/*
 * 문 제 : 백준 3745번 - 오름세 (https://www.acmicpc.net/problem/3745)
 * 문제 풀이
 *  가장 긴 증가하는 부분 수열(lis)을 이용해 풀어야 하는 문제
 *  lis의 첫 번째 원소에 첫날의 주가를 넣고 그 다음 날의 주가부터는 이분 탐색을 해서 lis에 저장
 *  마지막 날의 주가까지 lis에 넣고 나서 lis의 길이를 출력
 *  lis와 이분 탐색을 이용해서 시간 복잡도는 O(nlogn)
 */

package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_3745_오름세 {
    // public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ArrayList<Integer> lis = new ArrayList<>(n);

            lis.add(scanner.nextInt()); // 첫날의 주가는 lis에 바로 삽입

            for (int i = 1; i < n; i++) {
                int stockPrice = scanner.nextInt();
                int left = 0;
                int right = lis.size();
                int mid;

                // 이분 탐색을 통해 lis에 넣을 주가의 위치를 구함
                while (left < right) {
                    mid = (left + right) / 2;

                    if (stockPrice > lis.get(mid))
                        left = mid + 1;
                    else
                        right = mid;
                }

                if (right < lis.size())
                    lis.set(right, stockPrice);
                else
                    lis.add(stockPrice);
            }

            System.out.println(lis.size());
        }
    }
}
