#include <iostream>
using namespace std;
int n;
int dp[1004];
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n;

	dp[1] = 1;
	dp[2] = 3;
	for(int i = 3; i <= n; i++){
		dp[i] = (dp[i-1] + dp[i-2] + dp[i-2]) % 10007;
	}
	
	cout << dp[n] % 10007 << '\n';
	return 0;
}