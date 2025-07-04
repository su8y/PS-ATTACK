/* https://www.acmicpc.net/problem/1205
 */
#include <bits/stdc++.h>
using namespace std;


int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(false);
    int n, t, p;
    cin>>n>>t>>p;
    vector<int> v(p,-1);
    for(int i=0;i<n;i++) {
        cin >> v[i];
    }


    int lo =-1, hi = p;
    while(lo+1 < hi) {
        int mid= (hi + lo) /2;
        if(v[mid] >= t) lo=mid;
        else hi = mid;
    }
    if (hi == p) {
        cout << -1 << endl;
        return 0;
    }
    // lower_bound 최소 위치 확인
    lo =-1, hi = p;
    while(lo+1 < hi) {
        int mid = (hi + lo) /2;
        if(v[mid] > t) lo = mid;
        else hi = mid;
    }
    cout << hi + 1 << endl;



    return 0;
}
