/*
* https://www.acmicpc.net/problem/10431 줄세우기
 *
 * 시뮬레이션. 문제의 조건대로 작성한다.
 */

#include <bits/stdc++.h>
#define FASTIO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
using namespace std;


int getGreaterIndex(int e, int target, int *arr){
    for(int i=0; i<e; i++){
        if(arr[i] > target) return i;
    }
    return -1;
}
void moveOne(int s, int e, int* arr){
    int end = arr[e];
    for(int j=e; j>=s; j--){
        arr[j] = arr[j-1];
    }
    arr[s] = end;
}
int main() {
    FASTIO

    int n, T, arr[20];
    cin >> T;
    for(int t=0; t<T; t++){
        int total = 0;
        cin >> n;
        for(int i=0; i<20; i++){
            cin >> arr[i];
        }
        for(int i=0; i<20; i++){
            int res = getGreaterIndex(i, arr[i], arr);
            bool isGreater = res != -1;
            if(isGreater){
                int len = i - res;
                moveOne(res, i, arr);
                total += len;
            }
        }
        printf("%d %d\n",n, total);

    }
    return 0;
}
