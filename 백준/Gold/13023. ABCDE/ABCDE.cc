#include <iostream>
#include <vector>
using namespace std;
vector<int> adj[2001];
bool visited[2001], flag;

void dfs(int cnt, int here) {
	if(flag)return; // 더 이상 탐색 X

	if(cnt == 5) { // 종료조건
		flag = true;
		return;
	}

	for (int there: adj[here]) {
		if(!visited[there]){
			visited[there] = true;

			dfs(cnt + 1, there);

			visited[there] = false;
		}
	}
}
int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		adj[x].push_back(y);
		adj[y].push_back(x);
	}

	for (int i = 0; i < n; i++) {
		visited[i] = true;

		dfs(1, i);

		visited[i] = false;
	}

	if (flag)cout << 1 << '\n';
	else cout << 0 << '\n';

	return 0;
}
