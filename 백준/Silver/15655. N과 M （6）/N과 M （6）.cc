#include <bits/stdc++.h>
using namespace std;
int n, m;
int a[12];
vector<int> temp;
void combi(int idx, int start){
	// 종료
		// 시뮬레이션
	if(idx == m){
		for(auto a: temp){
			cout << a << " ";
		}
		cout << "\n";
		return;
	}

	// 실행
	// 재귀
	for(int i = start; i < n; i++){
		temp.push_back(a[i]);
		combi(idx + 1, i + 1);
		temp.pop_back();
	}
}
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> m;
	for(int i = 0; i < n; i++){
		cin >> a[i];
	}
	sort(a, a + n);
	combi(0, 0);
	return 0;
}