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
vector<vector<int> > graph;

int betweenSum(int y1, int x1, int y2, int x2) {
    int result = 0;
    for (int i = y1; i <= y2; i++) {
        int bigSum = graph[i][x2];
        int smallSum =  graph[i][x1-1];
        result += bigSum - smallSum;
    }
    return result;
}

void solve() {
    cin >> N >> M;
    graph.resize(N + 1);
    for (int i = 0; i < N + 1; ++i) {
        graph[i].resize(N + 1, 0);
    }
    for (int i = 1; i < N +1; ++i) {
        int sum = 0;
        for (int j = 1; j < N+1; ++j) {
            int tmp;
            cin >> tmp;
            sum += tmp;
            graph[i][j] = sum;
        }
    }

    for (int i = 0; i < M; i++) {
        int y1, x1, y2, x2;
        cin >> y1 >> x1 >> y2 >> x2;
        cout << betweenSum(y1, x1, y2, x2) << endl;
    }

}


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solve();

    return 0;
}

