#include <bits/stdc++.h>
using namespace std;
const int  dx[] = { -1, 0, 1, 0 };
const int dy[] = { 0, 1, 0, -1 };

int n, m, ret = -987654321;
int aOri[104][104], a[104][104], visited[104][104];
vector<pair<int, int>> virusList, wallList;

void init() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			a[i][j] = aOri[i][j];
		}
	}

	fill(&visited[0][0], &visited[0][0] + 104 * 104, 0);
}

void check() {

	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] == 0)cnt++;
		}
	}

	ret = max(ret, cnt);
}

void dfs(int x, int y) {
	
	visited[x][y] = 1;
	a[x][y] = 2;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue;

		if (a[nx][ny] != 0 || visited[nx][ny])continue;
		
		dfs(nx, ny);
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];

			aOri[i][j] = a[i][j];
			if (a[i][j] == 0)wallList.push_back({ i, j });
			else if(a[i][j] == 2)virusList.push_back({ i, j });
		}
	}

	int S = wallList.size();
	for (int i = 0; i < S; i++) {
		for (int j = i + 1; j < S; j++) {
			for (int k = j + 1; k < S; k++) {

				init();

				// i, j , k
				int x1 = wallList[i].first; int y1 = wallList[i].second;
				int x2 = wallList[j].first; int y2 = wallList[j].second;
				int x3 = wallList[k].first; int y3 = wallList[k].second;

				a[x1][y1] = 1;
				a[x2][y2] = 1;
				a[x3][y3] = 1;

				for (pair<int, int> p : virusList) {
					dfs(p.first, p.second);
				}
				check();
			}
		}
	}

	cout << ret << '\n';
	return 0;
}