#include <iostream>
#include <vector>
using namespace std;
int n, m;

void solve(vector<int> b){
    if(b.size() == m){
        for(int num: b){
            cout << num << ' ';
        }
        cout << '\n';
        return;
    }

    for(int i = 1; i <= n; i++){
        b.push_back(i);

        solve(b);

        b.pop_back();
    }
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    cin >> n >> m;

    vector<int> b;
    solve(b);

    return 0;
}