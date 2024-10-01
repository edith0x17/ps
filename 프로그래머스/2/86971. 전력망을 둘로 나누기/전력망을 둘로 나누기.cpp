#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
int nn;
vector<int> adj[104];
int visited[104];
int mi = 987654321;
void init(){
    for(int i = 0; i < 104; i++){
        adj[i].clear();
    }
    fill(&visited[0], &visited[0] + 104, 0);
}

int dfs(int here){
    int cnt = 1;
    visited[here] = 1;
    for(int there: adj[here]){
        if(visited[there])continue;
         cnt += dfs(there);
    }
    return cnt;
}

void go(){
    vector<int> ret;
    for(int i = 1; i <= nn; i++){
        if(visited[i])continue;
        ret.push_back(dfs(i));
    }
    mi = min(mi, abs(ret[0] - ret[1]));
}

int solution(int n, vector<vector<int>> wires) {
    int answer = -1;
    nn = n;
    for(int i = 0; i < wires.size(); i++){
        // i는 끊어서
        init();
        for(int j = 0; j < wires.size(); j++){
            if(i == j)continue;
            int f = wires[j][0];
            int t = wires[j][1];
            adj[f].push_back(t);
            adj[t].push_back(f);
        }
        go();
    }
    answer = mi;
    return answer;
}