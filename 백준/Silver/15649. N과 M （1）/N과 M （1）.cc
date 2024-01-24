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
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		v.push_back(i + 1);
	}

	do {
		int cnt = 0;
		string s = "";
		for (int i : v) {
			// cout << i << " ";
			if (cnt == m)break;
			s += i + '0';
			s += " ";
			cnt++;
		}
		mp[s]++;
	} while (next_permutation(v.begin(), v.end()));

	for (pair<string, int>  i: mp) {
		cout << i.first << '\n';
	}

}

int main() {
	FastIO();
	Solve ();
	return 0;
}