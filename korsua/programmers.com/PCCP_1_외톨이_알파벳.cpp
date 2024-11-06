/*
two pointer 구현 https://school.programmers.co.kr/learn/courses/15008/lessons/121683
* 알파벳 별 카운트를 샐 수 있는 배열 `int count[32]`
* 투 포인터 l과 r을 통해서 현재 연속된 문자열의 길이를 count와 비교후 다르면 answer에 넣는 방식
* 넣고난 뒤에는 원래 없었던 문자처럼 count를 0으로 갱신한다. 
*/
#include <bits/stdc++.h>

using namespace std;

string solution(string input) {
    string answer = "";
    int count[32] ={ 0, };

    for(int i=0;i<input.size();i++) count[input[i] - 'a']++;
    int l, r;
    l = 0, r = l + 1;
    while(l < input.size() && r < input.size()){
        if(input[l] != input[r]){ 
            if(count[input[l]-'a'] != 0 && count[input[l] -'a'] != r - l) {
                count[input[l] - 'a'] = 0;
                answer += input[l];
            }
            l=r; r=l+1;
        }else{
            r++;
        }
    }
    sort(answer.begin(), answer.end());
    
    return answer == "" ? "N" : answer;
    
}
