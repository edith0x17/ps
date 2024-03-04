#include <bits/stdc++.h>
using namespace std;

int n, m, mi = 987654321, idx;
vector<int> adj[104];
int visited[104];

int bfs(int here, int target) {
	queue<int> q;
	visited[here] = 1;
	q.push(here);
	while (q.size()) {
		int here = q.front(); q.pop();

		if (here == target) {
			return visited[here];
			break;
		}

		for (int there : adj[here]) {
			if (visited[there]) continue;
			visited[there] = visited[here] + 1;
			q.push(there);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int f, t;
		cin >> f >> t;

		adj[f].push_back(t);
		adj[t].push_back(f);
	}

	for (int i = 1; i <= n; i++){
		sort(adj[i].begin(), adj[i].end());
	}

	
	for (int i = 1; i <= n; i++) {

		int sum = 0;
		for (int j = 1; j <= n; j++) {
			fill(&visited[0], &visited[0] + 104, 0);

			if (i == j)continue;

			int temp = bfs(i, j);
			sum += temp;
		}
		
		if (sum < mi) {
			mi = sum;
			idx = i;
		}
	}

	cout << idx << '\n';
	return 0;
}