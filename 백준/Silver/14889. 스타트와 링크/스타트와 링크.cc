#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>
using namespace std;

int n, ret = 987654321;
int a[24][24];
bool visited[24];

void combi(int start, vector<int> b){

    if(b.size() == n / 2){
        
        int sumA = 0, sumB = 0;
        for(int j = 0; j < n; j++){
            for(int k = j + 1; k < n; k++){
                if(visited[j] && visited[k]){
                    sumA += a[j][k] + a[k][j];
                }else if(!visited[j] && !visited[k]){
                    sumB += a[j][k] + a[k][j];
                }
            }
        }
        
        ret = min(ret, abs(sumA - sumB));
        return;
    }

    for(int i = start + 1; i < n; i++){
        b.push_back(i);
        visited[i] = 1;

        combi(i, b);

        b.pop_back();
        visited[i] = 0;
    }
}
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> n;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }

    vector<int> b;
    combi(-1, b); // n C 2

    cout << ret << '\n';
    return 0;
}