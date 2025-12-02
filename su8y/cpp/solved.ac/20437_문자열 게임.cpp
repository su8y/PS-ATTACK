#include <bits/stdc++.h>

using namespace std;
/* https://www.acmicpc.net/problem/20437 문자열 게임
 * N=10000 이라서 N^2 알고리즘을 사용하여 풀었는데 = 시간 초과
 * N^2 => 26 * N 으로 단축시킴 (알파벳 별 확인)
 * */

int t, k;
string w;

void solve(string str, int k);

void solve2(string str, int k);

int main() {
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(false);
    cin >> t;
    while (t--) {
        cin >> w >> k;
        solve2(w, k);
    }


    return 0;
}

int cnt[26];

/* n = 10000이라면 가능하지만, 문제는 t=100이라는 점.*/
void solve(string str, int k) {
    int min_value = INT_MAX;
    int max_value = 0;
    for (int w = k; w <= str.size(); w++) {

        memset(cnt, 0, sizeof cnt);
        for (int i = 0; i < w - 1; i++)cnt[str[i] - 'a']++; // w-1 만큼 count

        for (int i = 0; i + w - 1 < str.size(); i++) {
            int last_idx = i + w - 1; // 1

            cnt[str[last_idx] - 'a']++;

            if (cnt[str[last_idx] - 'a'] == k) {
                min_value = min(min_value, w);
                if (str[i] == str[last_idx]) {
                    max_value = max(max_value, w);
                }
            }
            cnt[str[i] - 'a']--;
        }
    }

    if (min_value == INT_MAX && max_value == 0) {
        cout << "-1\n";
    } else {
        cout << min_value << " " << max_value << "\n";
    }
}

/* 블로그 참고
 * 어떤문자열이있을때  26번 * 10000번의 확인으로 푼다.
 * xxxaxxaxx a로 만들수있는가장작은 문자열 4 가장긴문자열4
 * xxbxbxxxx b로 만들수있는가장작은 문자열3 가장긴문자열4
 */
void solve2(string str, int k) {
    int min_val = INT_MAX;
    int max_val = 0;
    // for (char al = 'a'; al <= 'z'; al++) {
    set<char> s(str.begin(), str.end());
    for(auto al: s){
        int count = 0;
        int st = -1;
        for (int i = 0; i < str.size(); i++) {
            if (str[i] == al) {
                count++;
                if (st == -1) st = i;
                if (count == k) {
                    min_val = min(min_val, i - st + 1);
                    max_val = max(max_val, i - st + 1);

                    st++;
                    while(st < str.size() && str[st] != al) st++;
                    count--;
                }
            }
        }
    }
    if (min_val == INT_MAX && max_val == 0) {
        cout << "-1\n";
    } else {
        cout << min_val << " " << max_val << '\n';
    }
}
