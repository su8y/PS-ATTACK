/* 1000ms = 1초 6^5(60 * 1000) 1분, 36^5(3600000) 1시간, 86'400'000 하루 */
#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

#define pii pair<int, int>

// hh:mm:ss.sss
pair<int, int> GetTime(string time);

int solution(vector<string> lines) {
	int answer = 0;
	vector<pii> v;
	for (int i = 0; i < lines.size(); i++) {
		string line = lines[i];
		pii p = GetTime(line);
		v.push_back(p);
	}

	for (int i = 0; i < v.size(); i++) {
		auto &[st, ed] = v[i];
		int start = ed;
		int end = ed + 999;
		int cnt = 0;
		for (int j = 0; j < v.size(); j++) {
			if (v[j].first > end)
				continue;
			if (v[j].second < start)
				continue;
			cnt++;
		}
		answer = max(answer, cnt);
	}

	return answer;
}

pair<int, int> GetTime(string time) {
	int ms = 0;
	size_t st = time.find_first_of(" ");
	size_t ed = time.find_last_of(" ");
	string hhmmss = time.substr(st + 1, ed);
	string durationStr = time.substr(ed + 1);

	int hh = stoi(hhmmss.substr(0, 2)) * 60 * 60;
	int mm = stoi(hhmmss.substr(3, 2)) * 60;
	int ss = stoi(hhmmss.substr(6, 2));
	int sss = stoi(hhmmss.substr(9, 3));

	int endTime = (hh + mm + ss) * 1000 + sss;

	durationStr.pop_back();
	int duration = (int)(stod(durationStr) * 1000);

	return {endTime - duration + 1, endTime};
}
