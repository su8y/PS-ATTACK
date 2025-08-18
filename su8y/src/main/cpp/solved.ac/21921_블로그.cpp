/*
https://www.acmicpc.net/problem/21921 블로그

 x 일 동안 가장 많이 들어온 방문자 수
 - 슬라이딩 윈도우 : N
 - 구간 합 :
*/
 #include <bits/stdc++.h>
//#include <algorithm>
//#include <math.h>
//#include <iostream>
//#include <vector>

using namespace std;

void solve(int w, vector<int> arr){
    if(arr.size() <= w){
        cout << accumulate(arr.begin(), arr.end() ,0 ) << '\n';
        cout << 1 << '\n';
    }
    int sum= accumulate(arr.begin(), arr.begin() + w,0 ); // w개 의 합
    int count = 1;
    int ret = sum;
    // 0 1 2 3 4
    // 1 1 1 1
    for(int i=0; i+w<arr.size(); i++){
        sum -= arr[i];
        sum += arr[i+w];

        if(ret < sum){
            ret = sum;
            count = 1;
        }else if(ret == sum) count++;

    }

    if( ret == 0) {
        cout << "SAD\n";
    }else {
        cout << ret << '\n';
        cout << count << '\n';
    }

}

int main(){
    int n, m;
    cin >> n;
    cin >> m;
    vector<int> arr(n);
    for(int i=0;i<n;i++){
        cin >> arr[i];
    }
    solve(m, arr);

    return 0;
}