#include <bits/stdc++.h>
using namespace std;

// 0 -> 가로, 1 -> 대각선, 2 -> 세로
const int dx[] = { 0, 1, 1 };
const int dy[] = { 1, 1, 0 };

int n, cnt;
int a[24][24];
void dfs(int x, int y, int dir) {

	if (x == n - 1 && y == n - 1) {
		cnt++;
		return;
	}

	for (int i = 0; i < 3; i++) {

		if ((dir == 0 && i == 2) || (dir == 2 && i == 0)) continue;

		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx < 0 || nx >= n || ny < 0 || ny >= n || a[nx][ny]) continue;

		if (i == 1 && (a[x + 1][y] || a[x][y + 1]) ) continue; 

		dfs(nx, ny, i);
	}

}
int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
		}
	}

	dfs(0, 1, 0);

	if (cnt != 0)cout << cnt << '\n';
	else cout << 0 << '\n';
	return 0;
}