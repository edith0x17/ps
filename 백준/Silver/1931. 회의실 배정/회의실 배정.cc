#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n, ret;
vector<pair<int, int>> v;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    
    cin >> n;
    
    for(int i = 0; i < n; i++){
        int s, e;
        cin >> s >> e;
        v.push_back({e, s});
    }
    
    sort(v.begin(), v.end());
    
    int end = 0;
    
    for(pair<int, int> p: v){// {e, s}
        if(end <= p.second){
            end = p.first;
            ret++;
        }
    }
    
    cout << ret;
    
    return 0;
}