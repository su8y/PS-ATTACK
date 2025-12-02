/*
* https://www.acmicpc.net/problem/2607 비슷한 단어
 * GOD
 * GD
 * GID
 * GODGD
 *
 * 아래의 경우는 total = 2로 나온다.  그렇기 때문에 문자열의 크기를 비교한다.
 * - GOD
 * - GODGD
 *
 * 아래의 경우도 total = 2 가 나온다.
 * - GOD
 * - DOD
 */
#include <bits/stdc++.h>
using namespace std;
bool isSame(int* count, int* trg_cnt) {
    int total=0;
    for(int i=0;i<26;i++) {
        int diff = abs(count[i] - trg_cnt[i]);
        total += diff;
        if(diff > 1 || total > 2) return false;
    }
    return true;
}

void solve(string str, vector<string> targets) {
    int count[26]={0,};
    int target_count[26];
    for (auto u: str) count[u - 'A']++;
    int diff_count = 0;

    for (string &target: targets) {
        memset(target_count, 0, sizeof target_count);
        for (auto u: target) target_count[u - 'A']++;
        int diff_size = str.size() - target.size();
        if(!isSame(count, target_count) || abs(diff_size) >= 2) diff_count++;
    }
    cout << targets.size() - diff_count << "\n";
}

int main() {
    int n;
    vector<string> ins;
    cin >> n;
    string str;
    for (int i = 0; i < n; i++) {
        cin >> str;
        ins.push_back(str);
    }
    solve(ins[0], vector(ins.begin() + 1, ins.end()));
    return 0;
}
