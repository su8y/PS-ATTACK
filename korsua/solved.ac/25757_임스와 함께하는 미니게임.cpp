#include <bits/stdc++.h>
using namespace std;

/* https://www.acmicpc.net/problem/25757
*/
map<char, int> m = {
    {'Y', 2},
    {'F', 3},
    {'O', 4}
};

set<string> s;
int main() {
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(false);
    int n; char game;
    cin >> n >> game;

    string str;
    for(int i=0;i<n;i++) {
        cin >> str;
        s.insert(str);
    }
    cout <<  s.size() / (m[game]- 1) << endl;
}
