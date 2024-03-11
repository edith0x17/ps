#include <bits/stdc++.h>
using namespace std;
const int dh[] = { 1, -1, 0, 0, 0, 0 };
const int dx[] = { 0, 0, -1, 0, 1, 0 };
const int dy[] = { 0, 0, 0, 1, 0, -1 };

struct A{
	int h;
	int x;
	int y;
};
// A a[104];
// A visited[104];
queue<A> q;
int n, m, l; // 세로 가로 높이
int a[104][104][104], visited[104][104][104];

int go() {
	int mx = -987654321;
	for (int i = 0; i < l; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				if (a[i][j][k] == 0 && visited[i][j][k] == 0)return -1; // 익지 X && 익지 X
				mx = max(mx, visited[i][j][k]);
			}
		}
	}
	return mx;
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> m >> n >> l;

	bool flag = false;
	for (int i = 0; i < l; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				cin >> a[i][j][k];

				if (a[i][j][k] == 0)flag = true; // 익음 X

				if (a[i][j][k] == 1) { // 익음 O
					A temp;
					temp.h = i, temp.x = j, temp.y = k;

					visited[i][j][k] = 1;
					q.push(temp);
				}

				// if(a[i][j][k] == -1)visited[i][j][k] = -1; // 토마토 X
			}
		}
	}

	if (!flag) {
		cout << 0 << '\n';
		return 0;
	}
	else {

		while (!q.empty()) {
			A temp;
			temp.h = q.front().h; temp.x = q.front().x; temp.y = q.front().y;
			q.pop();

			for (int i = 0; i < 6; i++) {
				int nh = temp.h + dh[i];
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];

				if (nh < 0 || nh >= l || nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nh][nx][ny])continue;

				if (a[nh][nx][ny] == 1 || a[nh][nx][ny] == -1)continue; // 익음 O || 토마토 X 

				A aaa;
				aaa.h = nh; aaa.x = nx; aaa.y = ny;

				visited[nh][nx][ny] = visited[temp.h][temp.x][temp.y] + 1;
				q.push(aaa);
			}
		}

		int ret = go();
		if (ret == -1)cout << -1 << '\n';
		else cout << ret - 1 << '\n';
	}

	return 0;
}
