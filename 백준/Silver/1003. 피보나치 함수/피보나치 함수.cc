#include <bits/stdc++.h>
using namespace std;
int T, n;
vector<pair<int, int>> v; // d[i] = d[i - 1] + d[i - 2] // <i, pair<int, int>> -> {cnt0, cnt1}

int fibonacci(int n) {
	if (n == 0) {
		// printf("0");
		return 0;
	}
	else if (n == 1) {
		// printf("1");
		return 1;
	}
	else {
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}

void init() {
	v.clear();
	v.push_back({ 1, 0 });
	v.push_back({ 0, 1 });
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> T;

	while (T--) {
		
		init();

		cin >> n;
		if (n < 2) {
			cout << v[n].first << ' ' << v[n].second << '\n';
		}
		else {
			for (int i = 2; i <= n; i++) {
				pair<int, int> p;
				p.first = v[i - 1].first + v[i - 2].first;
				p.second = v[i - 1].second + v[i - 2].second;
				v.push_back(p);
			}
			cout << v[n].first << ' ' << v[n].second << '\n';
		}
	}
	return 0;
}
