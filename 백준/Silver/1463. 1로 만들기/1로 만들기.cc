#include <bits/stdc++.h>
using namespace std;
int n;
int dp[1000004];
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    
    cin >> n;

    dp[0] = 0;
    dp[1] = 0;

    for(int i = 2; i <= n; i++){
        // i 
        int mi = dp[i - 1] + 1;

        if(i % 3 == 0)mi = min(mi, dp[i/ 3] + 1);

        if(i % 2 == 0)mi = min(mi, dp[i/ 2] + 1);

        dp[i] = mi;
    }

    cout << dp[n] << "\n";
    return 0;
}