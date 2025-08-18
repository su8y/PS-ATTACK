#include "bits/stdc++.h"

using namespace std;
#ifdef BOJ
#define debug(x)  ((void)0)
#define debugArr(c) ((void)0)
#else
#define debug(x) std::cout << "[DEBUG] " << #x <<" is " << x << '\n'
#define debugArr(c){ std::cout << "[DEBUG] "<< #c << ": "; for (const auto& elem : c) cout << elem << ", "; cout << '\n';}
#endif
#define FAST cin.tie(NULL);cout.tie(NULL); ios::sync_with_stdio(false)
#define ll long long
#define endl "\n"
#define FOR(i, N) for(int i=0; i<N;i++)
#define FFOR(i, N) for(int i=1; i<=N;i++)
#define FORN(N) while(N--)
typedef pair<int, int> pii;

int N, M, small, big;
int indegree[32001];
int visited[32001];


vector<vector<int> > adj;

int main() {
    FAST;
    cin >> N >> M;

    adj.resize(N + 1);
    FORN(M) {
        cin >> small >> big;
        adj[small].emplace_back(big);
        indegree[big]++;
    }
    debug(indegree[1]);

    //위상정렬 시작
    queue<int> q;
    FFOR(i,N) {
        if(indegree[i] ==0) q.push(i);
    }

    vector<int> result;
    while(!q.empty()){
        int here = q.front();
        q.pop();
        visited[here] = 1;
        result.push_back(here);
        for (auto &there: adj[here]) {
            debug(here);
            debug(there);
            if((--indegree[there]) == 0){
                q.push(there);
            }
        }
    }
    FFOR(i,N){
        if(visited[i] == 0){
            result.push_back(i);
        }
    }

    for(auto a : result){
        cout << a << " ";
    }
    cout << endl;

    return 0;
}

