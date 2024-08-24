#include <bits/stdc++.h>
using namespace std;
int n, m, s, e;
vector<pair<int, int>> adj[10004];
int visited[10004];
int ret;

void dfs(int here, int weight) {

	visited[here] = 1;
	for (pair<int, int> there : adj[here]){
		if (!visited[there.first] && there.second >= weight) { // {there.first, there.second} -> {there, c}
			dfs(there.first, weight);
		}
	}
}

int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int f, t, c;
		cin >> f >> t >> c;
		adj[f].push_back({ t, c });
		adj[t].push_back({ f, c });
	}

	cin >> s >> e;

	int l = 0, r = 1000000000;
	while (l <= r) {
		fill(&visited[0], &visited[0] + 10004, 0);

		int mid = (l + r) / 2;

		dfs(s, mid);

		if (visited[e]){
            ret = mid;
            l = mid + 1;
        }
		else r = mid - 1;
	}

	cout << ret << '\n';

	return 0;
}
