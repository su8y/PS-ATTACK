#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#define endl '\n'
#define ll long long
using namespace std;

/*
문제 : https://www.acmicpc.net/problem/9935 문자열 폭발

풀이:
stack 두개를 사용해서 O(n)으로 풀이한다.
*/
void bomp(stack<char>& stck, const string& match);

void output(stack<char> reverse_stack);

int main() {
  	fastio;
  	string str, match;
  	cin >> str >> match;

  	stack<char> stck;
  	for (int i = 0; i < str.size(); i++) {
    	stck.push(str[i]);
    	bomp(stck, match);
  	}

  	if (stck.size() == 0) {  // fast failed
    	cout << "FRULA" << endl;
    	return 0;
  	}
	output(stck);


  	return 0;
}
void bomp(stack<char>& stck, const string& match) {
  if (stck.size() < match.size()) return;
  stack<char> loading;

  int len = match.size();
  for (int i = 1; i <= len; i++) {
    if (stck.top() != match[len - i]) {
      while (!loading.empty()) {
        stck.push(loading.top());
        loading.pop();
      }
      break;
    }
    loading.push(stck.top());
    stck.pop();
  }
  return;
}

void output(stack<char> reverse_stack){
  	stack<char> output_stack;  // reverse output
  	while (!reverse_stack.empty()) {
    	output_stack.push(reverse_stack.top());
    	reverse_stack.pop();
  	}

  	while (!output_stack.empty()) {
    	cout << output_stack.top();
    	output_stack.pop();
  	}
  	cout << endl;

}
