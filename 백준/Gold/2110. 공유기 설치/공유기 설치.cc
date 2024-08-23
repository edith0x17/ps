#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, c;
vector<int> a;
int ret;
bool go(int target){
    int cnt = 1;
    int prev = a[0];
    for(int i = 1; i < n; i++){
        if(a[i] - prev >= target){
            cnt++;
            prev = a[i];
        }
    }
    if(cnt >= c)return true;
    else return false;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    cin >> n >> c;
    a.resize(n);
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    sort(a.begin(), a.end());
    int l = 1, r = a[n - 1] - a[0];
    while(l <= r){
        int mid = (l + r)/ 2;
        
        if(go(mid)){
            ret = max(ret, mid);
            l = mid + 1;
        }
        else r = mid - 1;
    }
    cout << ret << "\n";
    return 0;
}