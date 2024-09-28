#include <string>
#include <vector>
#include <unordered_map>
using namespace std;
unordered_map<int ,int> mp;// 가로 세로
void go(int k){
    if(k <= 0)return;
    
    for(int i = 1; i * i <= k; i++){
        if(k % i == 0){//
            mp.insert({k/ i, i});
        }
    }
}

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    go(brown + yellow);
    for(auto at: mp){
        int n = at.second;
        int m = at.first;
        
        if((brown == (m * 2) + (n * 2) - 4) && (yellow == (m - 2) * (n - 2))){
            answer.push_back(m);
            answer.push_back(n);
        }
    }
    
    return answer;
}