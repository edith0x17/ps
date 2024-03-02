#include <iostream>
#include <vector>
#include <tuple>
#include <queue>
using namespace std;
const int dx[] = {-1, 0, 1, 0};
const int dy[] = {0, 1, 0, -1};

int n, m, x, y;
int a[1004][1004], visited[1004][1004];
queue<pair<int, int>> q;
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> m;

	for (int i = 0; i < n; i++){
		for (int j = 0; j < m; j++){
			cin >> a[i][j];

			if (a[i][j] == 2){
				visited[i][j] = 1;
				q.push({i, j});
			}
		}
	}


	while (!q.empty()){
		tie(x, y) = q.front();
		q.pop();

		for (int i = 0; i < 4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])continue; // 범위

			if (a[nx][ny] == 0)continue;
				
			visited[nx][ny] = visited[x][y] + 1;
			q.push({nx, ny});
		}
	}

	for (int i = 0; i < n; i++){
		for (int j = 0; j < m; j++){
			if(visited[i][j] > 0)visited[i][j] = visited[i][j] - 1;

			if(a[i][j] == 1 && visited[i][j] == 0)visited[i][j] = -1;
		}
	}
	
	for (int i = 0; i < n; i++){
		for (int j = 0; j < m; j++){
			cout << visited[i][j] << ' ';
		}
		cout << '\n';
	}

	return 0;
}