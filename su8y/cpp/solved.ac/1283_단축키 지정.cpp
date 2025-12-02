#include <bits/stdc++.h>

using namespace std;
/* https://www.acmicpc.net/problem/1283 단축키 지정 */
int findInWord(const string &str, const set<char> &s) {
    int cur = 0;
    int fi;
    if (str[0] != ' ' && s.count(str[0]) == 0) {
        return 0;
    }
    while ((fi = str.find(' ', cur)) != string::npos) {
        if (fi + 1 >= str.size()) break;
        if (s.count(str[fi + 1]) == 0) {
            return fi + 1;
        }
        cur = fi + 1;
    }
    return -1;
}

int findAlpha(const string &str, const set<char> &s) {
    for (int i = 0; i < str.size(); i++) {
        if (str[i] == ' ') continue;
        if (s.count(str[i]) == 0) {
            return i;
        }
    }
    return -1;
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    vector<string> v(n);
    cin.ignore();
    for (int i = 0; i < n; i++) {
        getline(cin, v[i]);
    }
    set<char> s;
    int diff = 'a' - 'A';
    for (int i = 0; i < n; i++) {
        string &str = v[i];
        int fi;
        if ((fi = findInWord(str, s)) != -1) {
            s.insert(str[fi]);
            if(str[fi] < 'a'){
                s.insert(str[fi] + diff);
            }else {
                s.insert(str[fi] - diff);
            }
            str.insert(str.begin() + fi + 1, ']');
            str.insert(str.begin() + fi, '[');
        } else if ((fi = findAlpha(str, s)) != -1) {
            s.insert(str[fi]);
            if(str[fi] < 'a'){
                s.insert(str[fi] + diff);
            }else {
                s.insert(str[fi] - diff);
            }
            str.insert(str.begin() + fi + 1, ']');
            str.insert(str.begin() + fi, '[');
        }
    }
    for (auto &u: v) {
        cout << u << '\n';
    }
    return 0;
}