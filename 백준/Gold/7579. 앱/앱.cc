#include <bits/stdc++.h>
using namespace std;
int n, k; 
int m[104], c[104];
int dp[104][10004]; // dp[i번째][j비용] = 최대메모리크기
int ret = 10000004;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    
    cin >> n >> k;

    for(int i = 1; i <= n; i++){
        cin >> m[i];
    }

    for(int i = 1; i <= n; i++){
        cin >> c[i];
    }

    for(int i = 1; i <= n; i++){
        for(int j = 0; j <= 10000; j++){
            if(c[i] <= j){
                dp[i][j] = max(dp[i - 1][j - c[i]] + m[i], dp[i - 1][j]);

                if(dp[i][j] >= k){
                    ret = min(ret, j);
                }      
            }else dp[i][j] = dp[i - 1][j];
        }
    }

    cout << ret << "\n";

    return 0;
}