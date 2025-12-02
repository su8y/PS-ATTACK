/*
 * 문제: 백준 1937번 - 욕심쟁이 판다 (https://www.acmicpc.net/problem/1937)
 * 문제 풀이
 * 	n*n 크기의 대나무 숲을 반복문으로 돌면서 그 위치를 판다를 처음 풀어놓는 위치로,
 * 	대나무 숲과 같은 크기의 배열 dp에는 판다가 이동할 수 있는 경로의 최대 이동 횟수를 저장.
 * 	이동할 다음 장소의 dp에 최대 이동 횟수가 저장되어 있으면 다른 방향의 경로의 이동 횟수와 비교해 최대값을 현재 위치의 dp에 저장하고
 * 	다음 장소의 dp에 저장되어 있는 값이 없으면 재귀호출로 해당 경로의 최대 이동 횟수를 구함.
 *
 * 시간 복잡도: O(n²)
 */

package baekjoon.workbook0.chapter1.section9;

import java.io.*;
import java.util.stream.*;

public class BOJ_1937_욕심쟁이판다 {
	// public class Main {
	private static int n;
	private static int bamboo[][];
	private static int dp[][];
	private static int dx[] = { -1, 0, 1, 0 };
	private static int dy[] = { 0, 1, 0, -1 };

	private static int move(int i, int j) {
		if (dp[i][j] > 0)
			return dp[i][j];

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];

			if (x >= 0 && x < n && y >= 0 && y < n)
				if (bamboo[i][j] < bamboo[x][y])
					dp[i][j] = Math.max(dp[i][j], move(x, y));
		}

		return ++dp[i][j];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		int moveCnt = 0;

		bamboo = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++)
			bamboo[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				moveCnt = Math.max(moveCnt, move(i, j));

		bw.write(Integer.toString(moveCnt));
		bw.flush();

		br.close();
		bw.close();
	}
}
