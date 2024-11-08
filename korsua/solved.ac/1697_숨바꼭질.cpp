#include <bits/stdc++.h>

using namespace std;

/* https://www.acmicpc.net/problem/1697 숨바꼭질 */
int main() {
    int n, k;
    cin >> n >> k;

    queue<pair<int, int>> q;
    bool visited[100001] = {0,};
    q.push({n, 0});
    visited[n] = 1;

    while (!q.empty()) {
        auto [cur, time] = q.front();
        q.pop();
        if (cur == k) {
            cout << time << endl;
            break;
        }
        if (cur + 1 <= 100000 && !visited[cur + 1]) {
            q.push({cur + 1, time + 1});
            visited[cur + 1] = 1;
        }
        if (cur - 1 >= 0 && !visited[cur - 1]) {
            q.push({cur - 1, time + 1});
            visited[cur - 1] = 1;
        }
        if (cur*2 <= 100000 && !visited[cur * 2]) {
            q.push({cur * 2, time + 1});
            visited[cur * 2] = 1;
        }
    }
    return 0;
}