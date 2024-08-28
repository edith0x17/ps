#include <bits/stdc++.h>
using namespace std;
int n, s;
int a[24];
int ret;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
	
	cin >> n >> s;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	int S = (1 << n);
	for (int i = 1; i < S; i++) {
		vector<int> temp;
		for (int j = 0; j < n; j++) {
			if (i & (1 << j)) {
				temp.push_back(a[j]);
			}
			else continue;
		}
		int sum = 0;
		for (auto at : temp) {
			sum += at;
		}
		if (sum == s)ret++;
	}
	cout << ret << "\n";
	return 0;
}