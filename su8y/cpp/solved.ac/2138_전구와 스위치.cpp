#include <bits/stdc++.h>
#define FASTIO cin.tie(0)->sync_with_stdio(0)
#define endl '\n'
using namespace std;
#define MAX_VALUE 987654321

/* 문제: https://www.acmicpc.net/problem/2138 전구와 스위치
 * 풀이 방법: 
 * 0부터 N까지 진행하는 i를 통해 s[i-1]을 target과 같게 만든다. 
 * 마지막으로 s[n-1] == target[n-1] 이 같다면 cnt를 반환 
 * 0번째 스위치를 한번 눌렀을때 상태를 한번 더 검사해준다.
 *   - 반례 010
 *   - 0x3f 를 사용해서 풀려고 했지만 실패 MAX_VALUE 선언
 */

bool isOutOfRange(int i, int len){
	return i < 0 || i >= len;
}
void switching(int idx, string &s){
	for(int i=idx-1;i<=idx+1;i++){
		if(isOutOfRange(i, s.size())) continue;
		if(++s[i] == '2') s[i] = '0';
	}
}

int _solve(string &s, string &target){
	int cnt=0;
	for (int i = 1; i < s.size(); i++) {
		if (s[i - 1] == target[i - 1] ) continue;
		switching(i, s);
		cnt++;
	}
	// 이전까지의 문자열 들은 매칭이 됐다고 본다. if( s == target ) return cnt; O(N) 만큼의 시간복잡도(느림)
	if(s[s.size() -1] == target[s.size() -1]) return cnt;

	return MAX_VALUE;
}
int solve(const string &s, string &target) {
	if( s == target ) return 0;
	int min_ret = MAX_VALUE;

	string copy_s = s;
	min_ret = min(min_ret, _solve(copy_s, target));

	string copy_s2 = s;
	switching(0, copy_s2);
	min_ret = min(min_ret, _solve(copy_s2, target) + 1);

	
	return (min_ret == MAX_VALUE ? -1 : min_ret);
}
void test();

int main(int argc, char **argv) {
	FASTIO;
	int n;
	string a, b;
	cin >> n;
	cin >> a >> b;
	if (a.size() != n || b.size() != n)
		return -1;

	int res = solve(a, b);
	cout << res << endl;

	return 0;
}

void test(){
	string a = "0000000000", b = "1110111011";
	cout << "test 1=1110111011 " << solve(a,b) << endl;;
	a = "000", b = "010";
	cout << "test 2=010 " << solve(a,b) << endl;;
	a = "0000", b = "1101";
	cout << "test 3=1101 " << solve(a,b) << endl;;
	a = "00000", b = "11011";
	cout << "test 4=11011 " << solve(a,b) << endl;;
	a = "0000", b = "0110";
	cout << "test 5=0110 " << solve(a,b) << endl;;
	a = "1101000", b = "1111111";
	cout << "test 6=0010111 " << solve(a,b) << endl;;
}
