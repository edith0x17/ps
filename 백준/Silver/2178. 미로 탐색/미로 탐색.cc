#include <bits/stdc++.h>
using namespace std;
const int dx[] = { -1, 0, 1, 0 };
const int dy[] = { 0, 1, 0, -1 };
int n, m;
int a[104][104], visited[104][104];

void bfs(int x, int y) {
	queue<pair<int, int>> q;

	visited[x][y] = 1;
	q.push({ x, y });
	while (!q.empty()) {
		tie(x, y) = q.front(); q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])continue;
			
			if (a[nx][ny] == 0)continue;

			visited[nx][ny] = visited[x][y] + 1;
			q.push({ nx, ny });
		}
	}
}
int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < m; j++) {
			a[i][j] = s[j] - '0';
		}
	}

	bfs(0, 0);

	cout << visited[n - 1][m - 1] << '\n';

	return 0;
}
