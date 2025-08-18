#include <bits/stdc++.h>
using namespace std;

/* https://www.acmicpc.net/problem/1522 문자열 교환

 */
int n, d, k, c;


int getMin(int s, int e, string &str, char ch) {
    int l = s;
    int r = s + e;

    while (r >= 0 && str[r] == ch) r--; // 오른쪽 더미에서 ch를 넘긴 떨어진 ch를 찾는드ㅏ.
    while (l < str.size() && str[l] == ch) l++;

    while (r >= 0 && str[r] != ch) r--;

    int cnt = 0;
    while (l < r) {
        cnt++;
        l++;
        r--;
        while (l < str.size() && str[l] == ch) l++;
        while (r >= 0 && str[r] != ch) r--;
    }
    return cnt;
}


int main() {
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(false);
    string str;
    cin >> str;

    string newstring = str + str;
    int ret = INT_MAX;
    for (int i = 0; i < str.size(); i++) {
        int a = getMin(i, str.size(), newstring, 'a');
        ret = min(ret, a);
    }
    cout << ret << '\n';

    return 0;
}
