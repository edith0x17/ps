#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    // sort
    sort(people.begin(), people.end());
    // logic
    
    // r의 값과 l의 값을 더했을 때, 
    // 무게를 초과하지 않는다면 한번에 두명, 반대로, 무게를 초과한다면 r의 값만 보트에 태웁니다
    int l = 0, r = people.size() - 1;
    while(l <= r){
        if(people[l] + people[r] <= limit){
            l++;
        }
        r--;
        answer++;
    }
    return answer;
}