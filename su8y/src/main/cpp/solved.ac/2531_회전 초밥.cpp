#include <bits/stdc++.h>
using namespace std;

/* https://www.acmicpc.net/problem/2531 회전 초밥

- 벨트 위에는 같은 종류의 초밥이 2개 이상 있을수 있다.
1. 벨틈의 임의의 한 위치부터 k개의 접시를 연속해서 먹는경우 할인된 정액 가격 제공
2. 각 고객에게 초밥의 종류가 하나가 쓰인 쿠폰을 발행. 1번 행사의 참여할 경우 해당 초밥을 추가로 제공 (무료)
   - 없더라도 새로 만들어 제공한다.

input : 접시의 수, 초밥의 가지수 d , k ,쿠폰번호 c

k개 만큼 한바퀴를 돌아 몇개를 먹을수 있는지 계산을 하면 된다.
우리는 총 k번 먹을거니 4개를 넣고 중복을 체크할때 c를 함께 검사해주자.
 */
int n, d, k, c;

int pushFromFront(queue<int>& target, queue<int>& destination) {
    if (target.empty()) return -1;
    int f = target.front();
    target.pop();
    destination.push(f);
    return f;
}

int solve(const int k, queue<int> &q, const int coupon) {
    int cnt[3001] = {0,};
    cnt[coupon]++;
    int kind = 1;

    queue<int> k_q;
    for (int i = 0; i < k; i++) {
        int f = pushFromFront(q, k_q);
        if (cnt[f]++ == 0) kind++;
    }
    int ret = kind;
    if (q.empty()) return ret;

    for (int i = 0; i < q.size() + k_q.size(); i++) {
        // 총 N 번 반복
        int del = pushFromFront(k_q, q);
        int ins = pushFromFront(q, k_q);
        if (--cnt[del] == 0) kind--;
        if (cnt[ins]++ == 0) kind++;
        if (kind > ret) ret = kind;
    }
    return ret;
}

int main() {
    queue<int> q;
    cin >> n >> d >> k >> c;

    int tmp;
    for (int i = 0; i < n; i++) {
        cin >> tmp;
        q.push(tmp);
    }

    cout << solve(k, q, c) << '\n';

    return 0;
}
