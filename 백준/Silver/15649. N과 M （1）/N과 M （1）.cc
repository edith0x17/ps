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
		if(!visited[i]){
			visited[i] = 1;
			b.push_back(a[i]);
			go(idx + 1, b);
			b.pop_back();
			visited[i] = 0;
		}
	}
}
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> m;
	for(int i = 0; i < n; i++){
		a[i] = i + 1;
	}
	vector<int> b;
	go(0, b);
	return 0;
}