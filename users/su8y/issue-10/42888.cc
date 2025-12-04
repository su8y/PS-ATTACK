/* Lv2 오픈 채팅방 https://school.programmers.co.kr/learn/courses/30/lessons/42888
체감 Level 1
자료구조를 어떤걸 사용할지 고민하고 문제를 풀면 굉장히 쉬운 문제입니다.
자료구조 Map을 사용하여 간단하게 해결 가능합니다.
*/

#include <iostream>
#include <map>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

struct Activity {
	string uid;
	string nickname;
	string type; // Enter, Leave, Change
};

Activity parse(string str) {
	istringstream iss(str);

	Activity res;
    iss >> res.type;
    iss >> res.uid;
    if(res.type != "Leave")
        iss >> res.nickname;

	return res;
}

vector<string> solution(vector<string> record) {
	vector<string> answer;
	vector<Activity> v;

	map<string, string> mp;

	for (auto e : record) {
		auto a = parse(e);
        if(a.type != "Leave")
            mp[a.uid] = a.nickname;
		v.push_back(a);
	}

	for (auto e : v) {
		if (e.type == "Change")
			continue;
		stringstream ss;
		ss << mp[e.uid] << "님이 ";
		if (e.type == "Leave")
			ss << "나갔습니다.";
		else if (e.type == "Enter")
			ss << "들어왔습니다." ;
		answer.push_back(ss.str());
	}
	return answer;
}
int main() {
	auto res = solution({"Enter uid123 Baesua", "Leave uid123", "Change uid123 su8y"});
    for(auto e: res) {
        cout << e << endl;
    }
	return 0;
}

