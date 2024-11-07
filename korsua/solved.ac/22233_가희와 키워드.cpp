/*
* https://www.acmicpc.net/problem/22233 가희와 키워드
 */
#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(false);
    int n,m;
    cin >> n >> m;
    unordered_set<string> s;
    string str;
    for(int i=0;i<n;i++) {
        cin >> str;
        s.insert(str);
    }

    for(int i=0;i<m;i++) {
        cin >> str;
        int cur = 0;
        int next;
        while((next =str.find(',',cur)) != string::npos) {
            string split = string(str.begin() + cur, str.begin() + next);
            s.erase(split);
            cur = next + 1;
        }
        s.erase(string(str.begin() + cur, str.end()));
        cout<< s.size() << "\n";
    }

    return 0;
}
