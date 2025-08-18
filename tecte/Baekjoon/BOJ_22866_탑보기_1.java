/*
 * 문제: 백준 22866번 - 탑 보기 (https://www.acmicpc.net/problem/22866)
 * 문제 풀이
 *  LDS를 활용하여 왼쪽에서 오른쪽으로, 오른쪽에서 왼쪽으로 두 번 진행.
 *  왼쪽에서 오른쪽으로 LDS를 진행할 때는 현재 건물의 왼쪽에 있는 건물들 중에서 볼 수 있는 건물의 개수와 가장 가까운 건물을 구하고
 *  오른쪽에서 왼쪽으로 LDS를 진행할 때는 현재 건물의 오른쪽에 있는 건물들 중에서 볼 수 있는 건물의 개수와 가장 가까운 건물을 구함.
 *  두 번의 LDS 결과를 합쳐서 볼 수 있는 건물의 개수와 가장 가까운 건물을 갱신함.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_22866_탑보기_1 {
    // public class Main {
    static int[] buildings;
    static int[] lds;

    static int lowerBound(int e, int key) {
        int left = 1;
        int right = e;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (buildings[lds[mid]] < key)
                right = mid - 1;
            else if (buildings[lds[mid]] > key)
                left = mid + 1;
            else
                return mid;
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        buildings = new int[n + 1];
        lds = new int[n + 1];
        int[] cnt = new int[n + 1];
        int[] near = new int[n + 1];
        int pos = 0;
        StringBuilder sb = new StringBuilder();

        buildings[0] = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());

            if (buildings[lds[pos]] > buildings[i]) {
                cnt[i] = pos;
                near[i] = lds[pos];
                lds[++pos] = i;
            } else {
                pos = lowerBound(pos, buildings[i]);
                lds[pos] = i;
                cnt[i] = pos - 1;
                near[i] = lds[pos - 1];
            }
        }

        pos = 0;

        for (int i = n; i > 0; i--) {
            int rtNear;

            if (buildings[lds[pos]] > buildings[i]) {
                cnt[i] += pos;
                rtNear = lds[pos];
                lds[++pos] = i;
            } else {
                pos = lowerBound(pos, buildings[i]);
                lds[pos] = i;
                cnt[i] += pos - 1;
                rtNear = lds[pos - 1];
            }

            if (near[i] == 0 || (rtNear > 0 && i - near[i] > rtNear - i))
                near[i] = rtNear;
        }

        for (int i = 1; i <= n; i++) {
            sb.append(cnt[i]);

            if (cnt[i] != 0)
                sb.append(" ").append(near[i]);

            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
