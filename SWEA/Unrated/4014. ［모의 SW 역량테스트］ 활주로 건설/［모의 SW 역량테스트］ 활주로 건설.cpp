#include <iostream>
#include <cmath>
using namespace std;

int T, N, X, rst;
int map[20][20];

int isRange(int x) {
	if (x >= 0 && x < N) return true;
	return false;
}


int check(int map[]) {
	int lslope[20] = { 0, };
	int rslope[20] = { 0, };

	for (int x = 0; x < N - 1; x++) {
		if (abs(map[x] - map[x + 1]) >= 2) return false;
	}

	for (int x = 0; x < N - 1; x++) {
		if (map[x] == map[x + 1]) continue;

		if (map[x] < map[x + 1]) { // left slope -> map[x] < map[x + 1](오르막)
			for (int i = 0; i < X; i++) {
				int nx = x - i;
				if (!isRange(nx) || map[x] != map[nx] || lslope[nx]) return false;
			}

			for (int i = 0; i < X; i++) {
				int nx = x - i;
				lslope[nx] = 1;
			}
		}
		else { // right slope -> map[x] > map[x + 1](내리막)
			for (int i = 1; i <= X; i++) {
				int nx = x + i;
				if (!isRange(nx) || map[x + 1] != map[nx] || rslope[nx]) return false;
			}

			for (int i = 1; i <= X; i++) {
				int nx = x + i;
				rslope[nx] = 1;
			}
		}
		
	}

	for (int i = 0; i < N; i++) {
		if (rslope[i] && lslope[i]) return false;
	}

	return true;
}


void solve() {
	int idx, input[20];
	// 가로
	for (int i = 0; i < N; i++) {
		idx = 0;
		for (int j = 0; j < N; j++) {
			input[idx++] = map[i][j];
		}
		if (check(input)) rst++;
	}

	// 세로
	for (int i = 0; i < N; i++) {
		idx = 0;
		for (int j = 0; j < N; j++) {
			input[idx++] = map[j][i];
		}
		if (check(input)) rst++;
	}
}


int main() {
	cin >> T;
	for (int tc = 1; tc <= T; tc++) {
		cin >> N >> X;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cin >> map[i][j];
			}
		}
		rst = 0;

		solve();
		cout << "#" << tc << " " << rst << '\n';
	}
}