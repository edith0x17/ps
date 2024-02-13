#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
int t, n, k;
int w;
vector<int> adj[1004];
int ind[1004];
int time1[1004];
int ans[1001];
queue<int> q;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> t;
    while(t--){

        cin >> n >> k;

        for(int i = 1; i <= n; i++){
            cin >> time1[i];

            ans[i] = 0; // 초기화
            ans[i] = time1[i]; // 누적

            ind[i] = 0; // 초기화
            adj[i].clear(); // 초기화
        }

        for(int i = 0; i < k; i++){
            int f, t;
            cin >> f >> t;

            adj[f].push_back(t);
            ind[t]++;
        }

        cin >> w;

        for(int i = 1; i <= n; i++){
            if(ind[i] == 0)q.push(i);
        }

        // 위상정렬
        while(!q.empty()){
            int nowNode = q.front();
            q.pop();

            for(int nextNode: adj[nowNode]){    
                ans[nextNode] = max(ans[nextNode], ans[nowNode] + time1[nextNode]); // (현재노드 + 다음노드), 다음노드 -> max

                ind[nextNode]--;
                if (ind[nextNode] == 0) {
                    q.push(nextNode);
                }
            }
        }

        cout << ans[w] << '\n';
    }
    return 0;
}