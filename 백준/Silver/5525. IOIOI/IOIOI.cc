#include <iostream>
#include <algorithm>
using namespace std;
int n, m;
string str;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> m >> str;

	int ans = 0;
	for (int i = 0; i < m; i++) {

		int k = 0; //IOI의 개수

		if (str[i] == 'O') continue;

		while (str[i + 1] == 'O' && str[i + 2] == 'I') {
			k++;

			if (k == n) {
				ans++;
				k--; // 
			}

			i += 2; 
		}
	}

	cout << ans << '\n';

	return 0;
}