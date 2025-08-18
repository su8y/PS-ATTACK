/*
 * 문제 : 백준 1620번 - 나는야 포켓몬 마스터 이다솜 (https://www.acmicpc.net/problem/1620)
 *  배열에 번호를 인덱스로 이름을 넣고 HashMap에 이름 : 번호를 넣어서 문제가 입력되면 set에서 찾아서 출력
 */

package Baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620_나는야포켓몬마스터이다솜 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> name = new HashMap<>(n);
        String[] num = new String[n + 1];

        for (int i = 1; i <= n; i++) {
            String poketmon = br.readLine();

            name.put(poketmon, i);
            num[i] = poketmon;
        }

        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            char c = Character.toLowerCase(question.charAt(0));

            if (c >= 'a' && c <= 'z')
                bw.write(name.get(question) + "\n");
            else
                bw.write(num[Integer.parseInt(question)] + "\n");
        }

        br.close();
        bw.close();
    }
}
