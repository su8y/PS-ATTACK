#include <bits/stdc++.h>

using namespace std;

/* https://www.acmicpc.net/problem/5972 택배 배송
 * 한 노드에서 한 노드로 가는 가중치를 포함한 최단경로를 구하는 문제 (다익스트라) O(E logV)
 */

#define FASTIO cin.tie(0); cout.tie(0); ios::sync_with_stdio(false);
#define pint pair<int,int>

int n, m;

vector<vector<pint > > edge;

class compare {
public:
    bool operator()(pint &a, pint &b) {
        return a.second > b.second;
    }
};

int main() {
    FASTIO
    cin >> n >> m;
    edge = vector<vector<pint > >(n + 1, vector<pint >());
    int a, b, c;
    for (int i = 0; i < m; i++) {
        cin >> a >> b >> c;
        edge[a].push_back({b, c});
        edge[b].push_back({a, c});
    }

    priority_queue<pint, vector<pint >, compare> q;
    q.push({1, 0});
    int visited[n + 1];
    memset(visited, 0x7f, sizeof visited);

    while (!q.empty()) {
        auto [cur, cost] = q.top();
        q.pop();
        if (visited[cur] <= cost) continue;
        visited[cur] = cost;

        for (int i = 0; i < edge[cur].size(); i++) {
            pint next = edge[cur][i];
            q.push({next.first, cost + next.second});
        }
    }
    cout << visited[n];


    return 0;
}
