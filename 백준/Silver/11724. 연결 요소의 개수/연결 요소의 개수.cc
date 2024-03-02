#include <iostream>
#include <vector>
using namespace std;
int n, m, cnt;
vector<int> adj[1004];
int visited[1004];

void dfs(int here){

	int ret = 1;
	visited[here] = 1;
	for(int there: adj[here]){
		if(visited[there])continue;
		dfs(there);
	}
}

int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> m;

	for(int i = 0; i < m; i++){
		int f, t;
		cin >> f >> t;
		adj[f].push_back(t);
		adj[t].push_back(f);
	}

	for(int i = 1; i <= n; i++){
		
		if(!visited[i]){
			cnt++;
			dfs(i);
		}
	}

	cout << cnt << '\n';

	return 0;
}