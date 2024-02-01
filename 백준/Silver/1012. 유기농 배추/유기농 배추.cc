#include <iostream>
#include <vector>
using namespace std;
const int dx[] = {-1, 0, 1, 0};
const int dy[] = {0, 1, 0, -1};

int t, m, n, k;
int a[54][54], visited[54][54];

void print(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cout << a[i][j] << ' ';
        }
        cout << '\n';
    }

}

void dfs(int x, int y){
    visited[x][y] = 1;
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx < 0 || nx >= n || ny < 0 || ny >= m)continue;

        if(a[nx][ny] == 1 && !visited[nx][ny]){
            dfs(nx, ny);
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    cin >> t;
    while(t--){
        int ret = 0;
        fill(&a[0][0], &a[0][0] + 54 * 54, 0);
        fill(&visited[0][0], &visited[0][0] + 54 * 54, 0);

        cin >> n >> m >> k;

        while(k--){
            int x, y;
            cin >> x >> y;

            a[x][y] = 1;
        }

        // print();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 1 && !visited[i][j]){
    			    ret++; dfs(i, j);
			    } 
            }
        }

        cout << ret << '\n';

        
    }
    return 0;
}