#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
const int dx[] = {-1, 0, 1, 0};
const int dy[] = {0, 1, 0, -1};
const int n = 5;

int ret;
int a[9][9], aTemp[9][9], visited[9][9];
vector<pair<int, int>> vv;

int dfs(int x, int y){
	int ret = 1;

	visited[x][y] = 1;
	for(int i = 0; i < 4; i++){
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx < 0 || nx >= n || ny < 0 || ny >= n)continue;

		if (aTemp[nx][ny] == 1 && !visited[nx][ny]){
			ret += dfs(nx, ny);
		}
	}

	return ret;
}

bool colorCheck(vector<int> temp){

	int cntS = 0, cntY = 0;
	for(int num = 0; num < temp.size(); num++){
		int x = vv[temp[num]].first;
		int y = vv[temp[num]].second;
		if(a[x][y] == 1)cntS++;
		else cntY++;
	}

	if(cntY < cntS)return true;
	else return false;
}

bool connectCheck(vector<int> temp){
	
	fill(&aTemp[0][0], &aTemp[0][0] + 9 * 9, 0);
	fill(&visited[0][0], &visited[0][0] + 9 * 9, 0);

	for(int num = 0; num < temp.size(); num++){
		int x = vv[temp[num]].first;
		int y = vv[temp[num]].second;
		
		aTemp[x][y] = 1;
	}

	int x = vv[temp[0]].first;
	int y = vv[temp[0]].second;

	if(dfs(x, y) == 7){
		return true;
	}

	return false;
}

void combi(int start, vector<int> b){
	if(b.size() == 7){

		if(colorCheck(b)){
			if(connectCheck(b))ret++;
		}
		return;
	}

	for(int i = start + 1; i < vv.size(); i++){
		b.push_back(i);
		combi(i, b);
		b.pop_back();
	}
}

int main(){
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){

			char ch;
			cin >> ch;
			if(ch == 'S')a[i][j] = 1;
			else a[i][j] = 2;

			vv.push_back({i, j});
		}
	}

	vector<int> b;
	combi(-1, b);

	cout << ret << '\n';
	return 0;
}