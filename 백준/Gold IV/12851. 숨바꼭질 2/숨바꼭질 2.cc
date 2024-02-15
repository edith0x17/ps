#include <iostream>
#include <queue>
using namespace std;
const int MAX = 200004;
int n, k, visited[MAX], cnt[MAX];
queue<int> q;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> k;
	if (n == k) {
		puts("0");
		puts("1");
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
				else if (visited[next] == visited[now] + 1) { // 시간
					cnt[next] += cnt[now];
				}
			}
		}
	}
	cout << visited[k] - 1 << '\n';
	cout << cnt[k] << '\n';
	return 0;
}