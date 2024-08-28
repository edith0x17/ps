#include <bits/stdc++.h>
using namespace std;

int n, m;
int a[12], visited[12];
set<vector<int>> s;

void go(int idx, vector<int> b){
	if(idx == m){
		s.insert(b);
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
		cin >> a[i];
	}
	sort(a, a + n);
	vector<int> b;
	go(0, b);
	for(auto at: s){
		for(auto num: at){
			cout << num << " ";
		}
		cout << "\n";
	}
	return 0;
}