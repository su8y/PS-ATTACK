#include <bits/stdc++.h>
using namespace std;

/* https://www.acmicpc.net/problem/16928 뱀과 사다리 게임
 * - 1, 6 사이의 주사위를 굴릴수 있음. 주사위를 굴리는 것에 대해서 시간 증가.
 * - reward와 trap 을 밝으면 이동. 시간은 증가하지 않음.
 * - visit배열을 통해서 이미 도착했는지를 판별할 수 있다.
 * - 이미 방문을 했던 지점이라면 또 방문할 필요가 없다. (넣는 순서가 아닌 최소 시간을 기준으로 함.) // 이미 들어가잇던 내용이
 * - 동시에 두 가지의 reward , trap을 가지고있는 경우는 없다.
 */

#define pint pair<int,int>

class compare {
public:
    bool operator()(pint &a, pint &b) {
        if (a.second == b.second) return a.first < b.first;
        return a.second > b.second;
    }
};

int n, m, board[101], K = 100, visited[101];
map<int, int> trap;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(false);
    cin >> n >> m;
    int a, b;
    for (int i = 0; i < n + m; i++) {
        cin >> a >> b;
        trap[a] = b;
    }

    fill(visited, visited + 101, INT_MAX);
    priority_queue<pint, vector<pint >, compare> q;
    q.push({1, 0});

    while (!q.empty()) {
        auto [cur, time] = q.top(); q.pop();
        if (visited[cur] <= time) continue;
        visited[cur] = time;
        if (trap.count(cur)) {
            q.push({trap[cur], time});
            continue;
        }
        if (cur == K) {
            cout << time << endl;;
            break;
        }

        for (int i = 1; i <= 6; i++) {
            int next = cur + i;
            if (next > 100) continue;
            q.push({next, time + 1});
        }
    }

    return 0;
}
