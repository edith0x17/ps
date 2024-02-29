#include <bits/stdc++.h>
using namespace std;
const int  dx[] = { -1, 0, 1};
const int dy[] = { 1, 1, 1};

bool flag;
int n, m, cnt;
int  a[10004][504], visited[10004][504];
vector<pair<int, int>> bakerList;

void dfs(int x, int y) {
	visited[x][y] = 1;

	if (y == m - 1) {

		flag = true;
		cnt++;
		return;
	}

	for (int i = 0; i < 3; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue;

		if (a[nx][ny] == 1 || visited[nx][ny])continue;

		dfs(nx, ny);
		if (flag)return; // 종료
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			char ch;
			cin >> ch;
			if (ch == 'x')a[i][j] = 1; // 장애물
			else a[i][j] = 0; // 빈칸
		}
	}

	for(int i = 0; i < n; i++){
		// a[i][0]
		flag = false;
		dfs(i, 0);
	}

	cout << cnt << '\n';
	return 0;
}