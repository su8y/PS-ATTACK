/*
 * 문제: 코드포스 - C. Egg Order (https://codeforces.com/gym/105416/problem/C)
 */

package Codeforces;

import java.io.*;
import java.util.StringTokenizer;

public class CF_105416_C_EggOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = n - k + 1; i <= n; i++)
            sb.append(i).append(" ");

        for (int i = n - k; i > 0; i--)
            sb.append(i).append(" ");

        bw.write(sb.toString().trim());
        br.close();
        bw.close();
    }
}
