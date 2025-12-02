#include <bits/stdc++.h>
#define endl '\n'
#define fastio cin.tie(0)->sync_with_stdio(0)


using namespace std;

/* 문제: https://www.acmicpc.net/problem/24337 가희와 탑
a == b == n == 1: 1
a == 1: l--; r--;
b == 1: l--; r--;
a < b: l--;
a >= b: b--;
그리고 1을 채운다. 
a == 1 일때만 a 111 b
그 외에는 111 a b
*/
int n, a, b;
int main(){
    fastio;

    vector<int> arr; 
    vector<int> brr; 
    cin >> n >> a >> b;
    int l = a, r = b;

    if ( a== 1 && n == 1 && b == 1) {
        cout << 1 << endl;
        return 0;
    }
    if(a == 1) {
        arr.push_back(b);
        l -= 1;
        r -= 1;
    }
    if(b==1){
        brr.push_back(a); // 원본 
        l -= 1;
        r -= 1;

    }
    if ( a != 1 && b != 1){
        if ( a < b ) { l--;}
        else r--;
    }
    for(int i=r; i>= 1;i--){
        brr.push_back(i);
    }

    for(int i=1;i<=l; i++){
        arr.push_back(i);
    }



    int one_size = n - (brr.size() + arr.size());


    if(one_size < 0) { // 기저 사례 만들 수 없는 경우 
        cout << -1 << endl;
        return 0;
    }

    vector<int> one(one_size, 1);

    if( a == 1 ){
        // a 1 b 
        arr.insert(arr.end(), one.begin(),one.end());
        arr.insert(arr.end(), brr.begin(),brr.end());
        for(auto &u : arr ){
            cout << u << " ";
        }
    } else {
        // 1 a b
        one.insert(one.end(), arr.begin(), arr.end());
        one.insert(one.end(), brr.begin(), brr.end());
        for(auto &u : one ){
            cout << u << " ";
        }
        
    }
    cout << endl;

    return 0;
}
