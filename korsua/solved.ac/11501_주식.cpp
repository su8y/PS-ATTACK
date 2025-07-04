/*
* https://www.acmicpc.net/problem/11501 주식
 */
#include <bits/stdc++.h>
#define FASTIO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define ll long long
using namespace std;

int main() {
    FASTIO
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;
        ll total = 0;
        vector<int> price(n);
        for (int i = 0; i < n; i++) cin >> price[i];

        int right = n - 1;
        int max_value = 0;
        for(int i=right;i>=0;i--) {
            if(max_value > price[i]) {
                total += max_value - price[i];
            } else{
                max_value = price[i];
            }
        }
        cout << total << endl;
    }

    return 0;
}
