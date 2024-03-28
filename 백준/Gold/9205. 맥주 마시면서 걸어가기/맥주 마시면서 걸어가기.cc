#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>
using namespace std;
int INF = 987654321;

int t, n;
vector<pair<int, int>> vv;
int a[104][104];
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> t;
	while (t--) {
		vv.clear();
		vv.push_back({ 0, 0 }); // idx 시작 1...
		fill(&a[0][0], &a[0][0] + 104 * 104, 0);

		cin >> n;
		for (int i = 1; i <= n + 2; i++) {
			int f, t;
			cin >> f >> t;
			vv.push_back({ f, t });
		}

		// table 
		for (int i = 1; i <= n + 2; i++) {
			for (int j = i + 1; j <= n + 2; j++) {
				a[i][j] = a[j][i] = INF;

				int d = abs(vv[i].first - vv[j].first) + abs(vv[i].second - vv[j].second);

				if (d <= 20 * 50) a[i][j] = a[j][i] = 1;
			}
		}

		// k -> i -> j
		for (int k = 1; k <= n + 2; k++) {
			for (int i = 1; i <= n + 2; i++) {

				if (k == i)continue;
				for (int j = 1; j <= n + 2; j++) {

					if (i == j || k == j)continue;

					// (i, j) || (i, k, k, j)
					a[i][j] = min(a[i][j], a[i][k] + a[k][j]);
				}
			}
		}

		if (0 < a[1][n + 2] && a[1][n + 2] < INF)cout << "happy" << '\n';
		else cout << "sad\n";
	}
	return 0;
}