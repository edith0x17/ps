#include <bits/stdc++.h>
using namespace std;

int n;
int a[15];
int visited[15];
string op;
int mi = 1000000004, mx = -1000000004;
int calculate(int a, int b, char oper) {
	if (oper == '+') return a + b;
	else if (oper == '-') return a - b;
	else if (oper == '*') return a * b;
	else return a / b;
}

void go(int idx, vector<char>& b) {
	if (idx == op.size()) {
		int ret = a[0];
		for (int i = 1; i < n; i++) {
			ret = calculate(ret, a[i], b[i - 1]); // op 대신 b 사용
		}
		mi = min(mi, ret);
		mx = max(mx, ret);
		return;
	}

	for (int i = 0; i < op.size(); i++) {
		if (!visited[i]) {
			visited[i] = 1;
			b.push_back(op[i]);
			go(idx + 1, b);
			b.pop_back();
			visited[i] = 0;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	int aa[4] = { 0 }; // 연산자의 개수
	char aaa[4] = { '+', '-', '*', '/' }; // 연산자 종류
	for (int i = 0; i < 4; i++) {
		cin >> aa[i];
	}
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < aa[i]; j++) { // j++로 수정
			op += aaa[i];
		}
	}

	vector<char> b;
	go(0, b);
	cout << mx << "\n";
	cout << mi << "\n";
	return 0;
}