/*
* https://www.acmicpc.net/problem/14940 쉬운 최단거리
 *
 */
#include <bits/stdc++.h>
#define FASTIO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define ll long long
using namespace std;

int n, m, v;
int board[1001][1001];
int min_board[1001][1001];
int dy[4] = {-1, 1, 0, 0};
int dx[4] = {0, 0, -1, 1};
typedef pair<int, int> coord;

class Coord {
public:
    int y;
    int x;

    Coord(int _y, int _x): y(_y), x(_x) {
    }
};

bool isOutOfRange(int y, int x) {
    return y >= n || y < 0 || x >= m || x < 0;
}

void solve(pair<int,int> start) {
    memset(min_board, -1, sizeof min_board);
    queue<pair<pair<int, int>, int> > q;
    q.push({start, 0});
    min_board[start.first][start.second] = 0;

    while (!q.empty()) {
        auto [coord, dist] = q.front();
        auto [y,x] = coord;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (isOutOfRange(ny, nx) || board[ny][nx] == 0 || min_board[ny][nx] != -1) continue;

            min_board[ny][nx] = dist + 1;
            q.push({{ny, nx}, dist + 1});
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if(min_board[i][j] == -1) {
                if(board[i][j] == 0) cout << 0 << ' ';
                else cout << -1 << ' ';
            }else {
                cout << min_board[i][j] << ' ';
            }
        }
        cout << '\n';
    }
}

int main() {
    cin.tie(0);
    cin >> n >> m;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> board[i][j];

    pair<int,int> start;
    // find 2
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if(board[i][j] == 2) start = {i,j};
    solve(start);

    return 0;
}
