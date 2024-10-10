#include <string>
#include <vector>
using namespace std;

vector<int> adj[204];
int visited[204];
void dfs(int here){
    visited[here] = 1;
    for(int there: adj[here]){
        if(visited[there])continue;
        dfs(there);
    }
}
int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for(int i = 0; i < computers.size(); i++){
        for(int j = 0; j < computers[i].size(); j++){
            if(i == j)continue;
            if(computers[i][j]){// 연결
                adj[i].push_back(j);
                adj[j].push_back(i);
            }
        }
    }
    for(int i = 0; i < n; i++){
        if(visited[i])continue;
        dfs(i);
        answer++;
    }
    return answer;
}