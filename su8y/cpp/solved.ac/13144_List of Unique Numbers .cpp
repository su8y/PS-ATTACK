#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0);

using namespace std;
/* 문제: https://www.acmicpc.net/problem/13144 List of Unique Numbers 
풀이법:
문제 이해가 어려웠음
1 2 3 1 2
12 23 31 12
123 231 312 

이때 최장 길이의 중복되지 않은 배열의 길이를 찾는다. 

그리고 빈도수는 등차수열로 이루어져 있다. 
N = 1
N-1 개로 만들수 있는 개수 = 2
...
X 개로 만들수 있는 개수 N-X

검증 


1 2 3 4 5

1 
1 2
1 2 3
1 2 3 4
1 2 3 4 5 
연속된 수열 
1 3 은 안됌 
1로 이루어 질수 있는 숫자 N개 

2 는 N-1
2 
2 3
2 3 4
2 3 4 5 
i번째 에서 만들수 있는 중복되지않은 연속된 수열은 N-i 개 


*/

#define endl '\n';
typedef long long ll;
int main(){
	fastio;
	int n, l, r;
	ll total;
	vector<int> arr;
	set<int> s;

	cin >> n;
	arr.resize(n);
	for(int i=0;i<n;i++) cin >> arr[i];

	total = l = r = 0;
	/* while문 2번 쓰는것을 최적화 */
	while(r < n || l < n){
		if(r < n && s.find(arr[r]) == s.end()){
			s.insert(arr[r]);
			r++;
		}else{
			total += r - l;
			s.erase(arr[l]);
			l++;
		}
	}

	cout << total << endl;

	return 0;
}
