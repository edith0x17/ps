/*
!!!더 빨리 오는 경우!!!
{ 이동횟수, 능력사용횟수 }
*/

#include <iostream>
#include <tuple>
#include <queue>
using namespace std;
const int dx[] = { -1, 0, 1, 0 };
const int dy[] = { 0, 1, 0, -1 };
const int hdx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
const int hdy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
int k, n, m;
int a[204][204];
int visited[204][204][204];
queue<pair<pair<int, int>, pair<int, int>>> q; //{{x, y}, {이동횟수, 능력사용횟수}}...
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> k;

	cin >> m >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
		}
	}

	int sx = 0, sy = 0, ex = n - 1, ey = m - 1;

	visited[sx][sy][0] = 1;
	q.push(make_pair(make_pair(sx, sy), make_pair(0, 0)));
	while (q.size()) {
		int x = q.front().first.first;
		int y = q.front().first.second;
		int cnt = q.front().second.first;
		int ability = q.front().second.second;
		q.pop();

		// 도착
		if (x == n - 1 && y == m - 1) {
			// cout << "visited[x][y][ability] : " << visited[x][y][ability] - 1 << '\n';
			cout << cnt << '\n';
			return 0;
		}

		// 능력 사용 O
		if (ability < k) {
			for (int i = 0; i < 8; i++) {
				int nx = x + hdx[i];
				int ny = y + hdy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue; //범위

				if (a[nx][ny] == 0 && visited[nx][ny][ability + 1] == 0) {

					visited[nx][ny][ability + 1] = visited[x][y][ability] + 1; //[x][y] 가는데 ability씀

					q.push(make_pair(make_pair(nx, ny), make_pair(cnt + 1, ability + 1)));
				}
			}
		}
		// 능력 사용 X
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue; //범위

			if (a[nx][ny] == 0 && visited[nx][ny][ability] == 0) { //[x][y] 가는데 ability씀

				visited[nx][ny][ability] = visited[x][y][ability] + 1;

				q.push(make_pair(make_pair(nx, ny), make_pair(cnt + 1, ability)));
			}
		}
	}

	cout << -1 << '\n';
	return 0;
}