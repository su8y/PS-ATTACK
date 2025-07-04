#include <bits/stdc++.h>
using namespace std;

/*
 * https://www.acmicpc.net/problem/2304 창고 다각형
 *  - 투 포인터 이용
 *    - 작은 지점을 이동하고 큰 지점을 만나게 되면 여태까지의 공간을 total의 적재
 *    - 마지막 남은 가장 큰 지점은 포함되지 않으므로 max로 구해주기
 */
int main(){
    int n,a,b, h[1001] ={0,};
    cin >>n ;
    for(int i=0;i<n;i++){
        cin >> a >> b;
        h[a] = b;
    }

    int l = 0, r = 1000;
    int ll=0, rr = 1000;
    int max_l = h[0], max_r = h[1000];
    int total = 0;
    while(l < r){
        if(max_l < max_r){
            l++;
            if(max_l <= h[l]){
                total += max_l * (l - ll);
                max_l = h[l];
                ll = l;
            }
        }else {
            r--;
            if(max_r <= h[r]){
                total += max_r * (rr - r);
                max_r = h[r];
                rr = r;
            }
        }
    }

    cout << total + max(h[l], h[r]) << '\n';


    return 0;
}
