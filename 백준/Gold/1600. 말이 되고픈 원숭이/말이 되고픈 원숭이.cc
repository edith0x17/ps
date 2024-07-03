#include <bits/stdc++.h>
using namespace std;
const int dx[] = { -1, 0, 1, 0 };
const  int dy[] = { 0, 1, 0, -1 };
const  int hx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
const  int hy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
struct A {
	int x;
	int y;
	int d;
	int kCnt;
};
queue<A> q;

int k, n, m;
int a[204][204], visited[204][204][34];

int bfs() {
	visited[0][0][0] = 1;
	q.push({ 0, 0, 0, 0 });

	while (!q.empty()) {
		A now = q.front();
		q.pop();

		if (now.x == n - 1 && now.y == m - 1) {
			return now.d;
		}

		if (now.kCnt < k) {
			for (int i = 0; i < 8; i++) {
				int nx = now.x + hx[i];
				int ny = now.y + hy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue; // 범위
				if (visited[nx][ny][now.kCnt + 1])continue; // 방문

				if (a[nx][ny] == 1)continue; // 장애물

				visited[nx][ny][now.kCnt + 1] = 1;
				q.push({nx, ny, now.d + 1, now.kCnt + 1});
			}
		}

		for (int i = 0; i < 4; i++) {
			int nx = now.x + dx[i];
			int ny = now.y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue; // 범위
			if (visited[nx][ny][now.kCnt])continue; // 방문

			if (a[nx][ny] == 1)continue; // 장애물

			visited[nx][ny][now.kCnt] = 1;
			q.push({nx, ny, now.d + 1, now.kCnt});
		}
	}

	return -1;
}
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> k >> m >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
		}
	}

	cout << bfs() << "\n";

	return 0;
}