#include <bits/stdc++.h>
#define FASTIO cin.tie(0)->sync_with_stdio(0)
#define endl '\n'
using namespace std;

/*
문제 : https://www.acmicpc.net/problem/1863 스카이라인 쉬운거

접근법:
1. 완탐 - l과 r을 탐색해야하는 O(n^2)
같은 높이를 찾을 수 있으니 set을 통해서 해당 높이를 안찾았다면 
r를 하나씩 옮겨가면서 l보다 작은 r을 찾는다면 count를 증가시켜준다.

하지만 0 이라면 중복된 높이에 대해서 찾을 수 있어야 한다. 0을 기준으로 블럭과 함께 높이를 저장한다 (?)
*/
#define coord pair<int, int>
int solve(const vector<coord> &v) {
	int cnt_ret = 0;

	stack<int> st;
	for (int i = 0; i < v.size(); i++) {
		while (!st.empty() && st.top() > v[i].first) {
			st.pop();
			cnt_ret++;
		}

		if (v[i].first == 0) continue;
		if (!st.empty() && st.top() == v[i].first) continue;
		st.push(v[i].first);
	}

	return cnt_ret + st.size();
}

int main()
{
	int n;
	vector<coord> v;

	cin >> n;
	int x, y;
	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		v.push_back({y, x}); // NOTE: y, x
	}
	sort(v.begin(), v.end(), [](coord a, coord b) { return a.second < b.second; });

	int res = solve(v);
	cout << res << endl;

	return 0;
}
