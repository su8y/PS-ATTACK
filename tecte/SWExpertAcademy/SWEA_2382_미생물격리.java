/*
 * 문제: SW Expert Academy 2382번 - [모의 SW 역량테스트] 미생물 격리 (https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV597vbqAH0DFAVl)
 * 문제 풀이
 *  입력받은 미생물 군집을 리스트로 저장하고 미생물의 수를 기준으로 내림차순 정렬.
 *  각 시간마다 리스트의 순서대로 미생물이 이동하는데 미생물이 겹칠 때는 먼저 이동한 미생물의 수가 더 많으므로
 *  나중에 이동한 미생물 군집이 먼저 이동한 미생물 군집으로 합쳐짐.
 *  모든 미생물 군집이 이동한 후에 다시 미생물의 수를 기준으로 내림차순 정렬.
 *  이 과정을 M번 반복.
 *
 * 시간 복잡도: O(T * M * K log K)
 */

package SWExpertAcademy;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2382_미생물격리 {
    // class Solution {
    static class Microbe {
        int x, y, cnt, dir;

        public Microbe(int x, int y, int cnt, int dir) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TestCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TestCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            List<Microbe> microbes = new ArrayList<>(k);
            int total = 0;

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                microbes.add(new Microbe(x, y, c, d));
            }

            for (int i = 0; i < m; i++) {
                Microbe[][] area = new Microbe[n][n];
                List<Microbe> newMicrobes = new ArrayList<>();

                microbes.sort(Comparator.comparingInt(a -> -a.cnt));

                for (Microbe microbe : microbes) {
                    int nx = microbe.x;
                    int ny = microbe.y;
                    int nd = microbe.dir;

                    switch (microbe.dir) {
                        case 1:
                            nx--;
                            nd = 2;
                            break;
                        case 2:
                            nx++;
                            nd = 1;
                            break;
                        case 3:
                            ny--;
                            nd = 4;
                            break;
                        case 4:
                            ny++;
                            nd = 3;
                            break;
                    }

                    if (nx == 0 || nx == n - 1 || ny == 0 || ny == n - 1) {
                        microbe.cnt >>= 1;
                        microbe.dir = nd;
                    }

                    if (microbe.cnt == 0)
                        continue;

                    if (area[nx][ny] == null) {
                        Microbe newMicrobe = new Microbe(nx, ny, microbe.cnt, microbe.dir);

                        area[nx][ny] = newMicrobe;
                        newMicrobes.add(newMicrobe);
                    } else {
                        area[nx][ny].cnt += microbe.cnt;
                    }
                }

                microbes = newMicrobes;
            }

            for (Microbe microbe : microbes)
                total += microbe.cnt;

            bw.write("#" + t + " " + total + "\n");
        }

        br.close();
        bw.close();
    }
}
