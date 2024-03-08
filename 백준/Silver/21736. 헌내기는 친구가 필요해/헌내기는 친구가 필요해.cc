#include <bits/stdc++.h>
using namespace std;
const int dx[] = { -1, 0, 1, 0 };
const int dy[] = { 0, 1, 0, -1 };
int n, m, cnt;
int a[604][604], visited[604][604];
int sx, sy, x, y;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			char ch;
			cin >> ch;

			if (ch == 'O')a[i][j] = 0; // 빈 공간
			else if(ch == 'X')a[i][j] = 1; // 벽
			else if(ch == 'I')sx = i, sy = j, a[i][j] = 0; // 도연
			else if(ch == 'P')a[i][j] = 3; // 사람
		}
	}

	queue<pair<int, int>> q;

	visited[sx][sy] = 1;
	q.push({ sx, sy });
	
	while (!q.empty()) {
		tie(x, y) = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])continue;

			if (a[nx][ny] == 1)continue;

			if (a[nx][ny] == 3)cnt++;

			visited[nx][ny] = visited[x][y] + 1;
			q.push({ nx, ny });
		}
	}

	if(!cnt)cout << "TT" << '\n';
	else cout << cnt << '\n';
	return 0;
}