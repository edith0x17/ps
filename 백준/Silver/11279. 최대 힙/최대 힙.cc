#include <iostream>
#include <queue>
using namespace std;
int n;
priority_queue<int, vector<int>, less<int>> pq;

int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n;

	for (int i = 0; i < n; i++) {

		int x;
		cin >> x;
		if (x == 0) {
			if (!pq.empty()) {
				cout << pq.top() << '\n';
				pq.pop();
			}
			else cout << 0 << '\n';
		}
		else pq.push(x);
	}
	return 0;
}