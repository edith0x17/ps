#include <bits/stdc++.h>
using namespace std;
int n;
int a[200004];
unordered_map<int, int> mp; // 종류
int cnt, ret;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    
    cin >> n;

    for(int i = 0; i < n; i++){
        cin >> a[i];
    }

    int l = 0, r = 0;
    while(r < n){
        mp[a[r]]++;
        cnt++;

        while(mp.size() > 2){
            if(--mp[a[l]] == 0){
                mp.erase(a[l]);
            }
            
            cnt--;
            l++;
        }
        /*if (mp.size() > 2) {
            if (--mp[a[l]] == 0) {
                mp.erase(a[l]);
            }
            cnt--;
            l++;
        }*/

        ret = max(ret, cnt);

        r++;
    }
    
    cout << ret << "\n";
    return 0;
}