#include <iostream>
#include <string>
using namespace std;
int lastBit, num, ret; 
int cnt = 1, checkNum;


void solve(int nextNum) {

	string s = to_string(nextNum);

	for (int i = 0; i < s.size(); i++) {
		checkNum |= (1 << (s[i] - '0'));
	}

	if (lastBit == checkNum & ((1 << 10) - 1)) {
		ret = nextNum;
		return;
	}
		
	cnt++;
	solve(num * cnt);
}
int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	lastBit = (1 << 10) - 1;

	int t;
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		cnt = 1;
		checkNum = 0;

		cin >> num;

		solve(num);

		cout << '#' << tc << ' ' << ret << '\n';
	}
}