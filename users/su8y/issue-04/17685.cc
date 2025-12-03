/* Trie를 이용한 문자열검색 횟수세기 시간복잡도: O(n), 공간복잡도: O(n) */
#include <string>
#include <vector>
#include <iostream>
#include <set>

using namespace std;

struct Trie {
    int cnt;
    Trie* child[26];
    Trie() {
        cnt = 0;
        for (int i=0;i<26;i++){
            child[i] = NULL;
        }
    }
};

void Create(Trie *root, const string &s) {
    if(s.empty()) return;
    Trie* p = root;
    for(int i=0;i<s.size();i++) {
        int idx = s[i] - 'a';
        if(!p->child[idx])  {
            p->child[idx] =  new Trie();
        }
        p->child[idx]->cnt++;
        
        p = p->child[idx];
        
    }
}

int SearchCnt(Trie *root, const string &s) {
    int deps = 0;
    Trie *p = root;
    for (int i=0;i<s.size();i++){
        int cur = s[i] -'a';
        if (p->cnt == 1) break;
        if(!p->child[cur]) return 0;
        
        p = p->child[cur];
        deps++;
    }
    return deps;
    
}

int solution(vector<string> words) {
    int answer = 0;
    Trie* root = new Trie();
    
    for (int i=0;i<words.size();i++) {
        Create(root, words[i]);
    }
    
    for (int i=0;i<words.size();i++) {
        answer += SearchCnt(root, words[i]);
    }
    
    return answer;
}
