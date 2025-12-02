/*
* https://www.acmicpc.net/problem/20310 타노스
 *
 * 0 이 1보다 사전순으로 빠르므로 절반을 제거하는 로직을 왼쪽과 오른쪽 2군데로나눠서 한다.
 * 0은 오른쪽에서부터 없애고
 * 1은 왼쪽에서 부터 없앤다.
 *
 * 이 말은 반대로 한다면 0은 왼쪽에서부터 절반만큼 넣고
 * 1은 왼쪽에서 부터 절반만큼 삭제를 한다.
 */
#include <bits/stdc++.h>
using namespace std;

string tanos(string str, int len) {
    string ret = "";
    int count[2] ={0,};
    for(int i=0;i<len;i++) count[str[i]-'0']++;
    count[0] /= 2;
    count[1] /= 2;
    int p = 0;
    while(p < len) {
        int x = str[p] - '0';
        if(x == 0 ) {
            if(count[0] > 0) {
                ret += '0';
                count[0]--;
            }
        } else {
            if(count[1] > 0) {
                count[1]--;
            }else {
                ret += '1';
            }
        }
        p++; // p는 항상 증가
    }
    return ret;
}
int main() {
    string str;
    cin >> str;

    cout << tanos(str, str.size());

    return 0;
}
