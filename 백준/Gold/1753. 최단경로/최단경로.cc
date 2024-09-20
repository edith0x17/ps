#include <bits/stdc++.h>
using namespace std;
const int INF = 987654321;

struct A {
	int to;
	int weight;
};
struct cmp {
	bool operator()(const A& a, const A& b)const {
		return a.weight > b.weight;// 오름차순
	}
};
int v, e, k;
int visited[200004], d[200004];
vector<A> vv[200004];
priority_queue<A, vector<A>, cmp> pq;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> v >> e >> k;
	for (int i = 0; i < e; i++) {
		int f, t, w;
		cin >> f >> t >> w;
		vv[f].push_back({ t, w });
	}
	for (int i = 0; i <= v; i++) {
		d[i] = INF;
	}

	d[k] = 0;
	pq.push({k, d[k]});
	while (pq.size()) {
		A here = pq.top();
		pq.pop();

		for (A there : vv[here.to]) {
			if (visited[there.to])continue;

			if (d[there.to] > d[here.to] + there.weight) {
				d[there.to] = d[here.to] + there.weight;
				pq.push({ there.to, d[there.to] });
			}
		}
	}
	for (int i = 1; i <= v; i++) {
		if (d[i] == INF)cout << "INF\n";
		else cout << d[i] << "\n";
	}
	return 0;
}