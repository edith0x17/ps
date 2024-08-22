#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;
// 묻는 바를 반대로 생각하여 n개의 돌을 없애서 돌 사이 거리의 최솟값이 x로 만들 수 있는가? 
int solution(int distance, vector<int> rocks, int n) {
    int answer = 0;
    
    sort(rocks.begin(), rocks.end());
    
    int l = 0, r = distance;
    while(l <= r){
        int cnt = 0;
        int mid = (l + r)/ 2;
        
        int prev = 0;
        for(int i = 0; i < rocks.size(); i++){
            if(rocks[i] - prev < mid)cnt++; // 삭제할 돌
            else prev = rocks[i];
        }
        if(distance - prev < mid) cnt++;
        
        if(cnt <= n){
            answer = max(answer, mid);
            l = mid + 1;
        }else r = mid - 1;
    }
    
    return answer;
}