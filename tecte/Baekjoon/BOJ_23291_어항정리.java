/*
 * 문제: 백준 23291번 - 어항 정리 (https://www.acmicpc.net/problem/23291)
 *
 * 시간 복잡도: O(m * n) - m: 어항 정리 횟수
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_23291_어항정리 {
    // public class Main {
    private static int n;
    private static List<List<Integer>> fishTank = new ArrayList<>();

    private static void addFish(int min) {
        for (int i = 0; i < n; i++) {
            int cnt = fishTank.get(0).get(i);

            if (cnt == min) {
                fishTank.get(0).set(i, cnt + 1);
            }
        }
    }

    private static void levitation1() {
        int stack = 1;
        int len = 0;

        while (fishTank.size() <= fishTank.get(len).size() - stack) {
            List<List<Integer>> newFishTank = new ArrayList<>();

            for (int i = 0; i < stack; i++) {
                newFishTank.add(new ArrayList<>());

                for (int j = len; j >= 0; j--) {
                    newFishTank.get(i).add(fishTank.get(j).get(i));
                }
            }

            newFishTank.add(new ArrayList<>());

            for (int i = stack; i < fishTank.get(len).size(); i++) {
                newFishTank.get(stack).add(fishTank.get(len).get(i));
            }

            fishTank = newFishTank;
            stack = fishTank.get(0).size();
            len = fishTank.size() - 1;
        }
    }

    private static void adjust() {
        List<List<Integer>> newFishTank = new ArrayList<>();
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (List<Integer> list : fishTank) {
            newFishTank.add(new ArrayList<>());

            for (int fish : list) {
                newFishTank.get(newFishTank.size() - 1).add(fish);
            }
        }

        for (int i = 0; i < fishTank.size(); i++) {
            for (int j = 0; j < fishTank.get(i).size(); j++) {
                for (int[] d : dir) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x < 0 || x >= fishTank.size() || y < 0 || y >= fishTank.get(x).size() || fishTank.get(i).get(j) <= fishTank.get(x).get(y)) {
                        continue;
                    }

                    int cnt = (fishTank.get(i).get(j) - fishTank.get(x).get(y)) / 5;

                    newFishTank.get(i).set(j, newFishTank.get(i).get(j) - cnt);
                    newFishTank.get(x).set(y, newFishTank.get(x).get(y) + cnt);
                }
            }
        }

        fishTank = newFishTank;
    }

    private static void flatten() {
        List<List<Integer>> newFishTank = new ArrayList<>(1);
        int len = fishTank.size() - 1;
        int a = fishTank.get(0).size();
        int b = fishTank.get(len).size();

        newFishTank.add(new ArrayList<>());

        for (int i = 0; i < a; i++) {
            for (int j = len; j >= 0; j--) {
                newFishTank.get(0).add(fishTank.get(j).get(i));
            }
        }

        for (int i = a; i < b; i++) {
            newFishTank.get(0).add(fishTank.get(len).get(i));
        }

        fishTank = newFishTank;
    }

    private static void levitation2() {
        for (int i = 0; i < 2; i++) {
            List<List<Integer>> newFishTank = new ArrayList<>();
            int len = fishTank.get(0).size() >> 1;

            for (int x = 0; x < fishTank.size(); x++) {
                newFishTank.add(new ArrayList<>());

                for (int y = len - 1; y >= 0; y--) {
                    newFishTank.get(x).add(fishTank.get(fishTank.size() - 1 - x).get(y));
                }
            }

            for (int x = 0; x < fishTank.size(); x++) {
                newFishTank.add(new ArrayList<>());

                for (int y = len; y < fishTank.get(0).size(); y++) {
                    newFishTank.get(fishTank.size() + x).add(fishTank.get(x).get(y));
                }
            }

            fishTank = newFishTank;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max;
        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        fishTank.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            int cnt = Integer.parseInt(st.nextToken());

            fishTank.get(0).add(cnt);
            min = Math.min(min, cnt);
        }

        for (int i = 1; ; i++) {
            addFish(min);
            levitation1();
            adjust();
            flatten();
            levitation2();
            adjust();
            flatten();
            max = 0;
            min = Integer.MAX_VALUE;

            for (int fish : fishTank.get(0)) {
                max = Math.max(max, fish);
                min = Math.min(min, fish);
            }

            if (max - min <= k) {
                bw.write(Integer.toString(i));
                break;
            }
        }

        br.close();
        bw.close();
    }
}
