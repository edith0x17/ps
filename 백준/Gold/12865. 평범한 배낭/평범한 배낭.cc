#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
const int MAX = 104;
int n, k;
int weight[MAX], value[100004];
int d[MAX][100004];

void FastIO(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}

/* 
    d[i][j] = k
    i번째 물건까지 왔고,
    가방의 무게가 j일때,
    가방에 담긴 물건의 가치는 k 입니다
*/
void Solve(){
    cin >> n >> k;

    for(int i = 1; i <= n; i++){
        int w, v;
        cin >> w >> v;
        weight[i] = w;
        value[i] = v;
    }

    /*
        1) 가방에 담을 수 있냐 없냐
        2) 가방에 담냐 안담냐
    */
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= k; j++){
            if(j >= weight[i]){ // 가방에 담을 수 O
                d[i][j] = max(d[i - 1][j - weight[i]] + value[i], d[i - 1][j]); // 담는 경우, 담지 않는 경우
            }else{ // 가방에 담을 수 X
                d[i][j] = d[i - 1][j];
            }
        }
    }

    cout << d[n][k] << '\n';
}

int main(){
    FastIO();
    Solve();
    return 0;
}