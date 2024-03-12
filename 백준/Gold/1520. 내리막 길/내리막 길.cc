#include <iostream>
using namespace  std;
const int dx[] = { -1, 0 ,1, 0 };
const int dy[] = { 0, 1, 0, -1 };
int n, m;
int a[504][504], visited[504][504];

int dfs(int x, int y) {

    if (x == n - 1 && y == m - 1)return 1; // 제일 오른쪽 아래 칸

    if (visited[x][y] != -1)return visited[x][y]; // // 방문 O

    visited[x][y] = 0; // 방문 O
    for (int i = 0; i < 4; i++) {
		// 4방향
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue; // 범위

        if (a[x][y] > a[nx][ny]) {
            visited[x][y] += dfs(nx, ny);
        }
    }

    return visited[x][y];
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }

    fill(&visited[0][0], &visited[0][0] + 504 * 504, -1); // -1

    cout << dfs(0, 0) << '\n';

    return 0;
}