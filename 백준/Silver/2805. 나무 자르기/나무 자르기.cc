#include <iostream>
#include <algorithm>
using namespace std;
typedef long long ll;
ll n, m, v, ret;
ll a[1000004];
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;

    for(ll i = 0; i < n; i++){
        cin >> a[i];
        v = max(v, a[i]);
    }

    ll l = 0, r = v, mid;
    while(l <= r){ // 탈출 시 그 전 mid가 최대
        mid = (l + r) / 2; // 자를 높이 -> 최대로
        
        ll sum = 0;
        for(ll i = 0; i < n; i++){
            if(a[i] - mid > 0){
                sum += a[i] - mid; // 가져가는 양
            }
                
        }
        
        if(sum >= m){ // 가져가는 양 >= 가져가고 싶은 양 -> 더 높이 자르자
            ret = mid;
            l = mid + 1;
        }else{
            r = mid - 1;
        }
        
    }

    cout << ret << '\n';

    return 0;
}
