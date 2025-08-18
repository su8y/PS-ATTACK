/*
 * 문제: 백준 20006번 - 랭킹전 대기열 (https://www.acmicpc.net/problem/20006)
 *
 * 시간 복잡도: O(p * r * log m) - r: 방의 수
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_20006_랭킹전대기열 {
    // public class Main {
    static class Room {
        int level;
        TreeMap<String, Integer> player = new TreeMap<>();

        public Room(int level, String name) {
            this.level = level;
            player.put(name, level);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            boolean isEntry = false;

            for (Room room : rooms) {
                if (room.player.size() != m && l - 10 <= room.level && l + 10 >= room.level) {
                    room.player.put(n, l);
                    isEntry = true;
                    break;
                }
            }

            if (!isEntry)
                rooms.add(new Room(l, n));
        }

        for (Room room : rooms) {
            bw.write(room.player.size() == m ? "Started!" : "Waiting!");
            bw.newLine();

            for (Map.Entry<String, Integer> entry : room.player.entrySet()) {
                bw.write(entry.getValue() + " " + entry.getKey());
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }
}
