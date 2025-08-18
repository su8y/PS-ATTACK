/*
 * 문제 : 백준 5430번 - AC (https://www.acmicpc.net/problem/5430)
 * 문제 풀이
 *  입력받은 정수를 배열에 저장하고 왼쪽과 오른쪽을 가르키는 변수를 만듬.
 *  뒤집어지지 않았으면 왼쪽에서부터 정수를 삭제하거나 출력하고 뒤집었으면 오른쪽에서부터 삭제하거나 출력함
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_5430_AC {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] s;
            String str = br.readLine();
            int left = -1;
            int right = n;
            boolean isReverse = false;
            StringBuilder sb = new StringBuilder("[");

            if (n == 0)
                s = new int[0];
            else
                s = Arrays.stream(str.substring(1, str.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();

            for (char c : p.toCharArray()) {
                if (c == 'R')
                    isReverse = !isReverse;
                else if (isReverse)
                    right--;
                else
                    left++;

                if (left == right)
                    break;
            }

            if (isReverse)
                for (int i = right - 1; i > left; i--)
                    sb.append(s[i]).append(",");
            else
                for (int i = left + 1; i < right; i++)
                    sb.append(s[i]).append(",");

            if (left == right)
                sb = new StringBuilder("error");
            else if (sb.length() < 2)
                sb = new StringBuilder("[]");
            else
                sb.setCharAt(sb.length() - 1, ']');

            bw.write(sb + "\n");
        }

        br.close();
        bw.close();
    }
}
