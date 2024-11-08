#include <bits/stdc++.h>

using namespace std;
#define endl '\n'

/* https://www.acmicpc.net/problem/22251 빌런 호석
 *
 * 사이클을 구한다.
 */

#define FASTIO cin.tie(0)->sync_with_stdio(0);


int x, n, k, p; //현재 엘레베이터 층 수, n층까지 이용 가능,w자리 ,최소 1개에서 p개 반전시킬 계획


int numbers[10] = {
    0b111'0111,
    0b001'0001,
    0b011'1110,
    0b011'1011,
    0b101'1001,
    0b110'1011,
    0b110'1111,
    0b011'0001,
    0b111'1111,
    0b111'1011,
};

int getCount(const int src, const int trg) {
    const int diff = numbers[src] ^ numbers[trg]; // XOR
    int ret = 0;
    for (int i = 0; i < 7; i++) {
        if ((diff & (1 << i)) == (1 << i)) {
            ret++;
        }
    }
    return ret;
}

void test() {
    printf("getCount(0,1) = %d\n", getCount(0, 1));
    printf("getCount(1,2) = %d\n", getCount(1, 2));
    printf("getCount(8,9) = %d\n", getCount(8, 9));
    printf("getCount(5,7) = %d\n", getCount(5, 7));
    printf("getCount(4,3) = %d\n", getCount(4, 3));
}

int main() {
    FASTIO
    int ret = 0;
    cin >> n >> k >> p >> x;

    string x_str = to_string(x);
    while (x_str.size() < k) {
        x_str.insert(0, "0");
    }

    for (int i = 1; i <= n; i++) {
        if (i == x) continue;
        string i_str = to_string(i);
        while (i_str.size() < k) {
            i_str.insert(0, "0");
        }

        int count = 0;
        for (int i = 0; i < k; i++) {
            count += getCount(x_str[i] - '0', i_str[i] - '0');
        }
        if (count <= p) {
            ret++;
        }
    }
    cout << ret << endl;
    return 0;
}
