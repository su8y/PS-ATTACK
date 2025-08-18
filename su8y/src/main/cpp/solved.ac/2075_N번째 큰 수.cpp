#include <bits/stdc++.h>

using namespace std;

/*
 * https://www.acmicpc.net/problem/2075 N번째 큰 수
 * [i][j]는 [i-1][j] 보다 크다.
 */
int main() {
    cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
    int n;
    cin >> n;
    priority_queue<int, vector<int>, less<int>> max_heap;
    priority_queue<int, vector<int>, greater<int>> min_heap;
    int tmp;
    for (int i = 0; i < n * n; i++) {
        cin >> tmp;
        if (max_heap.size() > n) {
            if (min_heap.top() < tmp) {
                max_heap.push(tmp);
                min_heap.pop();
                min_heap.push(tmp);
            }
        } else {
            max_heap.push(tmp);
            min_heap.push(tmp);
        }
    }
    for (int i = 0; i < n - 1; i++) {
        max_heap.pop();
    }
    cout << max_heap.top();

    return 0;
}
