#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int answer = 50;
int visited[50];// words[i]
bool checkDiff(string a, string b){
    int difCnt = 0;
    for(int i = 0 ; i < a.size(); i++){
        if(a[i] != b[i])difCnt++;
    }
    if(difCnt == 1)return true;
    return false;
}
void dfs(string begin, string target, vector<string> words, int step){
    if(answer <= step)return;
    
    if(begin == target){
        answer = min(answer, step);
        return;
    }
    
    for(int i = 0; i < words.size(); i++){
        if(checkDiff(begin, words[i]) && !visited[i]){
            visited[i] = 1;
            dfs(words[i], target, words, step + 1);
            visited[i] = 0;
        }
    }
}
int solution(string begin, string target, vector<string> words) {
    dfs(begin, target, words, 0);
    if(answer == 50)return 0;
    return answer;
}