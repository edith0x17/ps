#include <bits/stdc++.h>
using namespace std;
int n, p;
vector<int> a;

int go() {
	int ret = 0;

	for (int i = 0; i < n; i++) {
		int l = i, r = n - 1, mid;

		while (l <= r) {
			mid = (l + r)/ 2;
			int blank = (a[mid] - a[i] + 1) - (mid - i + 1);

			if (blank > p) { 
				r = mid - 1;
			}
			else {
				l = mid + 1;
				ret = max(ret, (a[mid] - a[i] + 1) + (p - blank));
			}
		}
	}

	return ret;
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	int t;
	cin >> t;

	for (int tc = 1; tc <= t; tc++) {
		a.clear();

		cin >> n >> p;

		for (int i = 0; i < n; i++) {
			int temp;
			cin >> temp;

			a.push_back(temp);
		}

		cout << "#" << tc << " " << go() << "\n";
	}
	return 0;
}