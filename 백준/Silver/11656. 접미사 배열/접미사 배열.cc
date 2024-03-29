#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
vector<string> v;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	string s;
	cin >> s;

	for (int i = 0; i < s.size(); i++) {
		string temp = "";
		for (int j = i; j < s.size(); j++) {
			// cout << s[j] << ' ';
			temp += s[j];
		}
		// cout << '\n';
		v.push_back(temp);
	}

	sort(v.begin(), v.end());

	for (string ss : v) {
		cout << ss << '\n';
	}
	return 0;
}
