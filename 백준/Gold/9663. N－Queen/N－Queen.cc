#include <iostream>
using namespace std;
int n, ret;
bool check[19], ch1[31], ch2[31]; // i + j, i - j

void solve(int idx){
    // 종료
    if(idx == n){
        // 시뮬레이션
        ret++;
        return;
    }

    // 실행, 재귀호출
    for(int j = 0; j < n; j++){ // 행 ↓, 0, 1, 2, ... 
        if(check[j])continue; // 행 열 체크
        if(ch1[idx + j])continue; // '/' 대각선 체크
        if(ch2[idx - j + n])continue; // '\' 대각선 체크 @@@ 

        check[j] = ch1[idx + j] = ch2[idx - j + n] = true;
        // -> 0번째 열에 0번째 행 에다가 놓음

        solve(idx + 1);

        check[j] = ch1[idx + j] = ch2[idx - j + n] = false;
        // -> 원복
    }

}
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> n;

    solve(0);

    cout << ret << '\n';

    return 0;
}