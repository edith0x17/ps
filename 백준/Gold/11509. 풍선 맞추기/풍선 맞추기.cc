#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;
int n;
int a[1000004];
int cnt;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int temp;
		cin >> temp;

		if (a[temp]) {
			a[temp]--;
			a[temp - 1]++;
		}
		else {
			cnt++;
			a[temp - 1]++;
		}
	}
	cout << cnt << "\n";
	return 0;
}