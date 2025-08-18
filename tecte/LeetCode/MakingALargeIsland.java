/*
 * 작성일	: 2023년 1월 3일
 * 문 제 	: LeetCode 827 - MakingALargeIsland
 * 		  https://leetcode.com/problems/making-a-large-island/
 * 
 * 문제 풀이
 *  grid를 순차적으로 돌면서 1(육지)인 경우 대표 원소가 있는지 확인하고 없으면 새로운 대표 원소 만들어서 dfs로 해당 육지의 땅 크기를 구함
 * 	대표 원소는 hashMap에 저장(key : 대표 원소, value : 크기)
 * 	0(바다)인 경우 4방향을 검사해 육지가 있으면 해당 육지들의 대표 원소 합 + 1을 최대 크기와 비교
 * 	grid를 다 돌면 최대 크기를 반환
 */

package _2022_12_22;

import java.util.Arrays;
import java.util.HashMap;

public class MakingALargeIsland {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int grid[][] = { { 1, 0 }, { 0, 1 } }; // Test Case1
//		int grid[][] = { { 1, 1 }, { 1, 0 } }; // Test Case2
//		int grid[][] = { { 1, 1 }, { 1, 1 } }; // Test Case3
//		int grid[][] = { { 1, 1, 1, 0, 1 }, { 1, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 1, 1, 1 },
//				{ 1, 0, 1, 1, 1 } }; // Test Case4
//		int grid[][] = { { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 1, 1, 0, 1, 0 },
//				{ 0, 0, 0, 0, 1 } }; // Test Case5

		System.out.println(solution.largestIsland(grid));
	}
}

// 제출 코드
class Solution {
	HashMap<Integer, Integer> island = new HashMap<Integer, Integer>();
	int dx[] = { -1, 0, 1, 0 };
	int dy[] = { 0, 1, 0, -1 };
	int grid[][];

	public int largestIsland(int[][] grid) {
		this.grid = grid;
		int n = grid.length;
		int maxSize = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) { // 대표 원소가 없는 육지인 경우 대표 원소 설정
					addIsland(i, j);
				} else if (grid[i][j] == 0) { // 바다인 경우
					boolean visitedIsland[] = new boolean[island.size() + 2];
					int size = 1;

					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (nx < 0 || nx >= n || ny < 0 || ny >= n)
							continue;

						int land = grid[nx][ny];
						if (land == 1) { // 주변에 있는 육지에 대표 원소가 없을 경우 대표 원소 설정
							land = island.size()+2;
							addIsland(nx, ny);
							visitedIsland = Arrays.copyOf(visitedIsland, visitedIsland.length + 1);
							visitedIsland[land] = true;
							size += island.get(land);
						} else if (land > 1 && !visitedIsland[land]) { // 주변에 대표 원소가 있는 육지이고 아직 방문하지 않은 경우
							visitedIsland[land] = true;
							size += island.get(land);
						}
					}

					maxSize = maxSize > size ? maxSize : size;
				}
			}
		}

		// maxSize가 1인데 island가 비어있지 않은 경우는 grid가 전부 육지인 경우
		if (maxSize == 1 && !island.isEmpty())
			maxSize = n * n;

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.printf("%3d", grid[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println(island.entrySet());

		return maxSize;
	}

	public void addIsland(int x, int y) {
		int element = island.size() + 2; // 대표 원소는 2부터 시작

		grid[x][y] = element;
		island.put(element, findIsland(x, y, element));
	}

	public int findIsland(int x, int y, int element) { // 섬의 크기 반환
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
}