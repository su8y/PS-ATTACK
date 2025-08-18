#include <bits/stdc++.h>

using namespace std;
#define endl '\n'

/* 문제: https://www.acmicpc.net/problem/7490 0 만들기
 *
 * 접근법:
 * N = dfs로 접근한다.
 * dfs(1, 총합, "1")
 *
 */

#define FASTIO cin.tie(0)->sync_with_stdio(0);

static int N;

int history;

void dfs(int x, int sum, string str, int history) {
    if (x == N) {
        if (sum == 0) cout << str << endl;
        return;
    }

    int prev_val = sum - history;

    int concat_val = abs(prev_val * 10) + (x + 1);

    int next_value = sum - prev_val + concat_val;
    if (prev_val < 0) {
        next_value = sum - prev_val - concat_val; // 이전부호를 따라갸아 함.
    }

    dfs(x + 1, next_value, str + " " + to_string(x + 1), sum + prev_val);
    
    dfs(x + 1, sum + (x + 1), str + "+" + to_string(x + 1), sum);
    dfs(x + 1, sum - (x + 1), str + "-" + to_string(x + 1), sum);
}

int main() {
    int t;
    cin >> t;
    for (int i = 0; i < t; i++) {
        cin >> N;
        history = 0;

        dfs(1, 1, "1", 0);
        cout << endl;
    }
    return 0;
}
