#include <iostream>
#include <vector>
#include <tuple>
#include <queue>
using namespace std;
const int dx[] = { -1, 0, 1, 0 };
const int dy[] = { 0, 1, 0, -1 };

int n;
int a[19][19], visited[19][19];
int sx, sy, ex, ey;
int ans;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
	
	int t;
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {

		// init
		fill(&a[0][0], &a[0][0] + 19 * 19, 0);
		fill(&visited[0][0], &visited[0][0] + 19 * 19, 0);

		// input
		cin >> n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> a[i][j];
			}
		}

		cin >> sx >> sy >> ex >> ey;

		queue<pair<int, int>> q;
		int x, y;
		
		visited[sx][sy] = 1;
		q.push({ sx, sy });
		while (q.size()) {
			tie(x, y) = q.front();
			q.pop();

			if (x == ex && y == ey) {
				ans = visited[x][y];
				ans = ans - 1;
				break;
			}
			else ans = -1;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])continue; // 범위 || 방문
				if (a[nx][ny] == 1)continue; // 장애물

				visited[nx][ny] = visited[x][y] + 1;
				q.push({ nx, ny });
			}
		}

		cout << "#" << tc << " " << ans << '\n';
	}
	

	return 0;
}