#include <bits/stdc++.h>
using namespace std;
int n, m;
vector<int> adj[1004];
int ind[1004];
queue<int> q;
vector<int> ret;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    cin  >> n >> m;
    
    for(int i = 0; i < m; i++){
        int k;
        cin >> k;

        int prev = 0;
        for(int j = 0; j < k; j++){
            int temp;
            cin >> temp;
            if(prev != 0){
                int f = prev, t = temp;

                adj[f].push_back(t);
                ind[temp]++;
            }
            prev = temp;
        }
    }

    for(int i = 1; i <= n; i++){ // 1 <= X <= n
        if(ind[i] == 0)q.push(i); // indegree 0인 노드 -> queue에 넣기
    }

    while(q.size()){
        int nowNode = q.front();
        q.pop();
    
        ret.push_back(nowNode);

        for(int nextNode: adj[nowNode]){
            ind[nextNode]--;

            if (ind[nextNode] == 0) {
               q.push(nextNode); // indegree 0인 노드 -> queue에 넣기
            }
        }
    }

    if(ret.size() == n){
        for(int i: ret){
            cout << i << "\n";
        }
    }else{
        cout << 0 << "\n";
    }

    return 0;
}