/*
* https://www.acmicpc.net/problem/8979 올림픽
 *
 * 시뮬레이션. 문제의 조건대로 작성한다.
 */

#include <bits/stdc++.h>
#define FASTIO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
using namespace std;

#define medal tuple<int,int,int,int>

struct compare{
    bool operator()(medal a, medal b){
        auto [an,a1,a2,a3] = a;
        auto [bn, b1,b2,b3] = b;
        return  a1 == b1 ? (a2 == b2 ? (a3 > b3) : a2 > b2) : a1 > b1;
    }

};


int main() {
    int n, m;
    cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
    vector<medal> v;

    cin >> n >> m;
    for(int i=0; i <n; i++){
        int a,b,c,d;
        cin >> a >> b >> c >> d;
        v.push_back({a,b,c,d});
    }
    sort(v.begin(), v.end(), compare());

    tuple<int,int,int> target;
    int num = 0;
    for(int i=0; i<n; i++){
        auto [a,b,c,d] = v[i];
        auto cur = tuple<int,int,int>{b,c,d};
        if(target != cur){
            target = cur;
            num = i;
        }
        if(a == m) {
            cout << num + 1 << endl;
            break;
        }
    }

    return 0;
}
