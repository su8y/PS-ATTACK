#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0);

using namespace std;
/* 문제: https://www.acmicpc.net/problem/1976 여행 가자
풀이:
도시간에 방문 순서의 제한이 없다면 단순히 연결이 되어있냐를 따지는 문제로 접근
A - B - C 방문을 해야한다면

[A]CACACACA[B]ABABABA[C] 방식으로 방문을 한다 해도 성공이다.
가중치가 따로 없기때문에 MST까지는 아니고 DisjointSet을 사용한다. 

Test:
1: 2 1 0 0 0 0 1
ans: YES
2: 2 2 0 0 0 0 1 2 
ans: NO
3: 1 1 0 1
ans: YES
4: 1 1 0 1
ans: YES




*/

#define endl '\n';
typedef long long ll;

class DisjointSet{
private:
	vector<int> parent;
	int _find(int a){
		if(parent[a] == a) return a;

		return parent[a] = _find(parent[a]);
	}
	void _union(int a, int b){
		int pa = _find(a);
		int pb = _find(b);
		if (pa == pb) return;

		if (pa < pb) {
			swap(pa, pb);
		}
		parent[pa] = pb;
	}
public:
	DisjointSet(int n): parent(n+1){
		for(int i=1;i <= n; i++){
			parent[i] = i;
		}
	}
	void connectVertax(int st, int dest){
		_union(st, dest);
	}
	bool checkPath(vector<int> path){
		int prev = _find(path[0]);
		for(int i=1;i<path.size();i++){
			if(prev != _find(path[i])) return false;
		}
		return true;
	}
};

int main(){
	fastio;
	int n, m, a, b, c;
	cin >> n 
		>> m;
	DisjointSet disjointset(n);

	vector<vector<int>> edges(n, vector<int>(n));
	vector<int> visits;

	for (int i=0;i<n;i++){
		for (int j=0;j<n;j++){
			cin >> edges[i][j];
			if(edges[i][j] == 1) {
				disjointset.connectVertax(i+1, j+1);
			}
		}
	}
	visits.resize(m);
	for (int i=0;i<m;i++) {
		cin >> visits[i]; 
		assert(visits[i] < n+1);
	}

	bool f = disjointset.checkPath(visits);

	if (f){
	 	cout << "YES" << endl;

	} else {
	 	cout << "NO" << endl;
	}
	
	return 0;
}
