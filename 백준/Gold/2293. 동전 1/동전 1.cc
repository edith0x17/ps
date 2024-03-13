#include <iostream>
using namespace std;
int n, k;
int a[104];
int dp[10004];

int main(){
   ios_base::sync_with_stdio(false); cin.tie(NULL);cout.tie(NULL);

   cin >> n >> k;

   for(int i = 1; i <= n; i++){
      cin >> a[i];
   }

   dp[0] = 1; // 아무 동전도 선택하지 않은 경우
   for(int i = 1; i <= n; i++){
      
      int here = a[i];
      for(int j = here; j <= k; j++){
         dp[j] = dp[j] + dp[j - here];
      }
   }

  cout << dp[k] << '\n';

   return 0;
}