#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;
int n, m;
vector<pair<int, int>> v;
int a[104];

void FastIO() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
}

void Solve() {
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	cin >> m;

	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		v.push_back({ x, y });
	}

	for (pair<int, int> p : v) {// <성별, 스위치 번호>
		if (p.first == 1) { // 남자
			for (int i = 1; i <= n; i++) {
				if (i % p.second == 0) { // 배수 -> 반전
					if (a[i])a[i] = 0; // ON
					else a[i] = 1; // OFF
				}
			}
		}
		else { // 여자
			int left = p.second, right = p.second;

			int cnt = 0;
			while (true) {
				if (left - 1 < 1 || right + 1 > n)break;

				if (a[left - 1] != a[right + 1])break;

				left = left - 1;
				right = right + 1;
				cnt++;
			}

			if (cnt == 0) { // 대칭 X
				if (a[p.second])a[p.second] = 0;
				else a[p.second] = 1;
			}
			else { // 대칭 O
				for (int i = left; i <= right; i++) {
					if (a[i])a[i] = 0;
					else a[i] = 1;
				}
			}
		}
	}

	for (int i = 1; i <= n; i++) {
		cout << a[i] << " ";
		if (i % 20 == 0)cout << '\n';
	}
}

	



int main() {
	FastIO();
	Solve();
	return 0;
}