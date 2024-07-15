#include <bits/stdc++.h>
using namespace std;

int n;
deque<int> dq;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n;

	while (n-- > 0) {
		string s;
		cin >> s;

		if (s == "push") {
			int temp;
			cin >> temp;

			dq.push_back(temp);
		}
		else if (s == "pop") {
			if (dq.size() == 0)cout << -1 << "\n";
			else {
				cout << dq.front() << "\n";
				dq.pop_front();
			}
		}
		else if (s == "size") {
			cout << dq.size() << "\n";
		}
		else if (s == "empty") {
			cout << dq.empty() << "\n";
		}
		else if (s == "front") {
			if (dq.size() == 0)cout << -1 << "\n";
			else cout << dq.front() << "\n";
		}
		else if (s == "back") {
			if (dq.size() == 0)cout << -1 << "\n";
			else cout << dq.back() << "\n";
		}
	}

	return 0;
}