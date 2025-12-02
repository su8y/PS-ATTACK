#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <string.h>
#include <algorithm>
#include <set>
#include <map>
#include <functional>

#define FAST_IO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);


using namespace std;

int find_greater_index(queue<pair<int, int> > &q, int x) {
    bool flag = false;

    for (int i = 0; i < q.size(); i++) {
        pair<int, int> front = q.front();
        q.pop();
        if (front.second > x) {
            flag = true;
        }
        q.push(front);
    }
    return flag;
}

void solve() {

    int k;
    cin >> k;
    while (k--) {
        queue<pair<int, int>> q;
        int n, m;
        cin >> n >> m;
        for (int i = 0; i < n; ++i) {
            int tmp;
            cin >> tmp;
            q.push({i, tmp});
        }

        int index = 0;
        while (!q.empty()) {
            pair<int, int> front = q.front();
            q.pop();
            bool result = find_greater_index(q, front.second);
            if (result) { /* 현재 중요도 보다 큰 것이 있다면 뒤로 추가한다.*/
                q.push(front);
            } else {
                if (front.first == m) { /* 현재 중요도보다 큰 것이 없고 찾고 싶은 Index라면 반환하고 끝낸다.*/
                    cout << index + 1 << endl;
                    break;
                }
                index++;
            }
        }
    }

}


int main() {
    FAST_IO;
    solve();
    return 0;
}
