#include <bits/stdc++.h>
using namespace std;
int k, sum;
int cnt;
vector<int> arr, measure;
void go(int idx, int weight){
	if(idx == k){
		if(weight >= 0)measure[weight] = 1;
		return;
	}

	go(idx + 1, weight + arr[idx]); // + 추(왼쪽)
	go(idx + 1, weight - arr[idx]); // + 반대편 추(오른쪽)
	go(idx + 1, weight); // 추 점프
}

int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> k;
	arr.resize(k);
	for(int i = 0; i < k; i++){
		cin >> arr[i];
		sum += arr[i];
	}
	measure.resize(sum + 4);
	go(0, 0);
	for(int i = 1; i <= sum; i++){
		if(measure[i] == 0)cnt++;
	}
	cout << cnt << "\n";
	return 0;
}