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
int tmp;
vector<int> arr;
bool chk[8] = {false};

void dfs(vector<int> arrays) {
    if (arrays.size() >= M) {
        for (int i = 0; i < M; ++i) {
            cout << arrays[i] << " ";
        }
        cout << endl;
        return;
    }
    //한번 입력된것에대한 확인용 tmp
    int tmp = -1;
    for (int i = 0; i < N; ++i) {
        if (chk[i] ||tmp == arr[i]) continue;
        arrays.push_back(arr[i]);
        tmp = arr[i];
        chk[i] = true;
        dfs(arrays);
        chk[i] = false;
        arrays.pop_back();
    }

}

void solve() {
    cin >> N >> M;
    arr.resize(N);
    for (int i = 0; i < N; ++i) {
        cin >> arr[i];
    }
    std::sort(arr.begin(), arr.end());
    vector<int> dfsArr;
    tmp = -1;
    dfs(dfsArr);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solve();


    return 0;
}

