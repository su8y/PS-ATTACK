class Solution {
public:
    /*
    - 반복되는 문자열 중에서 가능한 문자 조합 set을 가지고 set.size() 반환 
    - 
    */
    int possibleStringCount(string w) {
        int ret = 1; 
        int l = 0, r = 1;
        while(l < w.size()){
            if(w[l] == w[r]){
                r++;   
                continue;
            }
            ret += r - l - 1;
            l = r;
            r = l+1;
        }
        return ret;
    }
};
