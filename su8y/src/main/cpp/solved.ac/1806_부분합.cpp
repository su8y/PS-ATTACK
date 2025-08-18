#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#define endl '\n'
using namespace std;

/*
문제 : https://www.acmicpc.net/problem/1806 부분합

접근법 1.two-pointer O(n)
l,r 을 통해 두 수의 합을 구한다. 이하 생략 .. 

접근법 2.prefix-sum 
입력을 받으면서 sum_arr[]를 갱신해준다. 

sum_arr[n-1] 은 n까지의 합이다. 
sum_arr[n-1] - sum_arr[0] 은 첫 번째를 제외한 1...n-1 까지의 합이다. 
prefix-sum을 하더라도 two-pointer 기법을 사용해야 하기 때문에 공간복잡도 O(n)을 단축시킨다.

구현이 익숙한 two-pointer로 사용 
*/

int solve(int target, int n, int* arr){
	int minn = INT32_MAX;

    int l = 0, r = 0;
    long long sum = 0;
    while (r < n) {
		if(sum < target){
			sum += arr[r];
			r++;
		}else{
			minn = min(minn, r - l);
			sum -= arr[l];
			l++;
		}
    }
	while(l<n){
		if(sum >= target){
			minn = min(minn, r-l);
		}
		sum -= arr[l];
		l++;
	}
    return minn == INT32_MAX ? 0 : minn;
}

int main() {
	fastio;
	int n, m;
	cin >> n >> m;
	int arr[n];
	for(int i=0; i<n; i++){
		cin >> arr[i];
	}

	cout << solve(m, n, arr) << endl;
	return 0;
}
