#include <bits/stdc++.h>
using namespace std;
int mi = 2000000000;
int n;
vector<int> a;
int ret1, ret2;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		int temp;
		cin >> temp;

		a.push_back(temp);
	}

	sort(a.begin(), a.end());

	int l = 0, r = n - 1;
	while (l < r) {
	
		int hap = a[l] + a[r];
		if (abs(hap) < abs(mi)){
			ret1 = a[l];
			ret2 = a[r];
			mi = hap;
		}

		if (hap == 0)break;

		if (hap < 0)l++;
		else r--;
	}

	cout << ret1 << " " << ret2 << "\n";
	return 0;
}