// cmp, sort(x, x, cmp) 알아보기
// 최대 => 최소를 작게 or 최대를 크게
#include<bits/stdc++.h>
using namespace std;
int n, a, b, ret;
vector<pair<int, int>> v;
priority_queue<int, vector<int>, greater<int>> pq;// 오름차순
int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> a >> b; v.push_back({ b, a });// d, p
	}

	sort(v.begin(), v.end());

	for (int i = 0; i < n; i++) { // d일 안에...

		pq.push(v[i].second);

		if (pq.size() > v[i].first) {
			pq.pop();
		}
	}

	while (pq.size()) {
		ret += pq.top(); pq.pop();
	}
	cout << ret << "\n";
}