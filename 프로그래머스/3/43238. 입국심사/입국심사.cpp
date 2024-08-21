#include <string>
#include <vector>
#include <algorithm>
typedef long long ll;

using namespace std;

long long solution(int n, vector<int> times) {
    ll answer = 0;
    
    sort(times.begin(), times.end());
    
    ll mi = 0;
    ll mx = 1e18;
    
    while(mi <= mx){
        ll mid = (mi + mx)/ 2;
        
        ll temp = 0;
        for(int i = 0; i < times.size(); i++){
            temp += (mid/ (ll)times[i]);
        }
        
        if(temp >= n){
            mx = mid -1;
            answer = mid;
        }else{
            mi = mid + 1;
        }
    }
    
    return answer;
}