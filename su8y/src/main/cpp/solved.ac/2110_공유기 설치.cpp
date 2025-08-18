#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#define endl '\n'
#define ll long long
using namespace std;

/*
문제 : https://www.acmicpc.net/problem/2110 공유기 설치

접근법 :
C개의 공유개를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기의 거리를 가능한 크게하여 설치하려고한다.

거리가 커지면 커질수록 공유기를 3개를 설치하지 못한다. ( 중복거리가있기 때문에)
전형적인 이분탐색 문제 최대 lo, hi 의 범위는 [0, 10000000000] 이다. 

[TTTTTFFFFFF]의 문제이므로 T의 lo를 구하면 된다. 

*/
int n, m;
vector<int> arr;

// 거리 증가하면서 설치할수 있는지 확인 
bool canBuilt(const int width,const int k){
	int wifi = arr[0] + width;
	int cnt =1;
	for(int i=1;i<n;i++){
		if(arr[i] >= wifi){
			wifi = arr[i] + width;
			cnt++;
		}
	}

	return cnt >= k;
}
int main() {
	fastio;
	cin >> n >> m;
	arr.resize(n);
	for(int i=0;i<n;i++) cin >> arr[i];

	sort(arr.begin(), arr.end());

	int lo = 0; int hi = 1000000001;
	while( lo + 1 < hi){
		int mid = (lo + hi) / 2;
		if(canBuilt(mid, m)){
			lo=mid;
		}else {
			hi = mid;
		}
	}
	cout << lo << endl;

	return 0;
}
