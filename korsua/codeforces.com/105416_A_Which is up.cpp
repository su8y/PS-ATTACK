/*
문제의 식을 그대로 사용 
https://codeforces.com/gym/105416/problem/A
*/
#include <bits/stdc++.h>
using namespace std;
 
vector<int> x(1e3 + 1);
int n;
int main() {
    int ret = 0;
    cin >> n;
    x[0] = 1;
    for(int i = 1 ; i< n;i++){
        x[i] = ((4 * x[i-1])^i) % 6;
    }
    for(int i = 0 ; i< n;i++){
 
        if(x[i] == 1) ret++;
    }
    cout << ret << "\n";
 
    return 0;
}
