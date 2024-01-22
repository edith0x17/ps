#include <iostream>
#include <algorithm>
using namespace std;
int n, a[1004], d[1004], ret = -987654321;
void FastIO() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
}

void Solve() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	// 기저사례
	d[0] = 1;

	// 메모이제이션
	for (int i = 0; i < n; i++) {
		d[i] = 1;
		for (int j = 0; j < i; j++) {
			if (a[j] < a[i]) {
				d[i] = max(d[i], d[j] + 1);
			}
		}
		ret = max(ret, d[i]);
	}

	cout << ret << '\n';
}

int main() {
	FastIO();
	Solve();
	return 0;
}