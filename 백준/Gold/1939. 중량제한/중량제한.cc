#include <iostream>
#include <vector>
using namespace std;

int n, m, from, to, ret;
int visited[10004];
vector<pair<int, int>> v[10004];
// pair<int, int> 목적지, 중량제한
void dfs(int here, int ww) {
	for (pair<int, int> p : v[here]) {
		if (!visited[p.first] && p.second >= ww) { // 방문X && 가중치 >= ww

			visited[p.first] = 1;
			dfs(p.first, ww);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int f, t, w;
		cin >> f >> t >> w; // from to weight
		v[f].push_back({ t, w }); // to weight
		v[t].push_back({ f, w }); // from weight
	}

	cin >> from >> to;

	
	int l = 0, r = 1000000000;
	while (l <= r) {
		fill(&visited[0], &visited[0] + 10004, 0);

		int mid = (l + r) / 2;

		dfs(from, mid);

		if (visited[to]) {
			l = mid + 1;
		}
		else r = mid - 1;
	}

	cout << r << '\n';

	return 0;
}