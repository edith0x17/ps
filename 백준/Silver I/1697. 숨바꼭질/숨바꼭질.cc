#include <iostream>
#include <queue>
using namespace std;
const int MAX = 200004;
int n, k, visited[MAX], cnt[MAX];
queue<int> q;
int main() {
	cin >> n >> k;
	if (n == k) {
		puts("0");
		// puts("1");
		return 0;
	}
	visited[n] = 1;
	cnt[n] = 1;
	q.push(n);
	while (q.size()) {
		int now = q.front(); 
		q.pop();

		for (int next : {now - 1, now + 1, now * 2}) {

			if (0 <= next && next <= MAX - 1) {
				if (!visited[next]) {
					visited[next] = visited[now] + 1;
					q.push(next);

					cnt[next] += cnt[now];
				}
				else if (visited[next] == visited[now] + 1) {
					cnt[next] += cnt[now];
				}
			}
		}
	}
	cout << visited[k] - 1 << '\n';
	// cout << cnt[k] + 1 << '\n';
	return 0;
}