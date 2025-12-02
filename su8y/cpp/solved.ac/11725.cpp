#include "bits/stdc++.h"

using namespace std;
#define ll long long;
#define endl "\n";

#ifdef BOJ
#define debug(x)  ((void)0)
#else
#define debug(x) std::cout << "[Debug] " << #x <<" is " << x << '\n'
#endif
#define pii pair<int, int>
#define pss pair<int, string>

int N, M;
vector<vector<int> > adj;
int *result;

void solve() {
    cin >> N;
    adj.resize(N + 1);
    result = new int[N + 1];
    memset(result, -1, sizeof(int) * (N + 1));
    for (int i = 0; i < N -1; ++i) {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    queue<int> q;



    q.push(1);
    result[1] = 1;
    while (!q.empty()) {
        int parent = q.front();
        q.pop();
        for (int i = 0; i < adj[parent].size(); ++i) {
            int child = adj[parent][i];
            if (result[child] != -1) continue;
            q.push(child);
            result[child] = parent;
        }
    }
    debug("출력");
    for (int i = 2; i < N + 1; i++) {
        cout << result[i] << endl;
    }

}


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solve();

    return 0;
}

