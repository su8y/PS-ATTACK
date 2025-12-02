#include <bits/stdc++.h>

using namespace std;

/* https://www.acmicpc.net/problem/14719 빗물
 *
 * - 투 포인터
 *  - l,r이 있을때 l보다 큰 r 블록을 찾는다.
 *  - 그리고 l->r 만큼의 시간복잡도를 가진 용량 구하는 알고리즘 사용
 *  자신보다 큰 블록이 없는 경우
 *  while문의 종료 조건은 r이 length를 넘어설때다. 정상 종료는 l이 r의 위치로 가면서
 *  l = m-1, r = m 인데 이는 r-l ==1로 볼 수 있다. 이게 아니라면 한번 더 검사해준다.
 *
 *  4 0 0 1
 *
 *  3 3 0 2
 *
 *  1 0 5 1 3 0
 *  마지막 테스트 케이스 경우 1 0 5 에 대해서는 잘 구해지지만
 *  5130은 기준이 되는 5에대해서 내림차순 이기 때문에 잘 안구해진다.
 *  이 때 0에서부터 똑같은 알고리즘으로 돌린다.
 *
 *
 */

#define FASTIO cin.tie(0); cout.tie(0); ios::sync_with_stdio(false);
int n, m;
vector<int> arr(500);

int getSize(int l, int r, vector<int> blocks) {
    int total = 0;
    int min_block = min(blocks[l], blocks[r]);
    for (int i = l + 1; i < r; i++) {
        int capacity = min_block - blocks[i];
        if (capacity < 0) return 0;
        total += capacity;
    }
    return total;
}

int main() {
    FASTIO
    cin >> n >> m;
    for (int i = 0; i < m; i++) cin >> arr[i];

    int l = 0;
    int r = 1;
    int ret = 0;
    while (r < m) {
        if (arr[l] <= arr[r]) {
            ret += getSize(l, r, arr);
            l = r;
            r = l + 1;
        } else {
            r++;
        }
    }

    if (r - l != 1) {
        /* 종료 조건 외 상황 반대로 한번 더*/
        int last = l;
        r = r -1;
        l = r - 1;
        while( l >= last) {
            if( arr[r] <= arr[l]) {
                ret += getSize(l, r,arr);
                r = l;
                l = r -1;
            } else l--;
        }
    }

    cout << ret << '\n';

    return 0;
}
