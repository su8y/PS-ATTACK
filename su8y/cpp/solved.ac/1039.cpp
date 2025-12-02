#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <cstring>
#include <algorithm>
#include <set>
#include <map>
#include <functional>
#include <cmath>

#define FAST_IO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

using namespace std;


int K, M; /* 숫자, 연산 횟수, 숫자의 길이*/
string N;
int max_value = -1;

void input() {
    cin >> N >> K;
    M = N.length();
}

string swap(string s, int a, int b) {
    string copy(s);
    char tmp = copy[a];
    copy[a] = copy[b];
    copy[b] = tmp;
    return copy;
}

void rec_solve(int deps, string s) {
    if (s[0] == '0') return; // base condition
    if (deps <= 0) {
        max_value = max(atoi(s.c_str()), max_value);
        return;
    }

    for (int i = 0; i < M - 1; i++) {
        for (int j = i + 1; j < M; j++) {
            string swap_str = swap(s, i, j);
            rec_solve(deps - 1, swap_str); // rec에는 참조값을 넘겨주지 않는다.
        }
    }
}

void add_visited(set<string> &visited, int k, string s) {
    visited.insert(to_string(k) + s);
}

string get_set_key(int k, string s) {
    return to_string(k) + s;
}

void solve() {
    int max_value = -1;
//    rec_solve(K, N); 시간초과 
    queue<pair<int, string> > q;
    set<string> visited; // {남은개수}{숫자} ex ) 0123
    q.push(pair<int, string>(K, N));

    while (!q.empty()) {
        pair<int, string> front = q.front();
        q.pop();

        if (front.first <= 0) {
            max_value = max(atoi(front.second.c_str()), max_value);
            continue;
        }
        int next_deps = front.first - 1;

        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                string swap_str = swap(front.second, i, j);
                if (swap_str[0] == '0') continue;
                if (visited.find(get_set_key(next_deps, swap_str)) == visited.end()) {
                    q.push({next_deps, swap_str});
                    add_visited(visited, next_deps, swap_str);
                }
            }
        }

    }


    cout << max_value << endl;
}


int main() {
    FAST_IO;
    input();
    solve();
    return 0;
}
