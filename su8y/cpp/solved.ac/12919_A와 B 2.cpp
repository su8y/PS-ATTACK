#include <bits/stdc++.h>

using namespace std;

/* https://www.acmicpc.net/problem/12919 A와 B 2
 * 2^N ( 0 < N < 25)
 * - solve(s+ 'A')
 * - solve(s+ 'B'.reverse())

 * N^4
 * testcase
BA
BAA
=> 1
ABA
ABAA
=> 1
ABA
AABA
=> 0
AB
BABB
=> 1
AB
BBAB
=> 0
BA
BABB
=> 0
BA
BBAB
=> 1

BA
BABBB
=> 0
*/
string s, t;

bool solve(string &s, const string &t) {
    if (s.size() == t.size()) {
        if (s == t) return true;
        return false;
    }
    bool a = 0, b = 0;
    if (s[0] == 'B') {
        string substring = string(s.begin() + 1, s.end());
        std::reverse(substring.begin(), substring.end());
        b = solve(substring, t);
    }
    if (s[s.size() - 1] == 'A') {
        string substring = string(s.begin(), s.end() - 1);
        a = solve(substring, t);
    }

    return a || b;
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(false);
    cin >> s >> t;
    cout << solve(t, s) ? 1 : 0;
}