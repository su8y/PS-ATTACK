/*
 * 작성일	: 2022년 12월 28일
 * 문 제 	: 프로그래머스 - 게임 맵 최단거리
 * 		  https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */

package _2022_12_22;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리2 {

	public static void main(String[] args) {
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };
//		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
//				{ 0, 0, 0, 0, 1 } };

		Solution sol = new 게임맵최단거리2().new Solution();
		printMaps(maps);
		System.out.println(sol.solution(maps));
		printMaps(maps);
	}

	public static void printMaps(int maps[][]) {
		for (int[] i : maps) {
			for (int j : i) {
				System.out.printf("%3d", j);
			}
			System.out.println();
		}
	}

	// 프로그래머스 제출 코드
	class Solution {
		int[][] maps;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		boolean[][] visited;

		public int solution(int[][] maps) {
			this.maps = maps;

			return bfs();
		}

		public int bfs() {
			int n = maps.length;
			int m = maps[0].length;
			visited = new boolean[n][m];

			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[] { 0, 0, 1 });
			visited[0][0] = true;

			while (!queue.isEmpty()) {
				int[] item = queue.poll();
				int x = item[0];
				int y = item[1];
				int distance = item[2];

				if (x == n - 1 && y == m - 1)
					return distance;

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;

					if (maps[nx][ny] == 1 && !visited[nx][ny]) {
						queue.add(new int[] { nx, ny, distance + 1 });
						visited[nx][ny] = true;
					}
				}
			}

			return -1;
		}
	}
}