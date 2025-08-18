/*
 * 문제 : 백준 7662번 - 이중 우선순위 큐 (https://www.acmicpc.net/problem/7662)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662_이중우선순위큐 {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (op == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (!map.isEmpty()) {
                    int key = n == 1 ? map.lastKey() : map.firstKey();
                    int value = map.get(key) - 1;

                    if (value == 0)
                        map.remove(key);
                    else
                        map.put(key, value);
                }
            }

            if (map.isEmpty())
                bw.write("EMPTY\n");
            else
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
        }

        br.close();
        bw.close();
    }
}
