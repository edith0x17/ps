#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<int> adj[2004];
int visited[2004];
bool flag;
void dfs(int depth, int here) {

	if (depth == 5) {
		flag = true;
		cout << 1 << '\n';
		exit(0);
	}

	for (int there : adj[here]) {
		if (!visited[there]) {
			visited[there] = 1;

			dfs(depth + 1, there);

			visited[there] = 0;
		}
	}

}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int t, f;
		cin >> t >> f;

		adj[t].push_back(f);
		adj[f].push_back(t);
	}

	for (int i = 0; i < n; i++) {

		dfs(0, i);

		if (flag)break;
	}

	if (flag)cout << 1 << '\n';
	else cout << 0 << '\n';

	return 0;
}