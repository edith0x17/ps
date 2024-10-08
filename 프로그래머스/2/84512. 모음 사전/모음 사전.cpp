#include <string>
#include <vector>
using namespace std;
string aeiou = "AEIOU";
int answer, cnt = -1;
string target;
void dfs(string s){
    if(s.size() == 6)return;
    
    cnt++;
    if(s == target){
        answer = cnt;
    }
    
    for(int i = 0; i< 5; i++){
        dfs(s + aeiou[i]);
    }
}
int solution(string word) {
    target = word;
    dfs("");
    return answer;
}