#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
const int INF = 987654321;

int n, a[11], ret = INF;
int comp[11], visited[11];
vector<int> adj[11]; // 인접리스트

pair<int, int> dfs(int here, int color){ 
	pair<int, int> ret = {1, a[here]}; // {cnt, 인구수}

	visited[here] = 1;
	for(int there: adj[here]){
		if (comp[there] != color) continue; // 색깔이 다르면...

		if(visited[there])continue;

		pair<int, int> _temp = dfs(there, color);

		ret.first += _temp.first; // {cnt, 인구수}
		ret.second += _temp.second; // {cnt, 인구수}
	}
	
	return ret;
}

int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n;

	for(int i = 1; i <= n ;i++){
		cin >> a[i];
	}

	for(int i = 1; i <= n; i++){
		int m;
		cin >> m;

		for(int j = 1; j <= m; j++){
			int temp;
			cin >> temp;
			adj[i].push_back(temp);
			adj[temp].push_back(i);
		}
	}

	int S = (1 << n);
	for(int i = 1; i < S - 1; i++){
		fill(comp, comp + 11, 0);
		fill(visited, visited + 11, 0);

		int idx1 = -1, idx2 = -1; // 시작지점

		for(int j = 0; j < n; j++){

			if(i & (1 << j)){
				comp[j + 1] = 1; // 색칠 O
				idx1 = j + 1; 
			}else idx2 = j + 1; // 색칠 X
		}

		pair<int, int> comp1 = dfs(idx1, 1); // {시작지점, 색칠O}
		pair<int, int> comp2 = dfs(idx2, 0); // {시작지점, 색칠X}

		if (comp1.first + comp2.first == n) ret = min(ret, abs(comp1.second - comp2.second));

	}

	cout << (ret == INF ? -1 : ret) << '\n';

	return 0;
}