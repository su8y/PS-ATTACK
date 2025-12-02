#include "bits/stdc++.h"

using namespace std;
#define ll long long;
#define endl "\n";

int N;


vector<vector<int> > input;

bool compare(int a, int b){
    return a > b;
}
int dfs(int n) {
    if (input[n].size() == 0) return 0; // 단말노드여서 1이다.
    vector<int> childs; // 걸리는 시간을 가져온다.
    for (auto child: input[n]) {
        childs.push_back(dfs(child));
    }
    std::sort(childs.begin(), childs.end(),compare);
    int maxValue = 0;
    for (int i = 0; i < childs.size(); ++i) {
        maxValue = max(maxValue,childs[i] + (i + 1)); // 걸리는시간
    }
    return maxValue;

}

void solve() {
    cin >> N;
    input.resize(N);
    for (int i = 0; i < N; ++i) {
        int parentNode;
        cin >> parentNode; // 직속상관을 입력한다.
        if(parentNode == -1) continue;
        input[parentNode].push_back(i); // 직속상관과 연결한다.
    }
    cout << dfs(0)<<endl;

}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solve();
    return 0;
}

