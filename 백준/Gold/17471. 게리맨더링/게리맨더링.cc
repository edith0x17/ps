#include <bits/stdc++.h>
using namespace std;
const int INF = 987654321;
int n, a[11], m, temp, ret = INF;
int comp[11], visited[11];
vector<int> adj[11]; // 인접리스트
pair<int, int> dfs(int here, int value) { // {here, 색칠여부}
	visited[here] = 1;

	pair<int, int> ret = {1, a[here]}; // {cnt, 인구수}

	for (int there : adj[here]) {
		if (comp[there] != value) continue; // 색깔이 다르면...

		if (visited[there]) continue;

		pair<int, int> _temp = dfs(there, value);

		ret.first += _temp.first; // {cnt, 인구수}
		ret.second += _temp.second; // {cnt, 인구수}
	}

	return ret;
}
int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n; // 인구수

	for (int i = 1; i <= n; i++) { // 도시 별 인구수
		cin >> a[i];
	}

	for (int i = 1; i <= n; i++) { // 인접리스트
		cin >> m;
		for (int j = 0; j < m; j++) {
			cin >> temp;
			adj[i].push_back(temp);
			adj[temp].push_back(i);
		}
	}

	for (int i = 1; i < (1 << n) - 1; i++) {
		fill(comp, comp + 11, 0);

		fill(visited, visited + 11, 0);

		int idx1 = -1, idx2 = -1; // start 지점

		for (int j = 0; j < n; j++){ // 색칠

			if (i & (1 << j)){ // on
				comp[j + 1] = 1; 
				idx1 = j + 1; 
			}
			else idx2 = j + 1; // off
		}

		pair<int, int> comp1 = dfs(idx1, 1); // {시작지점, 색칠O}
		pair<int, int> comp2 = dfs(idx2, 0); // {시작지점, 색칠X}

		if (comp1.first + comp2.first == n) ret = min(ret, abs(comp1.second - comp2.second));
	}

	cout << (ret == INF ? -1 : ret) << '\n';

	return 0;
}