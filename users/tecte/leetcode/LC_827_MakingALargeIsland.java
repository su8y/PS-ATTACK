/*
 * 문제: 리트코드 827번 - Making A Large Island (https://leetcode.com/problems/making-a-large-island/)
 * 문제 풀이
 *  grid를 순차적으로 돌면서 1(육지)인 경우 대표 원소가 있는지 확인하고 없으면 새로운 대표 원소 만들어서 dfs로 해당 육지의 땅 크기를 구함.
 * 	대표 원소는 hashMap에 저장(key : 대표 원소, value : 크기)
 * 	0(바다)인 경우 4방향을 검사해 육지가 있으면 해당 육지들의 대표 원소 합 + 1을 최대 크기와 비교.
 * 	grid를 다 돌면 최대 크기를 반환.
 *
 * 시간 복잡도: O(n²)
 */

package leetcode;

import java.util.*;

public class LC_827_MakingALargeIsland {
	// class Solution {
	private HashMap<Integer, Integer> island = new HashMap<Integer, Integer>();
	private int dx[] = { -1, 0, 1, 0 };
	private int dy[] = { 0, 1, 0, -1 };
	private int grid[][];

	private void addIsland(int x, int y) {
		int element = island.size() + 2;

		grid[x][y] = element;
		island.put(element, findIsland(x, y, element));
	}

	private int findIsland(int x, int y, int element) {
		int n = grid.length;
		int size = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;

			if (grid[nx][ny] == 1) {
				grid[nx][ny] = element;
				size += findIsland(nx, ny, element);
			}
		}

		return size;
	}

	public int largestIsland(int[][] grid) {
		this.grid = grid;
		int n = grid.length;
		int maxSize = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					addIsland(i, j);
				} else if (grid[i][j] == 0) {
					boolean visitedIsland[] = new boolean[island.size() + 2];
					int size = 1;

					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (nx < 0 || nx >= n || ny < 0 || ny >= n)
							continue;

						int land = grid[nx][ny];
						if (land == 1) {
							land = island.size()+2;
							addIsland(nx, ny);
							visitedIsland = Arrays.copyOf(visitedIsland, visitedIsland.length + 1);
							visitedIsland[land] = true;
							size += island.get(land);
						} else if (land > 1 && !visitedIsland[land]) {
							visitedIsland[land] = true;
							size += island.get(land);
						}
					}

					maxSize = Math.max(maxSize, size);
				}
			}
		}

		if (maxSize == 1 && !island.isEmpty())
			maxSize = n * n;

		return maxSize;
	}
}
