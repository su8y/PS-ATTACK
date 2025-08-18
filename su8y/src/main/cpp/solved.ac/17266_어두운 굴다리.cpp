/* https://www.acmicpc.net/problem/17266 어두운 굴다리
*/
#include <bits/stdc++.h>
using namespace std;

bool isFill(int h, int w, const vector<int>& arr) {
    int l=0;
    for(int i=0;i<arr.size();i++) {
        int min = arr[i] - h;
        if(min > l) return false;
        l = arr[i] + h;
    }
    return l >= w;
}
void solve(int w, const vector<int>& arr) {
    int lo = 0, hi = 100000;
    while(lo + 1 < hi) {
        int mid = (lo + hi)/2;
        if(isFill(mid, w, arr)) hi=mid;
        else lo=mid;
    }
    cout << hi << endl;
}

int main() {
    int n, m;
    cin >> n;
    cin >> m;

    vector<int> arr(m);
    for(int i=0;i<m;i++) {
        cin >> arr[i];
    }
    solve(n, arr);
    return 0;
}
