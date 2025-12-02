/*
* https://www.acmicpc.net/problem/2292
 */
#include <bits/stdc++.h>
using namespace std;

int n;
int main(){
    cin.tie(0); cout.tie(0);
    cin >> n;
    if ( n == 1 ) {
        cout << 1 << "\n";
        return 0;
    }
    int target = 7;
    if(target >= n) {
        cout << 2 << "\n";
        return 0;
    }
    int i=3;
    while(target < n){
        target += i * 6 -6;
        if( target >= n) {
            cout << i << "\n";
            return 0;
        }
        i++;
    }

    return 0;
}

