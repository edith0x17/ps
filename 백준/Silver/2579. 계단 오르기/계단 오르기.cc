#include <iostream>
#include <algorithm>
using namespace std;
int n, a[304], d[304], ret = -987654321;
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

	// 기저사례
	d[1] = a[1]; 
	d[2] = a[1] + a[2];

	// 메모이제이션
	for (int i = 3; i <= n; i++) {
		d[i] =max(d[i - 2] + a[i], d[i - 3] + a[i - 1] + a[i]); // 
	}

	// 로직
	ret = d[n];

	cout << ret << '\n';
}

int main() {
	FastIO();
	Solve();
	return 0;
}