/*
* https://www.acmicpc.net/problem/7568 덩치
 *
 * 1. TC O(n^2)
 */

#include <bits/stdc++.h>
#define FASTIO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
using namespace std;
#define pint pair<int,int>
int n;
pint arr[50];
struct compare{
    bool operator()(pint& a, pint& b ){
        auto [a1,a2] = a;
        auto [b1,b2] = b;
        return a1 > b1 && a2 > b2;

    }
};

// 0 3 3 3 4
// F T T T T
int failed_findTh(int target, vector<int>& arr){
    int lo = -1; int hi = arr.size();
    while(lo + 1 < hi){
        int mid = lo + (hi - lo)/2;
        if(arr[mid] < target){
            lo = mid;
        }else {
            hi = mid;
        }
    }
    int th = hi + 1;
    return th;
}

int findTh(int target, vector<int>& arr){
    int nth = 0;
    int num = -1;
    for(int i = 0 ; i <arr.size();i++){
        if(num != arr[i]){
            num = arr[i];
            nth = i;
        }
        if(target == arr[i]){
            break;
        }
    }


    return nth + 1;
}
int main(){
    FASTIO
    cin >> n;
    int a, b;
    for(int i=0; i<n; i++){
        cin >> a >> b;
        arr[i] = {a,b};
    }
    compare cmp;
    string ret;

    vector<int> greater;

    for(int i=0; i<n; i++){
        int count = 0;
        for(int j=0; j<n; j++){
            if(i==j) continue;
            if(cmp( arr[j] , arr[i])){
                count++;
            }
        }
        greater.push_back(count);
    }
    for(int i=0;i<greater.size(); i++){
        cout << greater[i]+1 << " ";
    }

    return 0;
}

