#include <iostream>
#include <map>
#include <string>
#include <vector>
using namespace std;

vector<int> solution(string msg) {
	vector<int> answer;
	map<string, int> m;

	for (int i = 1; i <= 26; i++) {
		string temp;
		temp = 'A' + i - 1;
		m.insert({temp, i});
	}

	int cnt = 27;
	while (msg.length() > 0) {
		string str;
		str = msg[0];
		int idx = 1;
		for (; idx < msg.length(); idx++) {
			str += msg[idx]; // 문자 붙여봄
			if (m.find(str) == m.end()) {
				m.insert({str, cnt});
				cnt++; // 색인 번호 증가
				str.erase(str.begin() + str.length() - 1);
				break;
			}
		}

		msg.erase(msg.begin(), msg.begin() + str.length());
		answer.push_back(m.find(str)->second);
	}

	return answer;
}
