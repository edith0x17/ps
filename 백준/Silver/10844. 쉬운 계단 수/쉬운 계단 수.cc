#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int INF = 1000000000;

int n;
ll dp[104][14]; //길이 -> i, 끝자리 수 -> j
ll ret;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n;

	// 기저사례
	dp[1][0] = 0;
	for (int i = 1; i <= 9; i++) { //1~9
		dp[1][i] = 1;
	}

	// 전에꺼, 점화식, 바텀업
	for (int i = 2; i <= n; i++) { //길이 n
		for (int j = 0; j <= 9; j++) { // 끝자리 수 j
			if (j == 0)dp[i][j] = dp[i - 1][j + 1] % INF;
			else if(j == 9)dp[i][j] = dp[i - 1][j - 1] % INF;
			else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % INF;
		}
	}

	for (int i = 0; i <= 9; i++) {
		ret += dp[n][i];
	}

	cout << ret % INF << "\n";

	return 0;
}