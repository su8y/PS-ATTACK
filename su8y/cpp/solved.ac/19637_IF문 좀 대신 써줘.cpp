/*
* https://www.acmicpc.net/problem/19637 IF문 좀 대신 써줘
 */
#include <bits/stdc++.h>
using namespace std;


struct Title {
    string name;
    int lower;
};
void solve(vector<Title> titles, vector<int> scores) {
    for(int score:scores) {
        int lo = -1, hi = titles.size()-1;
        while(lo+1 < hi) {
            int mid = (lo+hi)/2;
            if(titles[mid].lower < score ) lo = mid;
            else hi = mid;
        }
        cout << titles[hi].name << '\n';

    }

};
int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(false);
    int n, m;
    cin >> n >> m;


    vector<Title> title;
    string str; int x;
    for(int i=0;i<n;i++) {
        cin >> str >> x;
        title.push_back({str,x});
    }
    vector<int> scores;
    for(int i=0;i<m;i++) {
        cin >> x;
        scores.push_back(x);
    }
    solve(title,scores);



    return 0;
}
