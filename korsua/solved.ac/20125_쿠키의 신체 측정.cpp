/*
 * https://www.acmicpc.net/problem/20125 쿠키의 신체 측정
 * 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리
 *
 *
 * 010
 * 111
 * 010
 * 심장위치 즉, 상하좌우가 전부 붙어있는 곳을 찾는다.  2N
 * 총 5번의 N연산
 */
#include <bits/stdc++.h>
using namespace std;
#define pint pair<int,int>

const int dy[4] = {-1,1,0,0};
const int dx[4] = {0,0,-1,1};

bool isOutOfBounds(pint coord, int len) {
    auto [y, x] = coord;
    return y <0 || y>len || x <0 || x>len;
}
pint findHeart(const vector<string>& board, const int len) {
    for(int i=0;i<len;i++) {
        for(int j=0;j<len;j++) {
            if(board[i][j] != '*') continue;
            int match =0;
            for(int k=0;k<4;k++) {
                int ny = i + dy[k];
                int nx = j + dx[k];
                if(isOutOfBounds({ny, nx}, len)) break;
                if(board[ny][nx] == '*') match++;
            }
            if(match == 4) return {i,j};
        }
    }
    return {};
}

int getLength(const pint& coord, const int dir,const vector<string>& board) {
    int length = 0;
    int y = coord.first;
    int x = coord.second;

    while(true) {
        if(isOutOfBounds({y,x},board[0].size()) || board[y][x] != '*') break;
        length++;
        y += dy[dir];
        x += dx[dir];
    }
    return length;
}
int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

    int n;
    vector<string> board(1001);
    cin >> n;
    for(int i=0;i<n;i++) {
       cin >>board[i];
    }
    auto [hy, hx] = findHeart(board, n);

    cout << hy+1 << " " << hx+1 << "\n";
    vector<int> lengths;

    lengths.push_back(getLength({hy + dy[2], hx + dx[2]},2,board));
    lengths.push_back(getLength({hy + dy[3], hx + dx[3]},3,board));

    int h = getLength({hy + dy[1], hx + dx[1]},1,board);
    lengths.push_back(h);
    pint mid_leg = {hy + (dy[1] * (h+1)), hx + (dx[1] * (h+1))};
    lengths.push_back(getLength({mid_leg.first + dy[2], mid_leg.second + dx[2]},1,board));
    lengths.push_back(getLength({mid_leg.first + dy[3], mid_leg.second + dx[3]},1,board));

    for(auto& u: lengths) {
        cout << u << " ";
    }
    cout << "\n";
    return 0;
}
