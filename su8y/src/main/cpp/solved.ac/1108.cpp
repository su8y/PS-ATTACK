#include "bits/stdc++.h"

using namespace std;

#ifdef BOJ
#define debug(x)  ((void)0)
#else
#define debug(x) std::cout << "[Debug] " << #x <<" is " << x << '\n'
#endif
typedef pair<int, int> pii;
#define pss pair<int, string>
#define ll long long
#define endl "\n"

int N, M, sccCounter, vertexConter,num;
map<string, int> nameMap;

vector<vector<int> > adj;
vector<vector<pair<int,int>> > scc_adj;
vector<int> discovered,sccId;

vector<long long> countAdj;
stack<int> s;

int dfs(int here) {
    int ret = discovered[here] = vertexConter++;
    s.emplace(here);

    for (auto there : adj[here]) {
        // 연결된 노드
        //아직 방문하지 않은 노드라면
        if (discovered[there] == -1) ret = min(ret, dfs(there));
            //sccId가 아직 분리가 돼지않은경우 : 즉 결합요소로 분리가 되지 않은 경우라면
        else if (sccId[there] == -1) ret = min(ret, discovered[there]);
    }
    //다시 들어왔는데 사이클이 존재한다면 ?
    if (ret == discovered[here]) {
        while (1) {
            int t = s.top(); // stack top을 가져온다.
            s.pop();
            sccId[t] = sccCounter;
            if (t == here) break;
        }
        sccCounter++;
    }
    return ret;
}


void solve() {
    //3000개의 사이트

    adj.resize(2501);
    cin >> N;
    for (int i = 0; i < N; ++i) {
        string parent;
        cin >> parent >> M;
        if (nameMap.find(parent) == nameMap.end()) nameMap[parent] = num++;
        for (int j = 0; j < M; ++j) {
            string visitor;
            cin >> visitor;
            if (nameMap.find(visitor) == nameMap.end()) nameMap[visitor] = num++;
            adj[nameMap[visitor]].push_back(nameMap[parent]);
        }
    }

    string result;
    cin >> result;
    if (nameMap.find(result) == nameMap.end()) nameMap[result] = num++;

    discovered = sccId = vector<int>(2501, -1);
    for (int i = 0; i < num; i++) {
        if (discovered[i] == -1) dfs(i);
    }

    //모든점점을 돌아다니면서 scc를 찾는다. scc 찾는 조건 다시 돌아온경우 그 돌아온 경로의 이름으로
    // 그리고 나서 모든 scc에 대해서 해당 scc가 내가 포함되어있다면 무시하고

    // 다른 scc에 위상정렬을 통해서 거꾸로 경로추적을 한다.
    scc_adj.resize(2501);
    for (int here = 0; here < num; here++) {
        for (auto there: adj[here]) {
            if (sccId[here] != sccId[there]) {
                scc_adj[sccId[here]].emplace_back(here, there);
            }
        }
    }
    int wt = nameMap[result];
    countAdj.resize(2501, 1);
    for (int i = sccCounter - 1; i ; --i) {
        for (auto [a, b]: scc_adj[i]) {
            countAdj[b] += countAdj[a];

        }
    }
    cout << countAdj[wt] << endl;

}


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solve();

    return 0;
}


