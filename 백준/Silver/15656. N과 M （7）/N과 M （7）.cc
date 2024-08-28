#include <bits/stdc++.h>
using namespace std;

int n, m;
int a[12], visited[12];
void go(int idx, vector<int> b){
	// 종료
		// 시뮬레이션
	if(idx == m){
		for(auto at: b){
			cout << at << " ";
		}
		cout << "\n";
		return;
	}

	for(int i = 0; i < n; i++){
		b.push_back(a[i]);
		go(idx + 1, b);
		b.pop_back();
	}
}
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> m;
	for(int i = 0; i < n; i++){
		cin >> a[i];
	}
	sort(a, a + n);
	vector<int> b;
	go(0, b);
	return 0;
}