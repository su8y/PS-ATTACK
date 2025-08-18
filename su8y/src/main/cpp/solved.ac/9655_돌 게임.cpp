/*
* https://www.acmicpc.net/problem/9655 돌게임
 * 1, 3 일때 특정한 패턴을 못찾음 ..
 * 1010101010101010101
 * 10001000100010001
 * 1010001010001
 */

#include <bits/stdc++.h>
#define FASTIO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
using namespace std;

int n;

int main() {
    FASTIO
    cin >> n;
    cout << (n % 2 == 0? "CY\n" : "SK\n");
    return 0;
}
