#include <string>
#include <vector>
#include <map>
#include <unordered_map> 
#include <tuple>
using namespace std;
 int answer = 0;
unordered_map<int, pair<int, int>> graph;// <번호, 좌표>
vector<map<pair<int, int>, int>> path;// [시간][좌표] = 방문횟수

void createPath(vector<int> route){
    pair<int, int> last;
    int time = 0;
    
    for(int i = 0; i < route.size() - 1; i++){
        pair<int, int> begin = graph[route[i]]; // 현재 포인트의 좌표
        pair<int, int> end = graph[route[i + 1]]; // 다음 포인트의 좌표
        last = end;
        
        while(begin != end){
            path[time][begin]++;
            if(path[time][begin] == 2) answer++;
            
            int xDiff = begin.first - end.first;
            int yDiff = begin.second - end.second;
            
            if (xDiff != 0) {
                if (xDiff < 0) begin.first++;
                else begin.first--;
            } else if (yDiff != 0) {
                if (yDiff < 0) begin.second++;
                else begin.second--;
            }
            time++;
        }
    }
    
    path[time][last]++;
    if(path[time][last] == 2) answer++;
}

int solution(vector<vector<int>> points, vector<vector<int>> routes) {
    for(int i = 0; i < points.size(); i++){
        graph[i + 1] = {points[i][0], points[i][1]};// n개의 포인트, 1번 부터~
    }
    
    path.resize(20001);
    
    for(vector<int> route: routes){
        createPath(route);
    }
    return answer;
}