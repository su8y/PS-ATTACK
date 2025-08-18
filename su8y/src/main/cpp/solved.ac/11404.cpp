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
//#define INT_MAX 2147483647

int N, M;
int adj[101][101];


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    memset(adj, 0x3f, sizeof(int)*101 * 101);
    for (int i = 0; i < M; ++i) {
        int start, end, cost;
        cin >> start >> end >> cost;
        adj[start][end] = min(adj[start][end],cost);
    }
    //자기 자신 0으로 초기화
    for (int i = 1; i < N + 1; ++i) adj[i][i] = 0;

    //i번째를 거쳐서 j에서 k로 가는경우를 한번씩 탐색
    for (int i = 1; i < N + 1; ++i) {
        for (int j = 1; j < N + 1; ++j) {
            for (int k = 1; k < N + 1; ++k) {
                int changeCost = adj[j][i] + adj[i][k];
                adj[j][k] = min(adj[j][k], changeCost);
            }
        }
    }
    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= N; ++j) {
            if(adj[i][j] > 999999999){
                cout << 0 << " ";
                continue;
            }
            cout << adj[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}

