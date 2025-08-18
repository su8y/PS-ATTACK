/*
 * 문제: 백준 1697번 - 숨바꼭질 (https://www.acmicpc.net/problem/1697)
 * 문제 풀이
 *  BFS로 푸는데 큐 2개를 사용. 하나의 큐는 삭제를 하고 나머지 하나의 큐는 삽입을 함
 *  삭제를 하던 큐가 비어지면 삽입을 하던 큐와 바꿔서 삭제를 하던 큐는 삽입을, 삽입을 하던 큐는 삭제를 함. 2개의 큐 모두 비어지면 break
 *  +1과 -1 때문에 이미 지나친 점인데도 큐에 들어가서 메모리가 초과됨. 이것을 방지하기 위해 boolean 배열로 방문을 표시
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> insert = new LinkedList<>();
        Queue<Integer> delete;
        boolean[] visited = new boolean[100001];
        int sec = 0;

        insert.offer(n);

        while (true) {
            delete = insert;
            insert = new LinkedList<>();

            while (!delete.isEmpty()) {
                n = delete.poll();
                visited[n] = true;

                if (n == k) {
                    bw.write(sec + "");
                    br.close();
                    bw.close();

                    return;
                }

                if (n - 1 >= 0 && !visited[n - 1])
                    insert.offer(n - 1);

                if (n + 1 <= 100000 && !visited[n + 1])
                    insert.offer(n + 1);

                if (n * 2 <= 100000 && !visited[n * 2])
                    insert.offer(n * 2);
            }

            sec++;
        }
    }
}
