#include <bits/stdc++.h>

#define pii Pair<int, int>
#define pis Pair<int, string>
#define pdd Pair<double, double>
#define vvi vector<vector<int>>
#define FAST_IO cin.tie(NULL);cout.tie(NULL);ios::sync_with_stdio(false);

#define PRECODE template<typename T1, typename T2> struct Pair{ T1 y; T2 x; };
PRECODE

using namespace std;

#define MIN_VALUE 3
#define MAX_VALUE 11
int n, m;
string pType = "RB.#O"; // 공간,벽,구벙,빨강,파란공
char board[MAX_VALUE][MAX_VALUE];
int dy[] = {-1, 1, 0, 0};
int dx[] = {0, 0, -1, 1};
bool visited[10][10][10][10];

pair<int, int> piece[3];


void Input() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> board[i][j];
            switch (board[i][j]) {
                case 'R':
                    piece[0] = {i, j};
                    break;
                case 'B':
                    piece[1] = {i, j};
                    break;
                case 'O':
                    piece[2] = {i, j};
                    break;
            }
        }
    }
}

bool IsGameEnd();

bool IsOutOfRange(int, int);

bool IsTurnOff(int, int);

int Game(int);

void Print() {
    cout << "printf" << endl;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << board[i][j];
        }
        cout << endl;
    }
}

int total = INT_MAX;

bool IsVisited(int y, int x, int y2, int x2) {
    return visited[y][x][y2][x2];

}

void dfs(int deps) {
    if (deps > 10) return;
    if (IsGameEnd()) {
        total = min(total, deps);
        return;
    }
    // Print();

    if (IsVisited(piece[0].first, piece[0].second, piece[1].first, piece[1].second))return;
    for (int i = 0; i < 4; i++) {
        char backup_board[MAX_VALUE][MAX_VALUE];
        memcpy(backup_board, board, sizeof(board));
        pair<int, int> bu_red = piece[0];
        pair<int, int> bu_blue = piece[1];
        //  back tracking 적용
        visited[piece[0].first][piece[0].second][piece[1].first][piece[1].second] = true;
        int gameResult = Game(i);
        if (gameResult == 0) continue; // 안 움직였다면 전 상태랑 똑같으니까 빠지기

        dfs(deps + 1);
        visited[piece[0].first][piece[0].second][piece[1].first][piece[1].second] = false;
        piece[0] = bu_red;
        piece[1] = bu_blue;

        memcpy(board, backup_board, sizeof(board));

    }

}


int main() {
    FAST_IO;
    cin >> n >> m;


    Input();
    dfs(0);

    int result = (total == INT_MAX) ? -1 : total;
    cout << result << "\n";


    return 0;

}

bool IsAliveGoal(int y, int x) {
    pair<int, int> p = {y, x};
    pair<int, int> goal = piece[2];

    if (p == goal) return true;
    return false;
}

/* 움직였는지 이력*/
int Game(int d) {
    bool flag = false;
    for (int i = 0; i < 3; i++) { // red와 blue를 이동시킨다.
        int ni = i % 2; // 이것은 총 3번을 움직임으로써 두공이 어떤 상황이든 끝까지 민다. 모듈러연산
        while (true) {
            int y = piece[ni].first;
            int x = piece[ni].second;
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (IsAliveGoal(y, x)) break;
            if (IsOutOfRange(ny, nx)) continue;
            if (IsTurnOff(ny, nx)) break; // while문 종료조건 끝에 다다랐을때


            /* 이동 */
            flag = 1;
            char cur = board[y][x];
            board[y][x] = '.';

            if (board[ny][nx] != 'O') { // 공이들어간상태
                board[ny][nx] = cur;
            }

            piece[ni].first = ny;
            piece[ni].second = nx;
        }
    }
    return flag;
}

bool IsGameEnd() {
    pair<int, int> red = piece[0];
    pair<int, int> blue = piece[1];
    pair<int, int> goal = piece[2];
    if (red == goal && blue != goal) return true;
    return false;
}

bool IsOutOfRange(int y, int x) {
    return y < 0 || y >= n || x < 0 || x >= m;
}

bool IsTurnOff(int y, int x) {
    char p = board[y][x];
    return p == 'B' || p == 'R' || p == '#';
}
