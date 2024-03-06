#include <bits/stdc++.h>
using namespace std;
int n, k, ret;
vector<int> v;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> k;

	for (int i = 0; i < n; i++) {
		int temp;
		cin >> temp;
		v.push_back(temp);
	}

	sort(v.begin(), v.end());
	reverse(v.begin(), v.end());

	for (int i = 0; i < n; i++) {
		if (k % v[i] == k)continue;

		ret += k / v[i];
		k = k % v[i];
	}
	cout << ret << '\n';
	return 0;
}