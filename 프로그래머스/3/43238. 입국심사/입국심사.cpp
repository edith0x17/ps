#include <string>
#include <vector>
#include <algorithm>
using namespace std;
typedef long long ll;
long long solution(int n, vector<int> times) {
    ll answer = 0;
    sort(times.begin(), times.end());
    ll mx = n * (ll)times.back();
    ll mi = 0;
    while(mi <= mx){
        ll mid = (mi + mx)/ 2;
        ll temp = 0;
        for(int i = 0; i < times.size(); i++){
            temp += mid/(ll)times[i];
        }
        if(temp >= n){
            answer = mid;
            mx = mid - 1;
        }else{
            mi = mid + 1;
        }
    }
    return answer;
}