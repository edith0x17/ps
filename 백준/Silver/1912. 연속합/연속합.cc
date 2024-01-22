#include <iostream>
#include <algorithm>
using namespace std;
int n, a[100004], d[100004], ret = -987654321;
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
	d[0] = a[0]; 

	// 메모이제이션
	for (int i = 1; i < n; i++) {
		d[i] = max(d[i - 1] + a[i], a[i]); // max(과거 + 현재, 현재)
	}

	// 로직
	for (int i = 0; i < n; i++) {
		ret = max(ret, d[i]);
	}

	cout << ret << '\n';
}

int main() {
	FastIO();
	Solve();
	return 0;
}