#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;

int n, m;
unordered_map<int, int> mp;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n; 
	for (int i = 0; i < n; i++) {
		int temp;
		cin >> temp;

		mp.insert({ temp, 1 });
	}

	cin >> m;
	for (int i = 0; i < m; i++) {
		int temp;
		cin >> temp;
		
		if (mp[temp] != 0)cout << 1 << " ";
		else cout << 0 << " ";
	}
	return 0;
}