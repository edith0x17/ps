#include <iostream>
using namespace std;
typedef long long ll;
// F[N] = F[N - 1] + F[N - 5]
int t, n;
ll dp[104];
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> t;

    dp[1] = dp[2] = dp[3] = 1;
    dp[4] = dp[5] = 2;

    while(t--){
        cin >> n;

        for(int i = 6; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        cout << dp[n] << '\n';
    }
    return 0;
}