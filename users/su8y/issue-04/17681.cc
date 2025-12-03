#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    for(int i=0;i<n;i++){
        ostringstream os;
        int a = arr1[i] | arr2[i];
        
        for(int j=n-1;j>=0;j--){
            if((a & (1 << j)) == (1 << j)) {
                os << "#";
            } else {
                os << " ";
            }
        }
        answer.push_back(os.str());
	}
    
    return answer;
}