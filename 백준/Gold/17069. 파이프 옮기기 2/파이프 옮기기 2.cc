#include <iostream>
typedef long long ll;
using namespace std;
int n;
int a[36][36];
ll dp[36][36][3];
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
		}
	}

	// 초기화
	dp[0][1][0] = 1;

	for (int i = 0; i < n; i++) {
		for (int j = 2; j < n; j++) { // (0, 0), (0, 1) -> pipe
			
			if (a[i][j] == 0) { // 가로
				dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]; // 가로 + 대각선

				if (i - 1 >= 0) { // 세로
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]; // 세로 + 대각선

					if (a[i - 1][j] == 0 && a[i][j - 1] == 0) { // 대각선
						dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]; // 가로 + 세로 + 대각선
					}
				}
			}

		}
	}

	cout << dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2] << "\n";

	return 0;
}