#include <iostream>
#include <stack>
using namespace std;

int n;stack<pair<int, int>> st; // 높이, idx

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	st.push({ 100000001,0 });

	cin >> n;

	for (int i = 1; i <= n; i++) { 
		int height;

		cin >> height;

		while (st.top().first < height) {
			st.pop();
		}

		cout << st.top().second << ' ';

		st.push({height, i});
	}

	return 0;
}