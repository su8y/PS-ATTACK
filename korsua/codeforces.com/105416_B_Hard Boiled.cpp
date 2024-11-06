/*
https://codeforces.com/gym/105416/problem/B
단순구현 그리디 
sorting한 후에 작은 수부터 뺄셈
*/
#include <bits/stdc++.h>
using namespace std;
 
int n, m;
vector<int> x(1e5 + 1, INT_MAX);
int main() {
    cin >> n >> m;
    for(int i = 0 ; i <n;i++){
        cin >> x[i];
    }
    sort(x.begin(), x.end());
 
    int count =0;
    for(int i = 0 ; i<n;i++){
        if(m - x[i] < 0) break;
        m -= x[i];
        count++;
    }
    cout << count << "\n";
    return 0;
}
