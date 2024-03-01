#include <iostream>
#include <map>
using namespace std;
int n, m, cnt;
map<string, int> mp;

int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> m;

	for(int i = 0; i < n; i++){
		string s;
		cin >> s;
		mp[s]++;
	}

	for(int i = 0; i < m; i++){
		string s;
		cin >> s;
		mp[s]++;
	}

	for(auto a: mp){
		if(a.second >= 2)cnt++;
	}
	cout << cnt << '\n';

	for(auto a: mp){
		if(a.second >= 2)cout << a.first << '\n';
	}
	
	return 0;
}