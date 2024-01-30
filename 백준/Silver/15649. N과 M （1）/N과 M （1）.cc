#include <iostream>
#include <vector>
using namespace std;
int n, m;
int visited[12];

void solve(vector<int> b){
    // 종료
        // 시뮬레이션

    // 실행
    // 재귀호출
    if(b.size() == m){
        for(int num: b){
            cout << num << " ";
        }
        cout << '\n';
        return;
    }
    
    for(int i = 1; i <= n; i++){
        if(!visited[i]){
            visited[i] = 1;
            b.push_back(i);
            
            solve(b);
            
            visited[i] = 0;
            b.pop_back();
        }
    }
}
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    vector<int> b;
    solve(b);
    return 0;
}