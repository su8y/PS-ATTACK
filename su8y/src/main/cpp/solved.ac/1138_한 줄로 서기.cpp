#include <bits/stdc++.h>

using namespace std;

/*
 * https://www.acmicpc.net/problem/1138 한 줄로 서기
 * [i][j]는 [i-1][j] 보다 크다.
 */

int line_info[10] = {0,};
bool visited[10] = {0,};
int n;

bool isCollect(const vector<int>& v) {
    for (int i = 0; i < n; i++) {
        int count = 0;
        for (int j = 0; j < i; j++) {
            if (v[i] < v[j]) count++;
        }
        if (count != line_info[v[i] - 1]) {
            return false;
        }
    }
    return true;

}

void dfs(vector<int>& v) {
    if (v.size() == n) {
        if (isCollect(v)) {
            for (auto &u: v) {
                cout << u << " ";
            }
            cout << endl;
        }
        return;
    }


    for (int i = 0; i < n; i++) {
        if (visited[i]) continue;
        visited[i] = true;
        v.push_back(i + 1);
        dfs(v);
        v.pop_back();
        visited[i] = false;

    }
    return;
}

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++)cin >> line_info[i];

    vector<int> v = vector<int>();
    dfs(v);

    return 0;
}
