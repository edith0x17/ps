#include <iostream>
#include <vector>
using namespace std;
int d[1004];
void FastIO() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
}

void Solve() {
	d[1] = 1;
	d[2] = 2;

	int n;
	cin >> n;

	for (int i = 3; i <= n; i++) {
		d[i] = (d[i - 1] % 10007) + (d[i - 2] % 10007); // d[i - 1] -> 가로 2, d[i - 2] -> 가로 1
		d[i] %= 10007;
	}
	cout << d[n] << '\n';
}
int main() {
	FastIO();
	Solve();
	return 0;
}