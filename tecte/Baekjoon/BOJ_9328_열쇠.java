/*
 * 문제: 백준 9328번 - 열쇠 (https://www.acmicpc.net/problem/9328)
 * 문제 풀이
 *  BFS 중에 문을 만나면 리스트에 저장.
 *  BFS가 끝나면 리스트에 있는 문 중에서 열쇠가 있는 문의 위치부터 다시 BFS를 함.
 *
 * 시간 복잡도: O(h * w)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_9328_열쇠 {
    // public class Main {
    private static char[][] map;
    private static boolean[][] visited;
    private static boolean[] keys;
    private static Queue<Pos> queue;
    private static List<Pos> list;
    private static int cnt;

    private static void move(Pos pos) {
        if (map[pos.x][pos.y] == '*') {
            return;
        }

        visited[pos.x][pos.y] = true;

        if (map[pos.x][pos.y] >= 'A' && map[pos.x][pos.y] <= 'Z') {
            list.add(pos);

            return;
        }

        if (map[pos.x][pos.y] == '$') {
            cnt++;
        } else if (map[pos.x][pos.y] != '.') {
            keys[map[pos.x][pos.y] - 'a'] = true;
        }

        queue.offer(pos);
    }

    private static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new boolean[h][w];
            keys = new boolean[26];
            queue = new LinkedList<>();
            list = new ArrayList<>();
            cnt = 0;

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                move(new Pos(i, 0));
                move(new Pos(i, w - 1));
            }

            for (int i = 1; i < w - 1; i++) {
                move(new Pos(0, i));
                move(new Pos(h - 1, i));
            }

            char[] k = br.readLine().toCharArray();

            if (k[0] != '0') {
                for (char c : k) {
                    keys[c - 'a'] = true;
                }
            }

            do {
                Pos[] dir = {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};
                List<Pos> newList = new ArrayList<>();

                while (!queue.isEmpty()) {
                    Pos pos = queue.poll();

                    for (Pos d : dir) {
                        int nx = pos.x + d.x;
                        int ny = pos.y + d.y;

                        if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny]) {
                            move(new Pos(nx, ny));
                        }
                    }
                }

                for (Pos pos : list) {
                    if (keys[map[pos.x][pos.y] - 'A']) {
                        queue.offer(pos);
                    } else {
                        newList.add(pos);
                    }
                }

                list = newList;
            } while (!queue.isEmpty());

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
