#include <bits/stdc++.h>
using namespace std;

/* https://www.acmicpc.net/problem/20922 겹치는 건 싫어
 * - two pointer
 *  - l , r 놔두고 count > m 이 된다면 count <= m 이 되도록 l 을 올려준다.
 *  - 그 뒤 r을 다시 올려서 r - l 의 길이를 얻어 낸다.
 *  -  주의 사항 : (r - l - 1) 할 필요 없다.
tasecase :
5 1
1 1 1 2 2
ANS: 2

5 2
1 1 1 2 2
ANS: 4

5 1
1 2 3 4 5
ANS: 5
 */

int n, m;
int cnt[100001];
vector<int> arr;

int main() {
    cin.tie(NULL);
    cin >> n >> m;
    int tmp;
    for (int i = 0; i < n; i++) {
        cin >> tmp;
        arr.push_back(tmp);
    }
    memset(cnt, 0, sizeof cnt);
    int l, r, max_value;
    l = r = 0 ;  max_value = 1;

    cnt[arr[0]] = 1;
    while (r < arr.size()) {
        int x = arr[r];
        if (cnt[x] > m)/* r이 가르키는 x의 cnt개수가 m을 초과할 때 */ {
            int del = arr[l];
            cnt[del]--;
            l++;
        }else {
            if(r- l + 1 > max_value) max_value = r-l + 1;
            r++;
            if(r >= arr.size()) break;
            cnt[arr[r]]++;
        }
    }
    cout << max_value << endl;
    return 0;
}
