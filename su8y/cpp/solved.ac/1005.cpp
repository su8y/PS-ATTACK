#include "bits/stdc++.h"

using namespace std;
#ifdef BOJ
#define debug(x)  ((void)0)
#define debugArr(c) ((void)0)
#else
#define debug(x) std::cout << "[DEBUG] " << #x <<" is " << x << '\n'
#define debugArr(c){ std::cout << "[DEBUG] "<< #c << ": "; for (const auto& elem : c) cout << elem << ", "; cout << '\n';}
#endif
#define FOR(i, N) for(int i=0; i<N;i++)
#define FFOR(i, N) for(int i=1; i<=N;i++)
#define FORN(N) while(N--)
#define FAST cin.tie(NULL);cout.tie(NULL); ios::sync_with_stdio(false)
#define ll long long
#define endl "\n"
typedef pair<int, int> pii;
#define MAX 1001

int T, N, M, a, b;
vector<vector<int> > adj;
int indegree[MAX];
int cost[MAX];
ll cache[MAX];

int main() {
    FAST;
    cin >> T;
    FORN(T) {
        cin >> N >> M;
        memset(indegree, 0, sizeof(int) * MAX);
        memset(cache, 0, sizeof(int) * MAX);
        adj.clear();
        adj.resize(N + 1);
        FFOR(i, N) {
            cin >> cost[i];
        }
        FFOR(i, M) {
            cin >> a >> b;
            adj[a].push_back(b);
            indegree[b]++;
        }


        queue<int> q;
        FFOR(i, N) if (indegree[i] == 0) q.push(i);
        while (!q.empty()) {
            queue<int> tmp;
            int here = q.front();
            q.pop();
            for (int there: adj[here]) {
                ll &ref = cache[there];
                ref = max(ref, cache[here] + cost[here]);
                if(--indegree[there] == 0) q.push(there);
            }
        }
        int want;
        cin >> want;
        cout << cache[want]+cost[want] << endl;
    }
    return 0;
}

