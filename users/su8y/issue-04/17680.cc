#include <string>
#include <vector>
#include <map>
#include <deque>
#include <algorithm>

using namespace std;
const int HIT = 1;
const int MISS = 5;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    
    if(cacheSize == 0) {
        // base condition
        return MISS * cities.size();
    }
    
    
    for(auto &s: cities) {
        // cities string to lower case
        for_each(s.begin(), s.end(), [](auto &c) {c = tolower(c);});
    }
    
    // lfu datastructure
    deque<string> dq;
    
    for(auto &s: cities) {
        // find s in cache
        auto it = find(dq.begin(), dq.end(), s);
        if(it != dq.end()) {
            // hit
            answer += HIT;
            dq.erase(it);
            dq.push_back(s);
        } else {
            // miss
            answer += MISS;
            if(dq.size() == cacheSize) {
                dq.pop_front();
            }
            dq.push_back(s);
        }
    }
    
    return answer;
}