#include <bits/stdc++.h>
using namespace std;
const int INF = 987654321;
const int dx[] = {-1, 0, 1, 0};
const int dy[] = {0, 1, 0, -1};
struct A{
    int x;
    int y;
    int weight;
};
struct cmp{
    bool operator()(A a, A b){
        return a.weight > b.weight;
    }
};

int n;
int p = 1;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    
    while(true){
        cin >> n;

        if(n == 0) break;

        int a[129][129] = {0, };
        int visited[129][129] = {0, };
        int cnt = 0;
        int d[129][129] = {0, };
        for(int i = 0; i < 129; i++){
            for(int j = 0; j < 129; j++){
                d[i][j] = INF;
            }
        }

        priority_queue<A, vector<A>, cmp> pq;

        // input
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cin >> a[i][j];
            }
        }

        d[0][0] = a[0][0];
        pq.push({0, 0, d[0][0]});

        while(!pq.empty()){
            A now = pq.top();
            pq.pop();

            if(visited[now.x][now.y]){
                continue;
            }
            visited[now.x][now.y] = 1;

            cnt++;
            if(cnt == n * n){
                break;
            }

            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;

                if(d[nx][ny] > d[now.x][now.y] + a[nx][ny]){
                    d[nx][ny] = d[now.x][now.y] + a[nx][ny];
                    pq.push({nx, ny, d[nx][ny]});
                }
            }
        }
        cout << "Problem " << p++ << ": " << d[n-1][n-1] << "\n";
    }
    return 0;
}