#include <iostream>
#include <vector>
using namespace std;
int d[104];
void FastIO() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
}

void Solve() {
	d[1] = 1;
	d[2] = 2;
	d[3] = 4;
	int t;
	vector<int> v;
	cin >> t;

	for (int i = 0; i < t; i++) {
		int n;
		cin >> n;

		for (int j = 4; j <= n; j++) {
			d[j] = d[j - 1] + d[j - 2] + d[j - 3];
		}
		cout << d[n] << '\n';
	}
}
int main() {
	FastIO();
	Solve();
	return 0;
}