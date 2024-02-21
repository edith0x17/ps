#include <bits/stdc++.h>
using namespace std;
int n, m;
vector<int> adj[104];
int visited[104];

void dfs(int here) {
	visited[here] = 1;
	for (int there : adj[here]) {
		if (visited[there])continue;
		
		dfs(there);
	}
}

void init() {
	for (int i = 0; i < 104; i++) {
		adj[i].clear();
	}
	fill(&visited[0], &visited[0] + 104, 0);
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int t;
	cin >> t;

	for (int tc = 1; tc <= t; tc++) {

		init();

		int cnt = 0;
		cin >> n >> m;

		for (int i = 0; i < m; i++) {
			int f, t;
			cin >> f >> t;
			adj[f].push_back(t);
			adj[t].push_back(f);
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				cnt++;
				dfs(i);
			}
		}

		cout << "#" << tc << ' ' << cnt << '\n';
	}
	return 0;
}