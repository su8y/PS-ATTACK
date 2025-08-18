#include <bits/stdc++.h>

using namespace std;

/* https://www.acmicpc.net/problem/2493 탑
 *
 * 자기 자신보다 높이가 높은것을 찾는데 자기자신보다 높이가 낮다면 갱신해준다.
 * 범위를지정하는 window 의사이즈를키워준다. l--;
 * 2*N에 해결할 수 있지만, 
 * 3 2 1 10
 * 0 1 2 2 가 나와서 실패한다.
 *
 *
 * 1 2 3 4 5
 * 1 2 3 4 5
 *
 * 5 4 3 2 1
 * 0 1 2 3 4
 *
 * 5 1 1 1 1
 * 0 1 1 1 1
 *
 *
 * 69574
 * 00224
 * */
void changeIterator(int st, int ed, int k, vector<int> &arr) {
    for (int i = st; i < ed; i++) {
        arr[i] = k;
    }
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(false);
    int n;
    vector<int> arr, history;
    cin >> n;
    arr.resize(n);
    history = vector<int>(n, 0);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    stack<int> s;
    for (int i = n - 1; i >= 0; i--) {
        while (!s.empty() && arr[i] > arr[s.top()]) {
            int idx = s.top(); s.pop();
            history[idx] = i + 1;
        }
        s.push(i);
    }
    for(auto &u: history) {
        cout << u << ' ';
    }

    cout << '\n';
    return 0;
}
