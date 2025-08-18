/*
* https://www.acmicpc.net/problem/1244 스위치 켜고 끄기
 *
 * 8
 * 0 1 0 1 0 0 0 1
 * 2
 * 1 3 // 남 //배수
 * 2 3 // 최대 구간 다바꿈
 */
#include <bits/stdc++.h>
using namespace std;
void man(int x, vector<bool>& v) {
    for(int i=1; x*i < v.size(); i++) {
        v[x*i] = !v[x*i];
    }
}
void women(int x, vector<bool>& v) {
    v[x] = !v[x];
    for(int i=1;i<v.size()/2;i++) {
        if(x-i<1 || x+i>=v.size()) break;
        if(v[x-i] != v[x+i]) break;
        v[x-i] = !v[x-i];
        v[x+i] = !v[x+i];
    }
}

void solve(vector<bool>& v) {
    int n, gender, x;
    cin >> n;
    for(int i=0;i<n;i++) {
        cin >> gender >> x;
        if(gender ==1) man(x,v);
        else women(x,v);
    }
    for(int i=1;i<v.size();i++) {
        cout << v[i] << ' ';
        if(i % 20 == 0)  cout << "\n";
    }
}

int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(false);
    int n;
    vector<bool> v(1);

    cin >> n;
    int tmp;
    for(int i=0;i<n;i++) {
        cin >> tmp;
        v.push_back(tmp);
    }
    solve(v);

    return 0;
}
