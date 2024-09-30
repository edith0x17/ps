#include <bits/stdc++.h>
using namespace std;
const int dx[] = { -1, 0, 1, 0 };
const int dy[] = { 0, 1, 0, -1 };
int r, c;
char a[1504][1504];
int visitedSwan[1504][1504], visitedWater[1504][1504];
queue<pair<int, int>> waterQ, waterTempQ, swanQ, swanTempQ;
pair<int, int> swan;
int day;

void Qclear(queue<pair<int, int>>& q) {
	queue<pair<int, int>> empty;
	swap(q, empty);
}

bool moveSwan() {
	while (swanQ.size()) {
		int x = swanQ.front().first;
		int y = swanQ.front().second;
		swanQ.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= r || ny < 0 || ny >= c || visitedSwan[nx][ny]) continue;
			visitedSwan[nx][ny] = 1;
			if (a[nx][ny] == '.') swanQ.push({ nx, ny });
			else if (a[nx][ny] == 'X') swanTempQ.push({ nx, ny });
			else if (a[nx][ny] == 'L') return true;
		}
	}
	return false;
}

void waterMelt() {
	while (waterQ.size()) {
		int x = waterQ.front().first;
		int y = waterQ.front().second;
		waterQ.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= r || ny < 0 || ny >= c || visitedWater[nx][ny]) continue;
			if (a[nx][ny] == 'X') {
				visitedWater[nx][ny] = 1;
				waterTempQ.push({ nx, ny });
				a[nx][ny] = '.';
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> r >> c;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> a[i][j];

			if (a[i][j] == 'L') swan = { i, j };// 백조
			if (a[i][j] == 'L' || a[i][j] == '.') visitedWater[i][j] = 1, waterQ.push({ i, j });// 백조 || 물
		}
	}

	swanQ.push({ swan.first, swan.second });
	visitedSwan[swan.first][swan.second] = 1;
	while (true) {
		if (moveSwan()) break;
		waterMelt();
		waterQ = waterTempQ;
		swanQ = swanTempQ;
		Qclear(waterTempQ);
		Qclear(swanTempQ);
		day++;
	}
	cout << day << "\n";
	return 0;
}