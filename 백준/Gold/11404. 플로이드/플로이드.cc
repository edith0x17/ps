#include <bits/stdc++.h>
using namespace std;
long long a[101][101];
const long long inf = INT32_MAX;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	// inf 넣기
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			a[i][j] = inf;
		}
	}

	// 입력
	for (int i = 0; i < m; i++) {
		long long x, y, z;
		cin >> x >> y >> z;
		a[x][y] = min(a[x][y], z);
	}

	// k -> i > j
	// min(i => j, ik => kj)
	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {

			if (k == i)continue;

			for (int j = 1; j <= n; j++) {

				if (i == j || k == j)continue;

				a[i][j] = min(a[i][j], a[i][k] + a[k][j]);
			}
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (a[i][j] == inf)cout << 0 << ' ';
			else cout << a[i][j] << ' ';
		}
		cout << '\n';
	}
	return 0;
}