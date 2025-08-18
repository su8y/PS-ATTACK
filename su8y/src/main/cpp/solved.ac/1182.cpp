#include "bits/stdc++.h"

using namespace std;
#define ll long long;
#define endl "\n";

#ifdef BOJ
#define debug(x)
#else
#define debug(x) \
    cout << "[DEBUG] " << #x << " == " << x << '\n';
#endif

int N, S;
int cnt = 0;
vector<int> arr;
bool *visited;


void input() {
    cin >> N >> S;
    arr.resize(N);
    for (int i = 0; i < N; ++i) cin >> arr[i];
}

void dfs(int n, int sum) {
    if (sum == S) {
        cnt += 1;
    }
    for (int i = n + 1; i < N; ++i) {
        if (visited[i] == true)continue;
        visited[i] = true;
        dfs(i, sum + arr[i]);
        visited[i] = false;
    }

}


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    visited = new bool[N];
    for (int i = 0; i < N ; ++i) {
        visited[i] = true;
        dfs(i, arr[i]);
        visited[i] = false;
    }
    cout << cnt;


    return 0;
}

