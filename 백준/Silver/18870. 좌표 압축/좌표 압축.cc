#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

int n;
vector<int> v, vOri;
unordered_map<int, int> mp;
int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n;

	for(int i = 0; i < n; i++){
		int temp;
		cin >> temp;
		v.push_back(temp);
		vOri.push_back(temp);
	}

	sort(v.begin(), v.end());

	int cnt = 0;
	for(int i = 0; i < n; i++){
		if(mp.find(v[i]) == mp.end()){
			mp[v[i]] = cnt++;
		}
	}

	for(int i = 0; i < n; i++){
		cout << mp[vOri[i]] << ' ';
	}
	return 0;
}