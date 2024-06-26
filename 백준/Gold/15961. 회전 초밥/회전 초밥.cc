#include <bits/stdc++.h>
using namespace std;

int n, d, k, c, ret;
vector<int> a;
unordered_map<int, int> mp;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    
    cin >> n >> d >> k >> c;

    for(int i = 0; i < n; i++){
        int temp;
        cin >> temp;

        a.push_back(temp);
    }

    // 원형 리스트를 위해 앞의 k - 1개 요소를 배열 끝에 추가
    for (int i = 0; i < k - 1; i++) {
        a.push_back(a[i]);
        n++;
    }

    // 처음 k개의 요소와 쿠폰 초밥을 맵에 추가
    for(int i = 0; i < k; i++){
        mp[a[i]]++;
    }
    mp[c]++;

    int l = 0, r = k;

    // 슬라이딩 윈도우를 사용하여 초밥 종류 계산
    for(int i = r; i < n; i++){
        // 왼쪽 요소 제거
        if(--mp[a[l]] == 0){
            mp.erase(a[l]);
        }

        // 오른쪽 요소 추가
        mp[a[i]]++;

        // 현재 초밥 종류의 최대값 갱신
        ret = max(ret, (int)mp.size());

        // 슬라이딩 윈도우 l++
        l++;
    }

    cout << ret << "\n";

    return 0;
}
