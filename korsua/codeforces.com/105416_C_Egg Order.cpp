/*
https://codeforces.com/gym/105416/problem/C
1씩 증가하는 부분수열의 길이를 k개로 맞추면 되는 문제 
[ 5, 4, 3, 2, 1] k = 1
[ 4, 5, 3, 2 ,1] k = 2
...
*/
#include <bits/stdc++.h>
using namespace std;
 
int n, k;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);
 
    cin >> n >> k;
    vector<int> ret;
    // 5 - 2  + 1
    for(int i = n - k + 1; i <=n ;i++){
        ret.push_back(i);
    }
    for(int i = n - k; i >= 1; i--){
        ret.push_back(i);
 
    }
    for(auto& x: ret){
        cout << x << " ";
    }
 
    cout << "\n";
 
 
 
 
    return 0;
}
