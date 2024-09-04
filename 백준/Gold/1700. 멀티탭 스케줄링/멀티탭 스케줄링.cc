#include <bits/stdc++.h>
using namespace std;

int n, k;
int a[104], multiTap[104];
int cnt;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> k;
	for (int i = 0; i < k; i++) {
		cin >> a[i];
	}

	for (int i = 0; i < k; i++) {
		bool flag = false;

		for (int j = 0; j < n; j++) {
			if (multiTap[j] == a[i]) {
				flag = true;
				break;
			}
		}
		if (flag)continue;

		for (int j = 0; j < n; j++) {
			if (multiTap[j] == 0) {
				flag = true;
				multiTap[j] = a[i];
				break;
			}
		}
		if (flag)continue;

		// a
		int lastNeed = -1, idx = -1;
		for (int j = 0; j < n; j++) { // multiTap
			int temp = 0;

			for (int t = i + 1; t < k; t++) {
				if (multiTap[j] == a[t])break; // multiTap -> a -> 가장 나중에
				temp++;
			}
			if (temp > lastNeed){
				lastNeed = temp;
				idx = j;
			}
		}
		multiTap[idx] = a[i];
		cnt++;
	}
	cout << cnt << "\n";
	return 0;
}