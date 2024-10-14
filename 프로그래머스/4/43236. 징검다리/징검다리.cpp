#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int distance, vector<int> rocks, int n) {
    int answer = 0;
    sort(rocks.begin(), rocks.end());
    int mi = 0, mx = distance;
    while(mi <= mx){
        int mid = (mi + mx)/ 2;// 최소길이
        int cnt = 0, prev = 0;
        for(int i = 0; i < rocks.size(); i++){
            if(rocks[i] - prev < mid)cnt++;
            else prev = rocks[i];
        }
        if(distance - prev < mid)cnt++;
        
        if(cnt <= n){// 최소길이 높이기
            answer = max(answer, mid);
            mi = mid + 1;
        }else{// 최소길이 낮추기
            mx = mid - 1;
        }
    }
    return answer;
}