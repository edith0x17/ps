#include <bits/stdc++.h>
using namespace std;
int n, m;
int ind[32004];
vector<int> adj[32004];
queue<int> q;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;

    for(int i = 0; i < m; i++){
        int f, t;
        cin >> f >> t;

        adj[f].push_back(t);
        ind[t]++; // 해당 노드 indegree++
    }

    for(int i = 1; i <= n; i++){ 
        if (ind[i] == 0)q.push(i); // indegree 0인 노드 -> queue에 넣기
    }

    while(!q.empty()){ // nextNode, nowNode
        int nowNode = q.front(); 
        q.pop();

        cout << nowNode << ' ';
        
        for(int nextNode: adj[nowNode]){
            
            ind[nextNode]--; // 해당 노드 indegree--

            if (ind[nextNode] == 0) {
               q.push(nextNode); // indegree 0인 노드 -> queue에 넣기
            }
        }
    }

    return 0;
}