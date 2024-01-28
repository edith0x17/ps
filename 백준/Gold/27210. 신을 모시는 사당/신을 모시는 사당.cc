#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n, ret;
vector<int> a; // 원본
void FastIO(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}

void Solve(){
    cin >> n;
    for(int i = 0; i < n; i++){
        int temp;
        cin >> temp;
        a.push_back(temp);
    }

    // 1) 왼쪽 기준
    vector<int> a1; // 카피1
    int d1[100004] = {0, };
    for(int i = 0; i < n; i++){
        if(a[i] == 2){
            a1.push_back(-1);
        }else{
            a1.push_back(1);
        }
    }
    // 기저사례
    d1[0] = a1[0];

    // 메모이제이션
    for(int i = 1; i < n; i++){
        d1[i] = max(d1[i - 1] + a1[i], a1[i]); // max(과거 + 현재, 현재)
    }

    // 로직
    for(int i = 0; i < n; i++){
        ret = max(ret, d1[i]);
    }

     // 1) 오른쪽 기준
    vector<int> a2; // 카피2
    int d2[100004] = {0, };
    for(int i = 0; i < n; i++){
        if(a[i] == 1){
            a2.push_back(-1);
        }else{
            a2.push_back(1);
        }
    }
    // 기저사례
    d2[0] = a2[0];

    // 메모이제이션
    for(int i = 1; i < n; i++){
        d2[i] = max(d2[i - 1] + a2[i], a2[i]); // max(과거 + 현재, 현재)
    }

    // 로직
    for(int i = 0; i < n; i++){
        ret = max(ret, d2[i]);
    }

    cout << ret << '\n';

}

int main(){
    FastIO();
    Solve();
    return 0;
}