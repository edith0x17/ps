#include <bits/stdc++.h>
using namespace std;
const int dx[] = { -1, 0, 1, 0 };
const int dy[] = { 0, 1, 0, -1 };
int n, m;
int a[104][104], visited[104][104];
vector<pair<int, int>> v;

void dfs(int x, int y) {

	visited[x][y] = 1;

	if (a[x][y] == 1) {
		v.push_back({ x, y });
		return;
	}

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])continue;

		dfs(nx, ny);
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
		}
	}

	int cntTime = 0, cntLast = 0;
	while (true) {
		fill(&visited[0][0], &visited[0][0] + 104 * 104, 0);

		v.clear();

		cntLast = 0;
		
		dfs(0, 0); // 

		for (auto i : v) {
			a[i.first][i.second] = 0;
			cntLast++;
		} // 녹이기
		cntTime++;

		bool flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j])flag = true;
			}
		}
		
		if (!flag)break;
	}

	cout << cntTime << '\n' << cntLast << '\n';
	return 0;
}
