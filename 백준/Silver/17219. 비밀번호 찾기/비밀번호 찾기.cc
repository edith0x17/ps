#include <iostream>
#include <unordered_map>
using namespace std;
int n, m;
unordered_map<string, string> mp;

int main(){
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	cin >> n >> m;

	for(int i = 0; i < n; i++){
		string s, ss;
		cin >> s >> ss;
		mp[s] = ss;
	}

	for(int i = 0; i < m; i++){
		string s;
		cin >> s;
		cout << mp[s] << '\n';
	}

	return 0;
}