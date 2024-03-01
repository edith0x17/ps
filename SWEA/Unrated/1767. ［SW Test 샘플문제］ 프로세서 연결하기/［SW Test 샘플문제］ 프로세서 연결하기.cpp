#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
const int dx[] = {-1, 0, 1, 0};
const int dy[] = {0, 1, 0, -1};

int t, n, totalCnt, mx = -987654321, mi = 987654321;
int a[16][16], visited[16][16];
vector<pair<int, int>> vv;

void init(){
	totalCnt = 0;
	mx = -987654321, mi = 987654321;
	fill(&a[0][0], &a[0][0] + 16 * 16, 0);
	fill(&visited[0][0], &visited[0][0] + 16 * 16, 0);
	vv.clear();
}

bool isPossible(int x, int y, int d){
	int nx = x;
	int ny = y;

	while(true){
		nx += dx[d];
		ny += dy[d];

		if(nx < 0 || nx >= n || ny < 0 || ny >= n)return true;

		if(a[nx][ny] > 0)return false;
	}
}

int setStatus(int x, int y, int d, int s){

	int cnt = 0;
	int nx = x;
	int ny = y;
	while(true){
		nx += dx[d];
		ny += dy[d];

		if(nx < 0 || nx >= n || ny < 0 || ny >= n)break;
		a[nx][ny] = s;
		cnt++;
	}

	return cnt;
}

void go(int idx, int cCnt, int lCnt){ // cCnt -> 연결코어갯수, lCnt -> 전선길이의합

	// 가지치기
	if(cCnt + (totalCnt - idx) < mx) return; // 다 연결 다 연결 다 연결 < mx 

	if(idx == totalCnt){

		if(mx < cCnt){ // 최대 코어
			mx = cCnt;
			mi = lCnt;
		}else if(mx == cCnt){ // 최대 코어 -> 최소 전선
			if(mi > lCnt){
				mi = lCnt;
			}
		}
		return;
	}

	int x = vv[idx].first;
	int y = vv[idx].second;

	// 놓기(4방향)
	for(int i = 0; i < 4; i++){
		if(isPossible(x, y, i)){

			// 색칠 하기
			int len = setStatus(x, y, i, 2);

			go(idx + 1, cCnt + 1, lCnt + len);

			// 색칠 지우기
			setStatus(x, y, i, 0);
		}
	}

	// 안놓기
	go(idx + 1, cCnt, lCnt);
}
int main(){
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> t;

	for(int tc = 1; tc <= t; tc++){
		
		init();

		cin >> n;

		for(int i = 0; i < n; i++){

			for(int j = 0; j < n; j++){
				cin >> a[i][j];

				if(0 < i && i < n - 1 && 0 < j && j < n - 1 && a[i][j] == 1){
					vv.push_back({i, j});
					totalCnt++;
				}
			}
		}

		go(0, 0, 0);

		cout << "#" << tc << ' ' << mi << '\n';
	}
	return 0;
}