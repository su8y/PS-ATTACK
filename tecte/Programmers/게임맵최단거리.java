/*
 * 작성일	: 2022년 12월 28일
 * 문 제 	: 프로그래머스 - 게임 맵 최단거리
 * 		  https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * 
 * dfs방식으로 풀면 프로그래머스에 제출시 정확성 테스트는 통과하나 효율성 테스트에서 시간 초과가 떠 틀렸다고 뜸
 */

package _2022_12_22;

public class 게임맵최단거리 {
	static int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
			{ 0, 0, 0, 0, 1 } };
//	static int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
//			{ 0, 0, 0, 0, 1 } };

	public static void main(String[] args) {
		int x = 0, y = 0;
		int distance = 1;

		for (int i = 0; i < maps.length; i++)
			for (int j = 0; j < maps[0].length; j++)
				maps[i][j] *= -1;

		printMaps();

		maps[x][y] = distance;
		dfs(x, y, distance);

		System.out.println("=====================");
		printMaps();
		System.out.println(maps[maps.length - 1][maps[0].length - 1]);
	}

	public static void dfs(int x, int y, int distance) {
		if (x - 1 >= 0 && maps[x - 1][y] != 0) {
			_dfs(x - 1, y, distance);
		}
		if (y + 1 < maps[0].length && maps[x][y + 1] != 0) {
			_dfs(x, y + 1, distance);
		}
		if (x + 1 < maps.length && maps[x + 1][y] != 0) {
			_dfs(x + 1, y, distance);
		}
		if (y - 1 >= 0 && maps[x][y - 1] != 0) {
			_dfs(x, y - 1, distance);
		}
	}

	public static void _dfs(int x, int y, int distance) {
		distance++;
		if (maps[x][y] == -1 || maps[x][y] > distance) {
			maps[x][y] = distance;
//			System.out.println("x : " + x + " y : " + y + " distance : " + distance);
			dfs(x, y, distance);
		}
	}

	public static void printMaps() {
		for (int[] i : maps) {
			for (int j : i) {
				System.out.printf("%3d", j);
			}
			System.out.println();
		}

	}
}

/*
 * // 프로그래머스 제출 코드 class Solution { int[][] maps;
 * 
 * public int solution(int[][] maps) { this.maps = maps; int x = 0, y = 0; int
 * distance = 1;
 * 
 * for (int i = 0; i < maps.length; i++) for (int j = 0; j < maps[0].length;
 * j++) maps[i][j] *= -1;
 * 
 * maps[x][y] = distance; dfs(x, y, distance);
 * 
 * return maps[maps.length - 1][maps[0].length - 1]; }
 * 
 * public void dfs(int x, int y, int distance) { if (x - 1 >= 0 && maps[x -
 * 1][y] != 0) { _dfs(x - 1, y, distance); } if (y + 1 < maps[0].length &&
 * maps[x][y + 1] != 0) { _dfs(x, y + 1, distance); } if (x + 1 < maps.length &&
 * maps[x + 1][y] != 0) { _dfs(x + 1, y, distance); } if (y - 1 >= 0 &&
 * maps[x][y - 1] != 0) { _dfs(x, y - 1, distance); } }
 * 
 * public void _dfs(int x, int y, int distance) { distance++; if (maps[x][y] ==
 * -1 || maps[x][y] > distance) { maps[x][y] = distance; dfs(x, y, distance); }
 * } }
 */
