#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
#include <algorithm>
using namespace std;
const int dx[] = {-1, 0, 1, 0};
const int dy[] = {0, 1, 0, -1};
int n, m, a[1004][1004], visited[1004][1004];
queue<pair<int, int>> q;


int check(){
    int mx = -987654321;
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(visited[i][j] == 0)return -1; // 안익은 토마토
            
            mx = max(mx, visited[i][j]);// 다 익은 토마토

        }
    }
    return mx - 1;
}


void go(){
    int x, y;

    while(q.size()){
        tie(x, y) = q.front(); q.pop();

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])continue; 

            if(a[nx][ny] == -1)continue; // 토마토 없는 곳

            if(a[nx][ny] == 0){
                a[nx][ny] = 1; // 익음
                visited[nx][ny] = visited[x][y] + 1;
                q.push({nx, ny});
            }
        }
    }

}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> m >> n; // 가로 세로

    int flag = 0;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];

            if(a[i][j] == -1)visited[i][j] = -1; // 토마토 없는 곳

            if(a[i][j] == 0)flag = 1;

            if(a[i][j] == 1){
                visited[i][j] = 1;
                q.push({i, j});
            }
        }
    }

    if(!flag)cout << 0;

    else{
        go();
        cout << check();
    }
    
    return 0;
}