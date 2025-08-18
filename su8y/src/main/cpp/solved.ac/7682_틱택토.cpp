#include <bits/stdc++.h>

using namespace std;

/* 문제: https://www.acmicpc.net/problem/7682 틱택토
 *
 * 접근 :
 * 틱택토 게임에서 발생할 수 있는 상태인지 확인한다.
 * 0 1 2
 * 3 4 5
 * 6 7 8
 *
 * 대각선
 * 0 4 8
 * 2 4 7
 *
 * 한줄
 * 0 -> 2
 * 3 -> 5
 * 6 -> 8
 * 0+3
 * 1+3
 * 2+3
 *
 * 풀이 방법:
 * 나이브하게 완탐
 *  시간복잡도 계산, 게임이 끝났는지 계산 총 O(1)
 *  모든 경우의 수를 해본다. 9^9
 *  game이 끝났는데 X와 O의 카운트가 0이상이라면 안된다 .
 */

#define FASTIO cin.tie(0)->sync_with_stdio(0);
#define pint pair<int,int>


int end_target[8][3] = {
    {0, 4, 8},
    {2, 4, 6},
    {0, 1, 2},
    {3, 4, 5},
    {6, 7, 8},
    {0, 3, 6},
    {1, 4, 7},
    {2, 5, 8}
};


int visited[9];
string arr;

bool IsEnd() {
    for (int i = 0; i < 8; i++) {
        int target = visited[end_target[i][0]];
        if (target != -1) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (visited[end_target[i][j]] == target) count++;
            }
            if (count == 3) return true;
        }
    }
    for (int i = 0; i < 9; i++) if (visited[i] == -1) return false;

    return true;
}

bool solve(bool is_x_turn, int cnt_x, int cnt_o) {
    bool ret = false;
    if (cnt_x < 0 || cnt_o < 0) return false;
    if (IsEnd()) {
        if (cnt_x > 0 || cnt_o > 0) return false;
        if (cnt_x == 0 && cnt_o == 0) return true;
        return false;
    }

    char cur = is_x_turn ? 'X' : 'O';
    for (int i = 0; i < 9; i++) {
        if (visited[i] != -1) continue;
        if (arr[i] == cur) {
            visited[i] = is_x_turn ? 1 : 0;
            ret |= solve(!is_x_turn, cnt_x - is_x_turn, cnt_o - !is_x_turn);
            visited[i] = -1;
        }
    }
    return ret;
}

bool solveAll(int cnt_x, int cnt_o) {
    memset(visited, -1, sizeof visited);
    for (int i = 0; i < 9; i++) {
        if (arr[i] == 'X') {
            visited[i] = 1;
            if (solve(false, cnt_x - 1, cnt_o)) return true;
            visited[i] = -1;
        }
    }
    return false;
}

int main() {
    FASTIO
    while (true) {
        cin >> arr;
        if (arr == "end") break;
        int cnt_x = 0, cnt_o = 0;
        for (int i = 0; i < 9; i++) {
            if (arr[i] == 'X') cnt_x++;
            if (arr[i] == 'O') cnt_o++;
        }

        cout << (solveAll(cnt_x, cnt_o) ? "valid\n" : "invalid\n");
    }
    return 0;
}
