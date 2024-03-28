#include <iostream>
#include <algorithm>
using namespace std;

int INF = 987654321;
int a[1004][1004];
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	int t;
	cin >> t;

	for (int tc = 1; tc <= t; tc++) {

		// INIT
		fill(&a[0][0], &a[0][0], 0);

		// INPUT
		int n;
		cin >> n;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = INF;
			}
		}

		// SETTING
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				cin >> a[i][j];
				if (i != j && a[i][j] == 0)a[i][j] = INF;
				// if(a[i][j] == 0)a[i][j] = INF;
			}
		}

		// LOGIC
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (k == i)continue; // k == i

				for (int j = 1; j <= n; j++) {
					if (i == j || k == j) continue; // i == j || k == j

					a[i][j] = min(a[i][j], a[i][k] + a[k][j]); // i j, i k k j	
				}
			}
		}

		int ret = INF;
		for (int i = 1; i <= n; i++) {
			int temp = 0;
			for (int j = 1; j <= n; j++) {
				temp += a[i][j];
			}
			ret = min(ret, temp);
		}

		cout << "#" << tc << " " << ret << '\n';
	}
	return 0;
}