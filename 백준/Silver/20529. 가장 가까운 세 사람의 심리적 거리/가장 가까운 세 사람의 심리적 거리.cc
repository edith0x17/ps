#include <bits/stdc++.h>
using namespace  std;

int checkDistance(string &a, string &b) {
	int val = 0;

	for (int i = 0; i < 4; i++) {
		if (a[i] != b[i])val++;
	}
	return val;
}

int  main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	int t;

	cin >> t;

	while (t--) {
		int n;
		int val = INT_MAX;
		vector<string> v;

		cin >> n;

		for (int i = 0; i < n; i++) {
			string mbti;
			cin >> mbti;
			v.push_back(mbti);
		}

		if (n > 32) {
			cout << 0 << "\n";
		}
		else {

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					for (int k = j + 1; k < n; k++) {
						int dis = checkDistance(v[i], v[j]) + checkDistance(v[j], v[k]) + checkDistance(v[i], v[k]);
						val = min(val, dis);
					}
				}
			}

			cout << val << "\n";
		}
	}
}