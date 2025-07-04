/*
 * 문제: 백준 17478번 - 재귀함수가 뭔가요? (https://www.acmicpc.net/problem/17478)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_17478_재귀함수가뭔가요 {
    // public class Main {
    private static int n;
    private static StringBuilder sb = new StringBuilder();

    private static void recursive(int depth, String prefix) {
        sb.append(prefix).append("\"재귀함수가 뭔가요?\"\n");

        if (depth < n) {
            sb.append(prefix).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            sb.append(prefix).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            sb.append(prefix).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            recursive(depth + 1, prefix + "____");
        } else {
            sb.append(prefix).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        }

        sb.append(prefix).append("라고 답변하였지.\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursive(0, "");
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
