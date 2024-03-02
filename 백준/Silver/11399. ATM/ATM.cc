#include <iostream>
#include <queue>
using namespace std;
int n;
int a[1004];
int aSum[1004];
priority_queue<int, vector<int>, greater<int>> pq;

int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n;

	for(int i = 0; i < n; i++){
		int x;
		cin >> x;
		pq.push(x);
	}

	int idx = 0;
	while(!pq.empty()){
		a[idx++] = pq.top();
		pq.pop();
	}

	aSum[0] = a[0];
	for(int i = 1; i < n; i++){
		aSum[i] = aSum[i - 1] + a[i];
	}

	int sum = 0;
	for(int i = 0; i < n; i++){
		sum += aSum[i];
	}
	
	cout << sum << '\n';
	return 0;
}