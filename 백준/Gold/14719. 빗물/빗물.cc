#include <bits/stdc++.h>
using namespace std;
int h, w;
int a[504];
int sum = 0;
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> h >> w;
	for(int i = 0; i < w; i++){
		cin >> a[i];
	}
	// 한 인덱스에서
	for(int i = 1; i < w - 1; i++){
		int left = 0, right = 0;
		int start, end;
		// 왼쪽에서 제일 큰
		for(int j = i; j >= 0; j--){
			left = max(left, a[j]);
		}
		// 오른쪽에서 제일 큰
		for(int j = i; j < w; j++){
			right = max(right, a[j]);
		}
		// 물 높이 - 자기 높이 빼기
		sum += (min(left, right) - a[i]);
	}
	cout << sum << "\n";
	return 0;
}