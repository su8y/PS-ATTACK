#include <bits/stdc++.h>

#define fastio cin.tie(0)->sync_with_stdio(0)
#define pii pair<int, int>

using namespace std;
/* 문제: https://www.acmicpc.net/problem/15683 감시



모든 경우의 수를 돌면서 시뮬레이션을 함.

더 좋은 방법으로는 angle의 조합을 만든후 그 상태로 check하면서 count 세기
- 시뮬레이션을 할때 check배열의 공간 복잡도를 copy를 하면서 지속적으로 늘어남

시간 복잡도:
8개의 k를 4가지 방향으로 돌리면서 테스트 4^8, O(4^k)
각 공간을 쭉 뻗어가며 check하기 4*8 O(k)

testcase:
8 8
0 0 0 0 0 0 0 1
0 1 0 0 0 0 0 0
0 0 0 1 0 0 0 0
0 0 1 0 0 0 0 0
0 0 0 0 0 0 1 0
0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 0
*/

const int dirs[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 우 하 좌 상

const vector<int> cctvs_dir[6] = {{},     {0},       {0, 2},
                                  {0, 3}, {0, 2, 3}, {0, 1, 2, 3}};
vector<pii> cctvs;

int n, m, a, board[8][8];
bool checked[8][8];

int countUnChecked();
void check(int y, int x, int kind, int angle);  // cctv 방향 끝까지 탐색

int new_dfs(vector<int>& angle, const int k) {
  int ret = INT_MAX;
  if (angle.size() == k) {
    memset(checked, 0, sizeof checked);

    for (int i = 0; i < k; i++) {
      int agl = angle[i];
      auto [y, x] = cctvs[i];
      int kind = board[y][x];

      check(y, x, kind, agl);
    }
    return countUnChecked();
  }
  for (int i = 0; i < 4; i++) {
    angle.push_back(i);
    ret = min(ret, new_dfs(angle, k));
    angle.pop_back();
  }
  return ret;
}
int main(int argc, char const* argv[]) {
  fastio;
  cin >> n >> m;

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> board[i][j];
      if (board[i][j] != 0 && board[i][j] != 6) {
        cctvs.push_back({i, j});
      }
    }
  }
  int k = cctvs.size();

  vector<int> angles;
  cout << new_dfs(angles, k) << endl;

  return 0;
}

void check(int y, int x, int kind, int angle) {
  checked[y][x] = 1;

  for (int i = 0; i < cctvs_dir[kind].size(); i++) {
    auto d = dirs[(cctvs_dir[kind][i] + angle) % 4];
    int j = 1;

    while (true) {
      int ny = y + d[0] * j;
      int nx = x + d[1] * j;
      if (ny < 0 || ny >= n || nx < 0 || nx >= m) break;
      if (board[ny][nx] == 6) break;  // 벽을 만났을 때
      checked[ny][nx] = 1;
      j++;
    }
  }
}

int countUnChecked() {
  int cnt = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (!checked[i][j]) {
        if (board[i][j] == 6) continue;
        cnt++;
      }
    }
  }
  return cnt;
}
/*
int countUnChecked(const vector<vector<bool>>& checked) {
  int cnt = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (!checked[i][j]) {
        if (board[i][j] == 6) continue;
        cnt++;
      }
    }
  }
  return cnt;
}

void check(int y, int x, int kind, vector<vector<bool>>& checked, int angle) {
  checked[y][x] = 1;

  for (int i = 0; i < cctvs_dir[kind].size(); i++) {
    auto d = dirs[(cctvs_dir[kind][i] + angle) % 4];
    int j = 1;

    while (true) {
      int ny = y + d[0] * j;
      int nx = x + d[1] * j;
      if (ny < 0 || ny >= n || nx < 0 || nx >= m) break;
      if (board[ny][nx] == 6) break;  // 벽을 만났을 때
      checked[ny][nx] = 1;
      j++;
    }
  }
}

int dfs(int idx, int k, vector<vector<bool>> checked) {
  int ret = INT_MAX;
  if (idx == k) {
    return countUnChecked(checked);
  }

  auto [y, x] = cctvs[idx];
  int kind = board[y][x];
  for (int angle = 0; angle < 4; angle++) {
    vector<vector<bool>> copy = checked;
    for (int j = 0; j < cctvs_dir[kind].size(); j++) {
      check(y, x, kind, copy, angle);  // i = angle
    }
    ret = min(ret, dfs(idx + 1, k, copy));
  }
  return ret;
}
*/
