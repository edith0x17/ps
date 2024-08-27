#include <bits/stdc++.h>
using namespace std;
int n, w, l;
int a[1004];
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> w >> l;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	queue<int> q;
	for (int i = 0; i < w; i++) {
		q.push(0);
	}
	int sum = 0, idx = 0, t = 0;
	while (idx < n) {
		t++;
		sum -= q.front();
		q.pop();

		if (sum + a[idx] <= l) {
			q.push(a[idx]);
			sum += a[idx];  // 다리 위의 무게에 추가!!!
			idx++;
		}
		else q.push(0);
	}
	while (!q.empty()) {
		t++;
		q.pop();
	}
	cout << t << "\n";
	return 0;
}
// queue
// 0 -> 시간