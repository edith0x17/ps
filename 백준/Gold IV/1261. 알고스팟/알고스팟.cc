#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;

struct Node {
	int row, col, breakWall;

	// 우선순위 큐에서 사용하기 위한 연산자 오버로딩
	bool operator<(const Node& other) const {
		return breakWall > other.breakWall; // 벽을 더 적게 부술수록 우선순위가 높음, 반대
	}
};

int row, col;
vector<vector<int>> map;
vector<vector<bool>> visited;
vector<int> dR = { 1, -1, 0, 0 };
vector<int> dC = { 0, 0, 1, -1 };

int pathFind(int startRow, int startCol) {
	priority_queue<Node> q;
	q.push({ startRow, startCol, 0 });
	visited[startRow][startCol] = true;

	while (!q.empty()) {
		Node a = q.top();
		q.pop();

		if (a.row == row - 1 && a.col == col - 1) {
			return a.breakWall;
		}

		for (int i = 0; i < 4; i++) {
			int dr = a.row + dR[i];
			int dc = a.col + dC[i];

			if (dr < 0 || dc < 0 || dr >= row || dc >= col)
				continue;
			if (visited[dr][dc])
				continue;

			if (map[dr][dc] == 0)
				q.push({ dr, dc, a.breakWall });
			else
				q.push({ dr, dc, a.breakWall + 1 });

			visited[dr][dc] = true;
		}
	}

	return 0;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> col >> row;

	map.resize(row, vector<int>(col));
	visited.resize(row, vector<bool>(col, false));

	for (int i = 0; i < row; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < col; j++) {
			map[i][j] = s[j] - '0';
		}
	}

	cout << pathFind(0, 0) << '\n';

	return 0;
}
