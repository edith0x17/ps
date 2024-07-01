#include <bits/stdc++.h>
using namespace std;
int t, n, m;
int dp[34][34];
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    
    // init
    for(int i = 0; i < 34; i++){
        for(int j = 0; j < 34; j++){
            if(j == 0 || i == j){ // nC0, nCn
                dp[i][j] = 1;
            }else if(i < j){ // 2C4...
                dp[i][j] = 0;
            }
        }
    }

    cin >> t;

    while(t-- > 0){
        cin >> n >> m;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(j <= i){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; // nCr = n-1Cr-1 + n-1Cr
                }
            }
        }

        cout << dp[m][n] << "\n";
    }
    
    return 0;
}