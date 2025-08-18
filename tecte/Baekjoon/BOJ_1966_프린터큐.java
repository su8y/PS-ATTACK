/*
 * 문제 : 백준 1966번 - 프린터 큐 (https://www.acmicpc.net/problem/1966)
 * 문제 풀이
 *  중요도는 1이상 9이하의 정수이므로 몇 번째로 인쇄되는지 궁굼한 문서의 중요도에 10을 더함
 *  10을 더하는 이유는 중요도가 같은 다른 문서와 구분하기 위해서
 *  입력받은 중요도들을 배열에 넣어서 정렬
 *  배열의 끝에서 앞으로 반복문을 돌면서, 큐에서 해당 중요도의 문서를 뺌
 *  큐에서 뺀 문서가 처음에 중요도 10을 더한 문서가 맞는지 확인
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] imp = new int[n];
            Queue<Integer> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                int doc = Integer.parseInt(st.nextToken());

                imp[i] = doc;

                if (i == m)
                    doc += 10;

                queue.offer(doc);
            }

            Arrays.sort(imp);

            int cnt = 0;
            int findImp = n - 1;

            while (!queue.isEmpty()) {
                int doc = queue.poll();

                if (doc % 10 != imp[findImp]) {
                    queue.offer(doc);
                } else {
                    cnt++;
                    findImp--;

                    if (doc > 10)
                        break;
                }
            }

            bw.write(cnt + "");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
