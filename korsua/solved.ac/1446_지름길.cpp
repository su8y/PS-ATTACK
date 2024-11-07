#include <bits/stdc++.h>
using namespace std;

/* https://www.acmicpc.net/problem/1446 지름길
- 일 차원 배열의 BFS
0 -> D 까지 갈때의 최단 거리를 알아보면 된다.
#-#-# 단, 지름길이 더 빠를 거라는 보장은 없다.
queue<현재위치, 총 이동한 거리>
단, 역주행은 할 수 없으니 D보다 크다면 실패한 지름길이다.
  1. 애초에 지름길 리스트에 넣지않기.
  2. bfs 로직에서 무시 처리. (o)
*/

int n, m;
typedef pair<int, int> Path; // end, cost
int main() {
    cin.tie(NULL);
    cin >> n >> m;
    vector<vector<Path> > short_path(10001);
    int a, b, c;
    for (int i = 0; i < n; i++) {
        cin >> a >> b >> c;
        short_path[a].push_back({b, c});
    }

    int min_cost = INT_MAX;
    queue<pair<int, int> > q; // 현재 이동한 위치 , 코스트
    q.push({0, 0});
    while (!q.empty()) {
        auto [cur, cost] = q.front(); q.pop();
        if (cur == m) {
            min_cost = min(min_cost, cost);
            continue;
        }
        for (int i = 0; i < short_path[cur].size(); i++) {
            auto [end,short_cost] = short_path[cur][i];
            if (end > m || end - cur < short_cost) continue;

            q.push({end, cost + short_cost});
        }
        q.push({cur+1,cost+1});
    }
    cout << min_cost << '\n';
    return 0;
}
