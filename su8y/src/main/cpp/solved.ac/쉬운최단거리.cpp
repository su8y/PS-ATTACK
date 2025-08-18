#include <iostream>
#include <queue>
#include <vector>
/*
 * 최소힙 priority_queue 사용
 */
using namespace std;


int N, M;
int map[1001][1001];
int visited[1001][1001];
// Goal Position
int y, x;
// desc check

int dirs[4][2] = {
    {0, 1}, {1, 0}, {0, -1}, {-1, 0}
};

void solve() {
    // pair: yx, deps
    queue<pair<int, int> > q;

    q.push({y, x});
    visited[y][x] = 1;

    while (!q.empty()) {
        pair<int, int> front = q.front();
        q.pop();

        int currentY = front.first, currentX = front.second;

        for (int i = 0; i < 4; i++) {
            int nextY = currentY + dirs[i][0], nextX = currentX + dirs[i][1];
            if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M &&
                visited[nextY][nextX] == 0 && map[nextY][nextX] != 0) {
                visited[nextY][nextX] = visited[currentY][currentX] + 1;
                q.push({nextY, nextX});
            }
        }
    }

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            int outNumber =  visited[i][j] -1;
            if(map[i][j] == 0) {
                outNumber = 0;
            }
            cout << outNumber  << " ";
        }
        cout << "\n";
    }
}

void input() {
    cin >> N >> M;

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> map[i][j];
            if (map[i][j] == 2) { y = i, x = j; }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    input();
    solve();
}
