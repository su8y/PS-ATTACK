#include <bits/stdc++.h>

using namespace std;
#define endl '\n'

/* https://www.acmicpc.net/problem/2668 숫자고르기
 *
 * 사이클을 구한다.
 */

#define FASTIO cin.tie(0)->sync_with_stdio(0);


int n, arr[101] = {0,};
bool visited[101] = {0,};

vector<int> dfs(int x, vector<int> &v) {
    int next = arr[v.back()];

    if (next > n) return {};
    if (visited[next]) {
        if (x == next) return v;
        return {};
    }
    visited[next] = 1;
    v.push_back(next);
    auto ret= dfs(x, v);
    visited[next] =0;
    return ret;
}

set<int> dfsAll() {
    set<int> s;
    for (int i = 1; i <= n; i++) {
        if (visited[i]) continue;
        vector<int> v = {i};
        visited[i] = 1;
        auto res = dfs(i, v);
        visited[i] = 0;

        /* 결과 값에 대한 후처리 */
        for_each(res.begin(), res.end(), [&](int &u) {
            s.insert(u);
            visited[u] = 1;
        });
    }

    return s;
}

int main() {
    FASTIO
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> arr[i];

    auto s = dfsAll();
    cout << s.size() << endl;
    for (auto &u: s) {
        cout << u << endl;
    }

    return 0;
}
