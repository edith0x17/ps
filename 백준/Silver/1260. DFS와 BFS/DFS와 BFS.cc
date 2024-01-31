#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
int n, m, v;
int visited1[1004], visited2[1004];
vector<int> adj[1004];

void dfs(int here) {
	visited1[here] = 1;
	cout << here << " ";
	for (int there : adj[here]) {
		if (visited1[there])continue;
		dfs(there);
	}
}

void bfs(int here) {
	queue<int> q;
	visited2[here] = 1;
	cout << here << " ";
	q.push(here);
	while (q.size()) {
		here = q.front();
		q.pop();
		for (int there : adj[here]) {
			if (visited2[there])continue;
			visited2[there] = visited2[here] + 1;
			cout << there << " ";
			q.push(there);
		}
	}
	
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m >> v;
	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		adj[x].push_back(y);
		adj[y].push_back(x);
	}

	for (int i = 0; i <= n; i++) {
		sort(adj[i].begin(), adj[i].end());
	}

	dfs(v); 

	cout << '\n';

	bfs(v);

	return 0;
}