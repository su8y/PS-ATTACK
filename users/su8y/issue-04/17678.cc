#include <string>
#include <vector>

#include <algorithm>
#include <deque>
#include <iostream>
#include <queue>
#include <sstream>

using namespace std;

string ConvertTime(int time);
int ConvertTime(const string &time);

string solution(int n, int t, int m, vector<string> timetable);
int main() {
	cout << solution(2, 10, 1, {"09:10", "09:10"}); // 09:09

	return 0;
}
string solution(int n, int t, int m, vector<string> timetable) {
	int busTime = ConvertTime("09:00");
	int DEADTIME = ConvertTime("24:00");
	vector<int> v(timetable.size());
	transform(timetable.begin(), timetable.end(), v.begin(),
			  [](const string &s) { return ConvertTime(s); });
	sort(v.begin(), v.end());
	vector<int> bus[n];

	// bus 적재
	int l = 0;
	int b = 0;
	for (b = 0; b < n; b++) {
		if (busTime + t >= DEADTIME)
			break;
		if (b != 0)
			busTime += t;
		// v[ld] < busTime && place < m
		while (l < v.size() && v[l] <= busTime && bus[b].size() < m) {
			bus[b].push_back(v[l]);
			l++;
		}
	}

	// 마지막 버스 자리가 남아있다면 빠른 종료
	if (bus[b - 1].size() < m)
		return ConvertTime(busTime);

	// 뒤에서 부터 순차적으로 검사
	int maxTime = bus[b - 1].back();
	for (int i = b - 1; i >= 0; i--) {
		if (i != b - 1)
			busTime -= t;

		// 중간에 비어있는 경우 해당 버스 도착시간 반환으로 종료
		if (bus[i].size() < m)
			return ConvertTime(max(busTime, maxTime - 1));

		// 뒤에서 부터 순차적으로 검사
		for (auto j = bus[i].rbegin(); j != bus[i].rend(); j++)
			if (*j != maxTime)
				return ConvertTime(max(maxTime - 1, 0));
	}

	return ConvertTime(max(maxTime - 1, 0));
}

string ConvertTime(int time) {
	string s;
	char buf[10];
	int hour = time / 60;
	int mins = time % 60;
	snprintf(buf, sizeof(buf), "%02d:%02d", hour, mins);
	return std::string(buf);
}

int ConvertTime(const string &time) {
	istringstream iss(time);
	int hour, mins;
	char ch;
	iss >> hour;
	ch = iss.get();
	iss >> mins;
	return (hour * 60) + mins;
}