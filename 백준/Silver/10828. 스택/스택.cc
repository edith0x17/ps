#include <bits/stdc++.h>
using namespace std;

int n;
stack<int> stk;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n;

	while (n-- > 0) {
		string s;
		cin >> s;

		if (s == "push") {
			int temp;
			cin >> temp;

			stk.push(temp);
		}
		else if (s == "pop") {
			if (stk.size() == 0)cout << -1 << "\n";
			else {
				cout << stk.top() << "\n";
				stk.pop();
			}
		}
		else if (s == "size") {
			cout << stk.size() << "\n";
		}
		else if (s == "empty") {
			cout << stk.empty() << "\n";
		}
		else if (s == "top") {
			if (stk.size() == 0)cout << -1 << "\n";
			else cout << stk.top() << "\n";
		}
	}

	return 0;
}