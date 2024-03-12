#include <iostream>
#include <algorithm>
using namespace  std;
int n, m;
int a[1004][1004], dp[1004][1004];
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> m;

	for(int i = 1; i <= n; i++){

		for(int j = 1; j <= m; j++){
			cin >> a[i][j];
		}
	}

	for(int i = 1; i <= n; i++){

		for(int j = 1; j <= m; j++){
			dp[i][j] = a[i][j] + max(dp[i][j - 1], max(dp[i - 1][j - 1], dp[i - 1][j]));
		}
	}

	// for(int i = 1; i <= n; i++){
	// 	for(int j = 1; j <= m; j++){
	// 		cout << dp[i][j] << ' ';
	// 	}
	// 	cout << '\n';
	// }

	cout << dp[n][m] << '\n';
	return 0;
}