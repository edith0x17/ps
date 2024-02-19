#include <iostream>
#include <algorithm>
#include <vector>
#define MAX 987654321
#define MIN -987654321
using namespace std;
int mx, mi;
int getCalc(int n1, int n2, char op) {
	if (op == '+') return n1 + n2;
	if (op == '-') return n1 - n2;
	if (op == '*') return n1 * n2;
	if (op == '/') return n1 / n2;
	return 0;
}
int main(void) {
	int T;
	cin >> T;

	for (int t = 1; t <= T; t++) {
		mx = MIN;
		mi = MAX;

		int n; 
		cin >> n;

		vector<char> op;
		vector<int> num;

		for (int i = 0; i < 4; i++) {
			int in;  cin >> in;
			for (int j = 0; j < in; j++) {
				if (i == 0) op.push_back('+');
				else if (i == 1) op.push_back('-');
				else if (i == 2) op.push_back('*');
				else op.push_back('/');
			}
		}

		for (int i = 0; i < n; i++) {
			int temp;
			cin >> temp;
			num.push_back(temp);
		}

		int S = op.size();

		sort(op.begin(), op.end());

		do {
			int hap = num[0];
			for (int k = 0; k < S; k++) {
				hap = getCalc(hap, num[k + 1], op[k]);
			}

			mx = max(mx, hap);
			mi = min(mi, hap);
		} while (next_permutation(op.begin(), op.end()));

		cout << "#" << t << ' ' << mx - mi << '\n';
	}
}
