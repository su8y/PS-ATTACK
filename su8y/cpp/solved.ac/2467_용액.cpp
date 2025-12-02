#include <bits/stdc++.h>

using namespace std;

/* 문제: https://www.acmicpc.net/problem/2467 용액
 *
 * 풀이 방법:
 * 그리디함의 투포인터 방식
 *  l,r을 두고 arr[l] + arr[r]에 대한 절대값을 기준으로 l,r을 옮기며 두 수의 합인 중앙값을 찾는다.
 */

#define FASTIO cin.tie(0); cout.tie(0); ios::sync_with_stdio(false);
#define pint pair<int,int>


int n;
vector<int> arr;

int main() {
    FASTIO
    cin >> n;
    arr = vector<int>(n);
    for (int i = 0; i < n; i++) cin >> arr[i];

    int l = 0, r = n - 1;
    int min_val = INT_MAX;
    pair<int,int> ret;
    while (l < r) {
        int sum = arr[l] + arr[r];
        if(min_val > abs(sum)) {
            ret = {arr[l],arr[r]};
            min_val = abs(sum);
        }
        if (sum > 0) {
            r--;
        } else {
            l++;
        }
    }
    cout << ret.first << " " << ret.second << "\n";

    return 0;
}
