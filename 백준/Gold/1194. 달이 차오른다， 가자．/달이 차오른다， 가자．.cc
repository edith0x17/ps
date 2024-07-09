#include <bits/stdc++.h>
using namespace std;
const int dx[] = {-1, 0, 1, 0};
const int dy[] = {0, 1, 0, -1};
struct A{
    int x;
    int y;
    int d;
    int key;
};

int n, m;
char a[54][54];
int visited[54][54][64]; //[xPos][yPos][a ~ f]
int sx, sy;
int bfs(){
    queue<A> q;

    visited[sx][sy][0] = 1;
    q.push({sx, sy, 0, 0}); // {x, y, d, key}

    while(!q.empty()){
        A now = q.front(); 
        q.pop();
        
        if(a[now.x][now.y] == '1'){
            return now.d;
        }

        for(int i = 0; i < 4; i++){
            int nx = now.x + dx[i];
            int ny = now.y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny][now.key] || a[nx][ny] == '#')continue; // 범위 || 방문 || 벽

            // 열쇠
            if('a' <= a[nx][ny] && a[nx][ny] <= 'f'){
                int nextKey = (1 << (a[nx][ny] - 'a')); // 
                nextKey = nextKey | now.key;

                visited[nx][ny][nextKey] = 1;
                q.push({nx, ny, now.d + 1, nextKey});
            }
            // 문
            else if('A' <= a[nx][ny] && a[nx][ny] <= 'F'){
                if((now.key & 1 << (a[nx][ny] - 'A')) == (int)pow(2, a[nx][ny] - 'A')) { // 해당 비트 ON || OFF 확인
                    visited[nx][ny][now.key] = 1;
                    q.push({nx, ny, now.d + 1, now.key});
                }
            }
            // .
            else{
                visited[nx][ny][now.key] = 1;
                q.push({nx, ny, now.d + 1, now.key});
            }
        }
    }

    return -1;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    
    cin >> n >> m;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];

            // sx sy
            if(a[i][j] == '0'){
                sx = i;
                sy = j;
            }
        }
    }
    
    cout << bfs() << "\n";

    return 0;
}