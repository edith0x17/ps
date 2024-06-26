#include <bits/stdc++.h>
using namespace std;
int n, d, k, c;
vector<int> a;
unordered_map<int, int> mp;
int ret = -987654321;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    
    cin >> n >> d >> k >> c;

    for(int i = 0; i < n; i++){
        int temp;
        cin >> temp;
        a.push_back(temp);
    }
    for(int i = 0; i < k - 1; i++){
        a.push_back(a[i]);
        n++;
    }

    for(int i = 0; i < k; i++){
        mp[a[i]]++;
    }
    mp[c]++;

    int l = 0, r = k;
    for(int i = r; i < n; i++){
        // 왼
        if(--mp[a[l]] == 0){
            mp.erase(a[l]);
        }
        
        // 오
        mp[a[i]]++;

        l++;

        ret = max(ret, (int)mp.size());
    }

    cout << ret << "\n";
    return 0;
}
