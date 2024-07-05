#include <bits/stdc++.h>
using namespace std;
const int dx[] = { -1, 0, 1, 0 };
const int dy[] = { 0, 1, 0, -1 };
// 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳
int n, m;
int a[14][14], aOri[14][14];
int visited[14][14];
vector<pair<int, int>> wallList, wall, virus;
int ret;

void init() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			// aOri
			a[i][j] = aOri[i][j];

			// visited
			visited[i][j] = 0;
		}
	}
}

int check() {
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] == 0)cnt++;
		}
	}
	return cnt;
}

void dfs(int x, int y) {
	visited[x][y] = 1;
	a[x][y] = 2;

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue; // 범위

		if (visited[nx][ny])continue; // 방문

		if (a[nx][ny] == 1 || a[nx][ny] == 2)continue; // 벽 || 바이러스

		dfs(nx, ny);
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
	
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
			aOri[i][j] = a[i][j];

			if (a[i][j] == 0) { // 
				wallList.push_back({ i, j });
			}
			else if (a[i][j] == 2) {
				virus.push_back({ i, j });
			}
		}
	}

	for (int i = 0; i < wallList.size(); i++) {
		for (int j = i + 1; j < wallList.size(); j++) {
			for (int k = j + 1; k < wallList.size(); k++) {
				// i j k
				init();

				a[wallList[i].first][wallList[i].second] = 1;
				a[wallList[j].first][wallList[j].second] = 1;
				a[wallList[k].first][wallList[k].second] = 1;

				for (auto a : virus) {
					dfs(a.first, a.second);
				}
				ret = max(ret, check());
			}
		}
	}

	cout << ret << "\n";

	return 0;
}