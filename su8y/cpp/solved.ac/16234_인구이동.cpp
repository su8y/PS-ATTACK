#include <bits/stdc++.h>

using namespace std;

#define pint pair<int,int>
/* 문제: https://www.acmicpc.net/problem/16234 인구이동 
 * 
 * 풀이방법:
 * 완전 탐색으로 모든 경우의 수를 다 체크한다 
 * O(N^2)
 */
int dy[4] = {1, -1, 0, 0};
int dx[4] = {0, 0, 1, -1};

bool isInCount(int cnt, int cnt2, int l, int r) {
    int diff = abs(cnt - cnt2);
    return l <= diff && diff <= r;
}

bool visited[51][51];
int arr[51][51];
int n, l, r;

bool bfs(int y, int x, int l, int r) {
    vector<pint > history;
    queue<pint > q;
    q.push({y, x});

    int sum = 0;
    while (!q.empty()) {
        auto [y, x] = q.front();
        q.pop();
        if (visited[y][x]) continue;
        history.push_back({y, x});
        visited[y][x] = true;
        sum += arr[y][x];

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
            if (isInCount(arr[y][x], arr[ny][nx], l, r)) {
                q.push({ny, nx});
            }
        }
    }
    if (history.size() < 2) return false;

    std::for_each(history.begin(), history.end(), [&](pint coord) {
        arr[coord.first][coord.second] = sum / history.size();
    });

    return true;

}

bool solve(int l, int r) {
    bool flag = false;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (visited[i][j]) continue;
            flag |= bfs(i, j, l, r);
        }
    }
    return flag;
}

int main() {
    cin >> n >> l >> r;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cin >> arr[i][j];

    int cnt = 0;
    while (true) {
        memset(visited, 0, sizeof visited);
        bool isChanged = solve(l, r);
        if (!isChanged) break;
        cnt++;
    }
    cout << cnt << endl;

    return 0;
}
