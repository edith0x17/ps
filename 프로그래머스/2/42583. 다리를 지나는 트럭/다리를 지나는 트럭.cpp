#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int idx = 0, sum = 0;
    queue<int> q;
    while(1){
        // 마지막
        if(idx == truck_weights.size()){  
            answer += bridge_length;
            break;  
        }
        
        answer++;
        int here = truck_weights[idx];
        
        // 탈출
        if(q.size() == bridge_length){
            sum -= q.front();
            q.pop();
        }
        
        // 로직
        if(sum + here <= weight){
            sum += here;
            q.push(here);
            idx++;
        }else{
            q.push(0);
        }
    }
    return answer;
}