#include <iostream>
#include <queue>
#include <vector>

/*
 * 최소힙 priority_queue 사용
 */
using namespace std;


int N;
vector<int> arr;
priority_queue<int, vector<int>, greater<int> > q;
// desc check
void solve() {
    if (q.size() == 0) {
        cout << 0 << "\n";
        return;
    }
    cout << q.top() << "\n";
    q.pop();
}

void input() {
    cin >> N;
    for (int i = 0; i < N; ++i) {
        int input;
        cin >> input;
        if (input == 0) {
            solve();
            continue;
        }
        q.push(input);
    }
}

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    input();
}

