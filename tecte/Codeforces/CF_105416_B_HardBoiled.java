/*
 * 문제: 코드포스 - B. Hard Boiled (https://codeforces.com/gym/105416/problem/B)
 */

package Codeforces;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_105416_B_HardBoiled {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] eggs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt = 0;

        Arrays.sort(eggs);

        for (int egg : eggs) {
            t -= egg;

            if (t < 0)
                break;

            cnt++;
        }

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
