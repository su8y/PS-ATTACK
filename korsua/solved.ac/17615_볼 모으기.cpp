#include <bits/stdc++.h>
using namespace std;

/* https://www.acmicpc.net/problem/17615 볼 모으기
더미와 떨어진 뒤에있는 공(R||B)부터 옮긴다고 하면 더미를 만들수 이동 횟수 = 더미와 떨어진 (R||B)의 공의 개수
10
BRRRRRRRRR

10
RRRRRRRRBR
 */
int Move(const char color, const string &s, const int n) {
    int cnt = 0;
    int r = n - 1;
    int l = 0;
    /* 오른쪽 끝에있는 ch색의 더미를 제외한 인덱스 반환 */
    while (s[r] == color) {
        r--;
    }

    while (s[l] == color) {
        l++;
    }
    /* [0..r] 까지의 ch 공의 개수 */
    for (int i = l + 1; i < r; i++) {
        if (s[i] == color) cnt++;
    }
    return min(n - 1 - r, l) + cnt;
}

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    string str;

    cin >> n;
    cin >> str;

    int red = Move('R', str, n); // O(N)
    int blue = Move('B', str, n); // O(N)

    cout << min(red, blue);
    return 0;
}
