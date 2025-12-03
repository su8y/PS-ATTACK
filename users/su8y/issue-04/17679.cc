#include <iostream>
#include <string>
#include <vector>

using namespace std;

int dy[] = {0, 0, 1, 1};
int dx[] = {0, 1, 0, 1};

bool IsSame(int y, int x, vector<string> &board);
void Erase(int y, int x, vector<string> &board);
void Scale(vector<string> &board);

int solution(int m, int n, vector<string> board) {
	int answer = 0;

	int count = 0;
	vector<pair<int, int>> v;
	do {
		// erase
		for (auto &[y, x] : v)
			Erase(y, x, board);
		v.clear();

		// Move
		Scale(board);

		// check
		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++)
				if (IsSame(i, j, board))
					v.push_back({i, j});
		}
	} while (!v.empty());

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++)
			if (board[i][j] == '0')
				answer++;
	}
	return answer;
}

bool IsSame(int y, int x, vector<string> &board) {
	if (board[y][x] == '0')
		return false;
	return board[y][x] == board[y][x + 1] &&
		   board[y + 1][x] == board[y + 1][x + 1] &&
		   board[y][x] == board[y + 1][x + 1];
}
void Erase(int y, int x, vector<string> &board) {
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		board[ny][nx] = '0';
	}
}
void Scale(vector<string> &board) {
	for (int x = 0; x < board[0].size(); x++) {
		for (int y = board.size() - 1; y > 0; y--) {
			if (board[y][x] == '0') {
				int ny = y - 1;
				while (ny > 0 && board[ny][x] == '0')
					ny--;
				board[y][x] = board[ny][x];
				board[ny][x] = '0';
			}
		}
	}
}