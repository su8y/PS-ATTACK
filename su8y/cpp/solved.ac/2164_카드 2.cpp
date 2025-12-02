/* https://www.acmicpc.net/problem/2164 카드
 */
#include <bits/stdc++.h>
using namespace std;

void solve(int n) {
    if( n== 1) {
        cout << 1 << endl;
        return;
    }
    deque<int> arr(n);
    for(int i=0;i<n;i++)  arr[i] = i+1;
    while(arr.size() != 1) {
        arr.pop_front();
        int f = arr.front();
        arr.pop_front();
        arr.push_back(f);
    }
    cout << arr[0] << endl;

}
int main() {
    int n;
    cin >> n;
    solve(n);
    return 0;
}
