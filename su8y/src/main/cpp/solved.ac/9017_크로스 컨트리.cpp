/*
* https://www.acmicpc.net/problem/9017 크로스 컨트리
 *
 */
#include <bits/stdc++.h>
using namespace std;

int cnt[201];
bool cmp(pair<int, vector<int>> &a, pair<int, vector<int>> &b) {
    int a_sum = accumulate(a.second.begin(), a.second.begin() +4, 0);
    int b_sum = accumulate(b.second.begin(), b.second.begin() +4, 0);
    if( a_sum != b_sum) return a_sum < b_sum;
    return a.second[4] < b.second[4];
}
void solve(vector<int>& arr, int len) {
    map<int, vector<int>> h;

    memset(cnt, 0, sizeof cnt);
    for(int i=0;i<len;i++) {
        cnt[arr[i]]++;
        if(cnt[arr[i]] == 6) {
            h[arr[i]] = vector<int>();
        }
    }

    int rank = 1;
    for(int i=0;i<len;i++) {
        if(cnt[arr[i]] == 6) {
            h[arr[i]].push_back(rank++);
        }
    }
    vector<pair<int,vector<int>>> v(h.begin(), h.end());
    sort(v.begin(), v.end(), cmp);

    cout << v[0].first << endl;
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(false);

    int n,m;
    vector<int> arr;
    cin >> n;
    for (int i=0;i<n;i++) {
        cin >> m;
        arr.resize(m);
        for(int j=0;j<m;j++) {
            cin >> arr[j];
        }
        solve(arr, m);
    }

    return 0;
}
