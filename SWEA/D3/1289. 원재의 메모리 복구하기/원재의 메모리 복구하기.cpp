#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

int n, m;
vector<int> v;
map<string, int> mp;

void FastIO() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
}

void Solve() {
	int T, test_case;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case) {
		string s;
		cin >> s;

		int cnt = 0;

		if (s[0] == '1')cnt++;

		for (int i = 1; i < s.size(); i++) {
			if (s[i - 1] != s[i]) {
				cnt++;
			}
		}

		cout << "#" << test_case << " " << cnt << '\n';
	}
}

int main() {
	FastIO();
	Solve ();
	return 0;
}
/*
100 -> 011 -> 000
010 -> 000
*/