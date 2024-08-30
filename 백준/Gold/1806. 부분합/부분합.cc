#include <bits/stdc++.h>
using namespace std;

int n, s;
int a[100004];
int mi = 987654321;
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> s;
	for(int i = 0; i < n; i++){
		cin >> a[i];
	}
	int start = 0, end = 0, sum = 0; // 시작, 끝
	while(start <= end){
		if(sum >= s){
			mi = min(mi, end - start);
			sum -= a[start++];
		}else if(end == n)break;
		else sum += a[end++];
	}
	if(mi == 987654321)cout << 0 << "\n";
	else cout << mi << "\n";
	return 0;
}