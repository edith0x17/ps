#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> check(4, 0);
    int a[] = {1, 2, 3, 4, 5};// 5 
    int b[] = {2, 1, 2, 3, 2, 4, 2, 5};// 8
    int c[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};// 10
    
    for(int i = 0; i < answers.size(); i++){
        if(a[i % 5] == answers[i])check[1]++;
        if(b[i % 8] == answers[i])check[2]++;
        if(c[i % 10] == answers[i])check[3]++;
    }
    int mx = *max_element(check.begin(), check.end());
    for(int i = 0; i < 4; i++){
        if(mx == check[i]){
            answer.push_back(i);
        }
    }
    return answer;
}