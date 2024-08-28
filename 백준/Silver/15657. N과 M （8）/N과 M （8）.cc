#include <bits/stdc++.h>
using namespace std;

int n, m;
int a[12], visited[12];
void combi(int idx, int start, vector<int> b){
	if(idx == m){
		for(auto at: b){
			cout << at << " ";
		}
		cout << "\n";
		return;
	}

	for(int i = start; i < n; i++){
		b.push_back(a[i]);
		combi(idx + 1, i, b);
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
	combi(0, 0, b);
	return 0;
}